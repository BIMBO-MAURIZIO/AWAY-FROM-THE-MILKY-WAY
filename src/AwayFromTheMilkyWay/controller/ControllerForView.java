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
import javafx.animation.AnimationTimer;
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
    AnimationTimer a;
    
    
    
    
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
        magnitude = Math.sqrt(x*x+ y*y);
        xstab = x / magnitude;
        ystab = y / magnitude;
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
                x -> move(xstab,ystab,2))
                
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
     
    @Override
    public void move(double vx, double vy,double v){
        variableSpaceshipX = ControllerForModel.getInstance().getSpaceshipCenterX();
        variableSpaceshipY = ControllerForModel.getInstance().getSpaceshipCenterY();
        
        
        if (variableSpaceshipX + SPACESHIPRADIUS <= WINLENGTH && variableSpaceshipY + SPACESHIPRADIUS <= WINHEIGHT
            && variableSpaceshipX - SPACESHIPRADIUS >= 0 && variableSpaceshipY - SPACESHIPRADIUS >= 0 ){//condizioni per mantenere la navicella dentro ai bordi
            
            double dx = variableSpaceshipX - cir.getCenterX();
            double dy =  variableSpaceshipY - cir.getCenterY();
            double distNum = Math.sqrt(dx*dx+ dy*dy);
            
            if(distNum >= SPACESHIPRADIUS+cir.getRadius() ){
                shipSpeed = new Point2D(vx *v,vy*v);
                spaceship.setTranslateX(shipSpeed.getX()/*spaceshipX*/);
                spaceship.setTranslateY(shipSpeed.getY()/*spaceshipY*/);
                
                ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+/*spaceshipX*/shipSpeed.getX());
                ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+/*spaceshipY*/shipSpeed.getY());
                spaceship.setCenterX(ControllerForModel.getInstance().getSpaceshipCenterX());
                spaceship.setCenterY(ControllerForModel.getInstance().getSpaceshipCenterY());

                
            }else{
                rebounce(dx,dy,distNum);
                
                }
        
        }else { 
            
            timeline.stop();
            System.out.print("FUORI");
        }
  
    }
    
    
    
    
    @Override 
    public void rebounce(double dx,double dy,double distNum){
        //a.stop();
        timeline.stop();
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
        Point2D vect2 = new Point2D(cir.getCenterX() - startSpaceshipX, cir.getCenterY() - startSpaceshipY);
        Point2D Nvect2 = vect2.normalize();/*unisce il piantea e l'astronave nella sua posizione iniziale*/
                
        double A = normal.angle(shipSpeed);
        double B = vect1.angle(vect2);
        Point2D s = new Rotate(-B,0,0).transform(Nvect2.getX(), Nvect2.getY());
        if(startSpaceshipX!= cir.getCenterX() || startSpaceshipY != cir.getCenterY())
            if (truncate(s.getX()) == truncate(Nvect1.getX()) && truncate(s.getY()) == truncate(Nvect1.getY()))
                A=-A;
                
               
                
        //DA RICORDARE CHE SE VOGLIAMO UTILIZZARE QUESTO METODO PER TUTTE LE ROTAZIONI è NECESSARIO METTERE AL POSOTO DI startSpaceshipX e startspaShipY DEI RIFERIMENTI ALLA POSIZIONE DI PARTENZA DELL 'ASTRONAVE DOPO L'ULTIMO RIMBALZO.
        Point2D rN = new Rotate(-2*A,spaceship.getCenterX(),spaceship.getCenterY()).transform(startSpaceshipX, startSpaceshipY); 
        double diffX = rN.getX()- spaceship.getCenterX();
        double diffY = rN.getY()- spaceship.getCenterY();
        double rad = Math.sqrt((diffX*diffX)+(diffY*diffY));
        NrotatedNormal = new Point2D(diffX/rad, diffY/rad);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.025), x -> move(NrotatedNormal.getX(),NrotatedNormal.getY(),1));
                
        spaceship.setTranslateX(NrotatedNormal.getX());
        spaceship.setTranslateY(NrotatedNormal.getY());
        ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+NrotatedNormal.getX());
        ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+NrotatedNormal.getY());
        spaceship.setCenterX(ControllerForModel.getInstance().getSpaceshipCenterX());
        spaceship.setCenterY(ControllerForModel.getInstance().getSpaceshipCenterY());

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
        this.timeline.pause();
        //this.a.stop();
    }
    
    @Override
        public void playAnimations(){
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
        
        
        
        
        
}//end class sss
