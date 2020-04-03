/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.utils.Utils;
import AwayFromTheMilkyWay.view.GamePane;
import AwayFromTheMilkyWay.view.GameWindow;
import AwayFromTheMilkyWay.view.View;
import java.util.Vector;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author giorg
 */
public class ControllerForView implements IControllerForView {
    private static ControllerForView instance;
    double positioningX;
    double positioningY;
    private double spaceshipX;
    private double spaceshipY;
    private double spaceshipX2;
    private double spaceshipY2;
    private double startSpaceshipX;
    private double startSpaceshipY;
    private double mousePositionX;
    private double mousePositionY;
    Circle spaceship;
    EventHandler<MouseEvent> handler;
    Point2D NrotatedNormal;
    
    
    
     GameWindow gameWindow = View.getInstance().getGameWindow();
     GamePane gamePane = gameWindow.getSchermataGioco();
     Circle cir = gamePane.getPlanet1();
    
    
    
    
    //variabili per il movimento
    int t = 2;
    double x;
    double y;
    double magnitude;
    double xstab;
    double ystab;
    Point2D shipSpeed;
    double variableSpaceshipX;
    double variableSpaceshipY;
    Timeline timeline;
    Timeline timeline2;
    
    
    //costanti
    
    private final int WINLENGTH = 1280;
    private final int WINHEIGHT = 720;
    private final int SPACESHIPRADIUS = 50;
    
    public ControllerForView(){
        
    }
      
           
    public static IControllerForView getInstance() {
        if(instance == null)
            instance = new ControllerForView();
        return instance;
    }
    
    
    @Override
    public void setName (String nome){
        GameWindow schermataGioco ;
        schermataGioco = View.getInstance().getGameWindow();
        schermataGioco.setName(nome);
    
    }
    
    
    @Override
    public double getSpaceshipCenterX(){
        GamePane gp = View.getInstance().getGameWindow().getSchermataGioco();
        return gp.getSpaceship().getCenterX();
    }
    
    @Override
    public double getSpaceshipCenterY(){
        GamePane gp = View.getInstance().getGameWindow().getSchermataGioco();
        return gp.getSpaceship().getCenterY();
    }
    
    
    //commento inutile
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //METODI PER IL MOVIMENTO
    @Override
    public void movimento(){
        
        GameWindow gameWindow = View.getInstance().getGameWindow();
        GamePane gamePane = gameWindow.getSchermataGioco();
        gamePane.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        
        spaceship = gamePane.getSpaceship();
        startSpaceshipX = spaceship.getCenterX();
        startSpaceshipY = spaceship.getCenterY();
        
        
        x = mousePositionX-startSpaceshipX;
        y = mousePositionY-startSpaceshipY;
        System.out.println("mouse x e mouse y : "+mousePositionX+" ; "+mousePositionY);
        magnitude = Math.sqrt(x*x+ y*y);
        xstab = x / magnitude;
        ystab = y / magnitude;
        //System.out.println("angolo: "+Math.toDegrees(Math.atan2(ystab, xstab)));
        
        

     
        timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move(1))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
     
