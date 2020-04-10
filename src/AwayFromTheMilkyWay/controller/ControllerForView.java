/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.model.Model;
import AwayFromTheMilkyWay.view.GamePane;
import AwayFromTheMilkyWay.view.GameWindow;
import AwayFromTheMilkyWay.view.PlayerDataPane;
import AwayFromTheMilkyWay.view.View;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //double positioningX;
    //double positioningY;
    private double startSpaceshipX;
    private double startSpaceshipY;
    private double mousePositionX;
    private double mousePositionY;
    private Circle spaceship;
    private EventHandler<MouseEvent> handler;
    private Point2D NrotatedNormal;
    private Circle cir1;
    private Circle cir2;
    private Circle cir3;
    private Circle cir4;
    private Circle[] a = new Circle[4];
    private Circle varCir;
    
    
    
     private GameWindow gameWindow;
     private GamePane gamePane ;
     //Circle cir = gamePane.getPlanet1();
    
    
    
    
    //variabili per il movimento
    double t = 0;
    double tDim;
    double x;
    double y;
    double magnitude;
    double xstab;
    double ystab;
    Point2D shipSpeed;
    double variableSpaceshipX;
    double variableSpaceshipY;
    Timeline timeline;
    //AnimationTimer a;
    
    
    
    
    
    
    
    //costanti
    
    private final int WINLENGTH = 1280;
    private final int WINHEIGHT = 717;//sottraiamo 3 da 720 perhè il rendering non riesce a seguire la logica
    private final int SPACESHIPRADIUS = 45;
    
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
        
        this.Configuration();//visualizza quanti e quali pianeti stanno nella scena dipendentemente dal livello
        
        gameWindow = View.getInstance().getGameWindow();
        gamePane = gameWindow.getSchermataGioco();
        gamePane.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        
        spaceship = gamePane.getSpaceship();
        startSpaceshipX = spaceship.getCenterX();
        startSpaceshipY = spaceship.getCenterY();
        
        
        x = mousePositionX-startSpaceshipX;
        y = mousePositionY-startSpaceshipY;
        magnitude = Math.sqrt(x*x+ y*y);
        xstab = x / magnitude;
        ystab = y / magnitude;
        t = 1.00;
        /*
        a = new AnimationTimer(){
            @Override
            public void handle(long now){
                 move(xstab,ystab,2);
            }
        
        };
        a.start();*/
        
        timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move(xstab,ystab,4))
                
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
     
    @Override
    public void move(double vx, double vy,double v){
        variableSpaceshipX = ControllerForModel.getInstance().getSpaceshipCenterX();
        variableSpaceshipY = ControllerForModel.getInstance().getSpaceshipCenterY();
        
        
        if (variableSpaceshipX + SPACESHIPRADIUS < WINLENGTH && variableSpaceshipY + SPACESHIPRADIUS < WINHEIGHT
            && variableSpaceshipX - SPACESHIPRADIUS > 2 && variableSpaceshipY - SPACESHIPRADIUS > 2 ){//condizioni per mantenere la navicella dentro ai bordi
            double dx,dy,distNum;
            

            
            if(cir1 != null && Math.sqrt((variableSpaceshipX - cir1.getCenterX())*(variableSpaceshipX - cir1.getCenterX())+(variableSpaceshipY - cir1.getCenterY())*(variableSpaceshipY - cir1.getCenterY()))<= SPACESHIPRADIUS+cir1.getRadius() ){
                varCir = cir1;
                double dx1 = variableSpaceshipX - cir1.getCenterX();
                double dy1 =  variableSpaceshipY - cir1.getCenterY();
                double distNum1 = Math.sqrt(dx1*dx1+ dy1*dy1);
                dx = dx1;
                dy = dy1;
                distNum = distNum1;
                
                timeline.stop();
                bounce(dx,dy,distNum);
                startSpaceshipX = ControllerForModel.getInstance().getSpaceshipCenterX();
                startSpaceshipY = ControllerForModel.getInstance().getSpaceshipCenterY();

            }else if (cir2 != null && Math.sqrt((variableSpaceshipX - cir2.getCenterX())*(variableSpaceshipX - cir2.getCenterX())+(variableSpaceshipY - cir2.getCenterY())*(variableSpaceshipY - cir2.getCenterY()))<= SPACESHIPRADIUS+cir2.getRadius() ){
                varCir = cir2;
                double dx2 = variableSpaceshipX - cir2.getCenterX();
                double dy2 =  variableSpaceshipY - cir2.getCenterY();
                double distNum2 = Math.sqrt(dx2*dx2+ dy2*dy2);
                dx = dx2;
                dy = dy2;
                distNum = distNum2;
                
                timeline.stop();
                bounce(dx,dy,distNum);
                startSpaceshipX = ControllerForModel.getInstance().getSpaceshipCenterX();
                startSpaceshipY = ControllerForModel.getInstance().getSpaceshipCenterY();
            
            }else if(cir3 != null && Math.sqrt((variableSpaceshipX - cir3.getCenterX())*(variableSpaceshipX - cir3.getCenterX())+(variableSpaceshipY - cir3.getCenterY())*(variableSpaceshipY - cir3.getCenterY()))<= SPACESHIPRADIUS+cir3.getRadius() ){
                varCir = cir3;
                double dx3 = variableSpaceshipX - cir3.getCenterX();
                double dy3 =  variableSpaceshipY - cir3.getCenterY();
                double distNum3 = Math.sqrt(dx3*dx3+ dy3*dy3);
                dx = dx3;
                dy = dy3;
                distNum = distNum3;
                
                timeline.stop();
                bounce(dx,dy,distNum);
                startSpaceshipX = ControllerForModel.getInstance().getSpaceshipCenterX();
                startSpaceshipY = ControllerForModel.getInstance().getSpaceshipCenterY();
            
            }else if(cir4 != null && Math.sqrt((variableSpaceshipX - cir4.getCenterX())*(variableSpaceshipX - cir4.getCenterX())+(variableSpaceshipY - cir4.getCenterY())*(variableSpaceshipY - cir4.getCenterY()))<= SPACESHIPRADIUS+cir4.getRadius() ){ 
                varCir = cir4;
                
                double dx4 = variableSpaceshipX - cir4.getCenterX();
                double dy4 =  variableSpaceshipY - cir4.getCenterY();
                double distNum4 = Math.sqrt(dx4*dx4+ dy4*dy4);
                dx = dx4;
                dy =  dy4;
                distNum = distNum4;
                
                timeline.stop();
                bounce(dx,dy,distNum);
                startSpaceshipX = ControllerForModel.getInstance().getSpaceshipCenterX();
                startSpaceshipY = ControllerForModel.getInstance().getSpaceshipCenterY();
            }else{//caso in cui non ci sono collisioni
                
                shipSpeed = new Point2D(vx * v,vy * v);
             
                double trX = shipSpeed.getX()*t;
                double trY = shipSpeed.getY()*t;
                
                spaceship.setTranslateX(trX);
                spaceship.setTranslateY(trY);
                
                ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+trX);
                ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+trY);
                spaceship.setCenterX(ControllerForModel.getInstance().getSpaceshipCenterX());
                spaceship.setCenterY(ControllerForModel.getInstance().getSpaceshipCenterY());
                
                if (t > 0.01)
                    t = t-0.001;
                else
                    timeline.stop();
                }
        
        }else { 
            System.out.println("centri astronave : "+spaceship.getCenterX()+" "+spaceship.getCenterY() );
            timeline.stop();
            System.out.print("FUORI");
        }
  
    }
    
    
    
    
    @Override 
    public void bounce(double dx,double dy,double distNum){
        //a.stop();
        //timeline.stop();
        Model.getInstance().incrementaRimbalziEffettuati();
        System.out.println(Model.getInstance().getRimbalziEffettuati());
        System.out.println("coordinate astronave : " + spaceship.getCenterX()+" ; "+spaceship.getCenterY());
        PlayerDataPane p = View.getInstance().getGameWindow().getPDP();
        p.setRimbalziEff(Model.getInstance().getRimbalziEffettuati());
        
        double dxNorm = -dx / distNum;
        double dyNorm = -dy / distNum;//direzioni della retta che unisce i due centri
        Point2D normal = new Point2D(dxNorm,dyNorm);
                
                /*procedimento applicato per il rimbalzo:
                si considerano due versori che indicano ciò che è descritto accanto a loro nella loro definizione(guarda sotto)
                si fa ruotare il vettore 2 normalizzato attorno all 'origine di un angolo -B, e se questo vettore diventa congruente con il vettore 1 normalizzato allora
                siaamo riusciti a capire che la pallina è  stata lanciata verso sinistra e quindi l' angolo A che rappresenza l'angolo di incidenza assume in modulo
                lo stessp valore di prima ,ma cambia in segno.
                */
        Point2D center = new Point2D(spaceship.getCenterX(),spaceship.getCenterY());
        Point2D vect1 = new Point2D(center.getX() - startSpaceshipX, center.getY() - startSpaceshipY);
        Point2D Nvect1 = vect1.normalize();/*unisce il centro dell'astro quando va a sbattere al centro iniziale*/
        Point2D vect2 = new Point2D(varCir.getCenterX() - startSpaceshipX, varCir.getCenterY() - startSpaceshipY);
        Point2D Nvect2 = vect2.normalize();/*unisce il piantea e l'astronave nella sua posizione iniziale*/
        System.out.println("vettore 1 :"+Nvect1.toString());
        //System.out.println("vettore 2 :"+vect2.toString());
        double A = normal.angle(shipSpeed);
        double B = vect1.angle(vect2);
        Point2D s = new Rotate(-B,0,0).transform(Nvect2.getX(), Nvect2.getY());
        System.out.println("vettore2 ruotato : "+ Nvect2.toString());
        //if(startSpaceshipX != cir.getCenterX() || startSpaceshipY != cir.getCenterY())
            if (truncate(s.getX()) == truncate(Nvect1.getX()) && truncate(s.getY()) == truncate(Nvect1.getY()))
                A=-A;
                
               
                
        System.out.println("angolo A : "+ A);
        Point2D rN = new Rotate(-2*A,spaceship.getCenterX(),spaceship.getCenterY()).transform(startSpaceshipX, startSpaceshipY); 
        double diffX = rN.getX()- spaceship.getCenterX();
        double diffY = rN.getY()- spaceship.getCenterY();
        double rad = Math.sqrt((diffX*diffX)+(diffY*diffY));
        NrotatedNormal = new Point2D(diffX/rad, diffY/rad);
        System.out.println("NrotatedNormal : "+NrotatedNormal.toString());
        KeyFrame kf = new KeyFrame(Duration.seconds(0.025), x -> move(NrotatedNormal.getX(),NrotatedNormal.getY(),4));
        
        for(int i=0;i<10;i++){//avvia la traslazione
            spaceship.setTranslateX(NrotatedNormal.getX()*t);
            spaceship.setTranslateY(NrotatedNormal.getY()*t);
            if (t > 0.01)
                    t = t-0.001;
            else
                    timeline.stop();    
            ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+(NrotatedNormal.getX()*t));
            ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+(NrotatedNormal.getY()*t));
            spaceship.setCenterX(ControllerForModel.getInstance().getSpaceshipCenterX());
            spaceship.setCenterY(ControllerForModel.getInstance().getSpaceshipCenterY());
        }
        System.out.println("coordinate astronave dopo il for : " + spaceship.getCenterX()+" ; "+spaceship.getCenterY());
        
        timeline.getKeyFrames().set(0,kf);      

        timeline.play();
                
        /*a = new AnimationTimer(){
            @Override
            public void handle(long now){
                 move(NrotatedNormal.getX(),NrotatedNormal.getY(),1);
            }
        };
        a.start();
        */
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
        if(this.timeline != null)
            this.timeline.pause();
        //this.a.stop();
    }
    
    @Override
    public void playAnimations(){
        if(this.timeline != null)
            this.timeline.play();
    //this.a.start();
    }
     
        
    @Override
    public double truncate(double a){
        double b = a*10000000;
        double c = Math.floor(b);
        double d = c/10000000;
        return d;
    }
    
    @Override
    public void Configuration(){
        int y = Model.getInstance().getCurrentLevel();
        try {
            a[0] = Model.getInstance().scanPlanets(y)[0];
            a[1] = Model.getInstance().scanPlanets(y)[1];
            a[2] = Model.getInstance().scanPlanets(y)[2];
            a[3] = Model.getInstance().scanPlanets(y)[3];
        } catch (IOException ex) {
            Logger.getLogger(ControllerForView.class.getName()).log(Level.SEVERE, null, ex);
        }
       cir1 = a[0];
       cir2 = a[1];
       cir3 = a[2];
       cir4 =a[3];
        
    }
        
        
        
        
        
}//end class sss
