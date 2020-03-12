/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.view.GamePane;
import AwayFromTheMilkyWay.view.GameWindow;
import AwayFromTheMilkyWay.view.View;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
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
        System.out.println("mouseX :"+mousePositionX);
        System.out.println("mouseY :"+mousePositionY);
     
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
     
    @Override
    public void move(){
        if (mousePositionX > startSpaceshipX && mousePositionY > startSpaceshipY){
            double cost = (mousePositionY-startSpaceshipY)/(mousePositionX-startSpaceshipX);
            spaceshipY = ((spaceshipX+0.5)*cost);
            
            //spaceshipY = spaceshipY + cost;
            spaceshipX = (spaceshipX + 0.5);
            //System.out.println("x : "+spaceshipX);
            //System.out.println("y : "+spaceshipY);
            spaceship.setTranslateX(spaceshipX);
            spaceship.setTranslateY(spaceshipY);
        }
        
        //if ()
        
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
    
    
    @Override
    public double getMousePositionX(){
        Scene scenaAttiva = View.getInstance().getScene();
        scenaAttiva.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent) -> {
                positioningX = mouseEvent.getX();
            });
        return positioningX;
    }
    
    
    @Override
    public double getMousePositionY(){
       Scene scenaAttiva = View.getInstance().getScene();
       scenaAttiva.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent) -> {
                positioningY = mouseEvent.getY();
            });
       return positioningY;
    }
    
    
    
    
}//end class sss