    @Override
    public void move(double v){
        variableSpaceshipX = ControllerForModel.getInstance().getSpaceshipCenterX();
        variableSpaceshipY = ControllerForModel.getInstance().getSpaceshipCenterY();
        
        
        if (variableSpaceshipX + SPACESHIPRADIUS <= WINLENGTH && variableSpaceshipY + SPACESHIPRADIUS <= WINHEIGHT
            && variableSpaceshipX - SPACESHIPRADIUS >= 0 && variableSpaceshipY - SPACESHIPRADIUS >= 0 ){//condizioni per mantenere la navicella dentro ai bordi
            
            /*double dx = cir.getCenterX() - variableSpaceshipX;
            double dy = cir.getCenterY() - variableSpaceshipY;*/
            double dx = variableSpaceshipX - cir.getCenterX();
            double dy =  variableSpaceshipY - cir.getCenterY();
            double distNum = Math.sqrt(dx*dx+ dy*dy);
            
            if(distNum >= SPACESHIPRADIUS+cir.getRadius() ){
                shipSpeed = new Point2D(xstab *t,ystab*t);
                //spaceshipX = xstab * t;//posso considerare queste come le velocità.
                //spaceshipY = ystab * t;
                //velocità = xstab *t/ 0,025 pixel al secondo
                System.out.println("vx e vy : "+shipSpeed.getX() +" ; "+shipSpeed.getY());
                spaceship.setTranslateX(shipSpeed.getX()/*spaceshipX*/);
                spaceship.setTranslateY(shipSpeed.getY()/*spaceshipY*/);
                
                ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+/*spaceshipX*/shipSpeed.getX());
                ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+/*spaceshipY*/shipSpeed.getY());
                spaceship.setCenterX(ControllerForModel.getInstance().getSpaceshipCenterX());
                spaceship.setCenterY(ControllerForModel.getInstance().getSpaceshipCenterY());

                //t++;
            }else{
                
                t=1;
                double dxNorm = -dx / distNum;
                double dyNorm = -dy / distNum;//direzioni della retta che unisce i due centri
                Point2D normal = new Point2D(dxNorm,dyNorm);
        
                double tgx = -dyNorm;
                double tgy = dxNorm;
                
                Point2D center = new Point2D(spaceship.getCenterX(),spaceship.getCenterY());
                Point2D vect1 = new Point2D(center.getX() - startSpaceshipX, center.getY() - startSpaceshipY);
                Point2D Nvect1 = vect1.normalize();/*unisce il centro dell'astro quando va a sbattere al centro iniziale*/
                Point2D vect2 = new Point2D(cir.getCenterX() - startSpaceshipX, cir.getCenterY() - startSpaceshipY);
                Point2D Nvect2 = vect2.normalize();/*unisce il piantea e l'astronave nella sua posizione iniziale*/
                
                double A = normal.angle(shipSpeed);
                double B = vect1.angle(vect2);
                System.out.println("angolo B : "+ B);
                //System.out.println("componenti vettori normalizzati: "+Nvect1.toString()+Nvect2.toString());
                int g ;
                Point2D s;
                s = new Rotate(-B,0,0).transform(Nvect2.getX(), Nvect2.getY());
                System.out.println("Nvect1 . "+Nvect1.toString());
                System.out.println("vettore s: "+s.toString());
                System.out.println("Nvect2 : "+Nvect2.toString());
                System.out.println(truncate(s.getX())+" = "+ truncate(Nvect1.getX())+ " && "+truncate(s.getY())+" = "+truncate(Nvect1.getY()));
                if(startSpaceshipX!= cir.getCenterX() || startSpaceshipY != cir.getCenterY()){
                    if (truncate(s.getX()) == truncate(Nvect1.getX()) && truncate(s.getY()) == truncate(Nvect1.getY()))
                        A=-A;
                }//else if((s.getX()) == (Nvect2.getX()) && (s.getY()) == (Nvect2.getY()))
                   //     A=-A;
                
                
                
                
        
                //double num = dxNorm * shipSpeed.getX()/*spaceshipX*/ + dyNorm * shipSpeed.getY()/*spaceshipY*/;
                //double den = (Math.sqrt(dxNorm*dxNorm + dyNorm*dyNorm))*(Math.sqrt(shipSpeed.getX()*shipSpeed.getX()+shipSpeed.getY()*shipSpeed.getY()/*spaceshipX*spaceshipX + spaceshipY*spaceshipY*/));
                //double cosA = num/den;
                //System.out.println("coseno: "+cosA);
                //double A = Math.toDegrees(Math.acos(cosA));
                
                
               
                
                System.out.println("angolo: "+A);
                System.out.println("spaceshipX : "+ spaceshipX );
                System.out.println("spaceshipY : "+ spaceshipY );
                System.out.println("ceterx spaceship :"+ spaceship.getCenterX());
                System.out.println("cetery spaceship :"+ spaceship.getCenterY());
      
                //DA RICORDARE CHE SE VOGLIAMO UTILIZZARE QUESTO METODO PER TUTTE LE ROTAZIONI è NECESSARIO METTERE AL POSOTO DI startSpaceshipX e startspaShipY DEI RIFERIMENTI ALLA POSIZIONE DI PARTENZA DELL 'ASTRONAVE DOPO L'ULTIMO RIMBALZO.
                Point2D rN = new Rotate(-2*A,spaceship.getCenterX(),spaceship.getCenterY()).transform(startSpaceshipX, startSpaceshipY); 
                double diffX = rN.getX()- spaceship.getCenterX();
                double diffY = rN.getY()- spaceship.getCenterY();
                //double rad = Math.sqrt((rN.getX()*rN.getX())+(rN.getY()*rN.getY()));
                //NrotatedNormal = new Point2D(rN.getX()/rad, rN.getY()/rad);
                double rad = Math.sqrt((diffX*diffX)+(diffY*diffY));
                NrotatedNormal = new Point2D(diffX/rad, diffY/rad);
                System.out.println("rotatedX : "+NrotatedNormal.getX());
                System.out.println("rotatedY : "+NrotatedNormal.getY());
                
                timeline.stop();
                timeline2 = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move2(/*dx,dy*/))
                );
                timeline2.setCycleCount(Timeline.INDEFINITE);
                timeline2.play();
                
                
                }
        
        }else { 
            timeline.stop();
            System.out.print("FUORI");
        }
  
    }
    
    
    
    @Override
    public void move2(/*double dx, double dy*/){
        //System.out.println("centro x e y nel move2 : "+spaceship.getCenterX()+" ; "+spaceship.getCenterY());
        /*double distNum = Math.sqrt(dx*dx+ dy*dy);
        double dxNorm = -dx / distNum;
        double dyNorm = -dy / distNum;//direzioni della retta che unisce i due centri
        
        //System.out.println("dx e dy : "+dxNorm+" ; "+dyNorm);
        
        
        double tgx = -dyNorm;
        double tgy = dxNorm;
        
        double num = dxNorm * spaceshipX + dyNorm * spaceshipY;
        double den = (Math.sqrt(dxNorm*dxNorm + dyNorm*dyNorm))*(Math.sqrt(spaceshipX*spaceshipX + spaceshipY*spaceshipY));
        double cosA = num/den;
        System.out.println("coseno: "+cosA);
        double A = Math.toDegrees(Math.acos(cosA));
        System.out.println("angolo: "+A);*/
        
       
       //Point2D rotatedNormal = new Rotate(-2*A,spaceship.getCenterX(),spaceship.getCenterY()).transform(spaceshipX, spaceshipY); 
       
       spaceshipX2 = NrotatedNormal.getX()*t;
       spaceshipY2 = NrotatedNormal.getY()*t;
        
        //System.out.println("tgx e tgy : "+tgx+" ; "+tgy);
        
        /*double[][] BCMatrix = new double[2][2]; //matrice del cambiamento di base
        double determinant = (dxNorm*tgy)-(dyNorm*tgx);
      
        BCMatrix[0][0]= tgy/determinant;
        BCMatrix[1][0]= -dyNorm/determinant;
        BCMatrix[0][1]= -tgx/determinant;
        BCMatrix[1][1]= dxNorm/determinant;
        
        
      
        
       
        spaceshipX2 = (spaceshipX * BCMatrix[0][0]+ spaceshipY * BCMatrix[1][0]);
        spaceshipY2 = (spaceshipX * BCMatrix[0][1]+ spaceshipY * BCMatrix[1][1]);*/
        
        System.out.println("spaceshipx2 e spaceshipy2 : "+spaceshipX2+" ; "+spaceshipY2);
        spaceship.setTranslateX(spaceshipX2);
        spaceship.setTranslateY(spaceshipY2);
        ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+spaceshipX2);
        ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+spaceshipY2);
        spaceship.setCenterX(ControllerForModel.getInstance().getSpaceshipCenterX());
        spaceship.setCenterY(ControllerForModel.getInstance().getSpaceshipCenterY());

                
                //t++;
    }
    
   
    
    @Override
    public void startMovimento() {
       gameWindow = View.getInstance().getGameWindow();
       gamePane = gameWindow.getSchermataGioco();
       handler = new EventHandler<MouseEvent>() {  
            public void handle(MouseEvent event) {  
                mousePositionX = event.getX();
                mousePositionY = event.getY();
                movimento();
                
            }
        };
       
        gamePane.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);    
    }
    
    
    @Override
    public void pauseAnimations(){
        this.timeline.pause();
    }
    
    @Override
        public void playAnimations(){
        this.timeline.play();
    }
     
        
    @Override
        public double truncate(double a){
            double b = a*10000000;
            double c = Math.floor(b);
            double d = c/10000000;
            return d;
        }
        
        
        
        
        
}//end class sss
