/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.view.GamePane;
import AwayFromTheMilkyWay.view.GameWindow;
import AwayFromTheMilkyWay.view.View;
import java.util.Vector;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
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
    private double startSpaceshipX;
    private double startSpaceshipY;
    private double mousePositionX;
    private double mousePositionY;
    Circle spaceship;
    EventHandler<MouseEvent> handler;
    int t = 0;
    double x;
    double y;
    double magnitude;
    double xstab;
    double ystab;
    
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
    
    
    
    //METODI PER IL MOVIMENTO
    @Override
    public void movimento(Scene scena){
        
        scena.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        GameWindow gameWindow = View.getInstance().getGameWindow();
        GamePane gamePane = gameWindow.getSchermataGioco();
        spaceship = gamePane.getSpaceship();
        startSpaceshipX = spaceship.getCenterX();
        startSpaceshipY = spaceship.getCenterY();
        spaceshipX = spaceship.getCenterX();
        spaceshipY = spaceship.getCenterY();
        x = mousePositionX-startSpaceshipX;
        y = mousePositionY-startSpaceshipY;
        magnitude = Math.sqrt(x*x+ y*y);
        xstab = x / magnitude;
        ystab = y / magnitude;
        System.out.println("mouseX :"+mousePositionX);
        System.out.println("mouseY :"+mousePositionY);
        System.out.println("spaceshipX :"+spaceshipX);
        System.out.println("spaceshipY :"+spaceshipY);
     
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move(1))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
     
    @Override
    public void move(double v){
        /*double k = (mousePositionX-startSpaceshipX)/(mousePositionY-startSpaceshipY);
        double vx = v*k;
        double vy = v;
        spaceshipX = k;//vx*t;
        spaceshipY = 1;//vy*t;
        spaceship.setTranslateX(spaceshipX);
        spaceship.setTranslateY(spaceshipY);
        System.out.println("x : "+spaceshipX);
        System.out.println("y : "+spaceshipY);
        t++;*/
        
       
        spaceshipX = xstab * t;
        spaceshipY = ystab * t;
        spaceship.setTranslateX(spaceshipX);
        spaceship.setTranslateY(spaceshipY);
        t++;
        
        
       
        
      
        
    }
    
    
   /* @Override
    public void startMovimento(Scene scenaAttiva, boolean accensione) {
        
        scenaAttiva.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent) -> {
            mousePositionX = mouseEvent.getX();
            mousePositionY = mouseEvent.getY();
            movimento();
             
        });
        accensione = false;
        if(!accensione){
        scenaAttiva.removeEventHandler(MouseEvent.MOUSE_PRESSED);
        }
          
    }*/
    
    @Override
    public void startMovimento(Scene scenaAttiva) {
       handler = new EventHandler<MouseEvent>() {  
            public void handle(MouseEvent event) {  
                mousePositionX = event.getX();
                mousePositionY = event.getY();
                movimento(scenaAttiva);
                
            }
        };
        scenaAttiva.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        
        
    }
     
}//end class sss
