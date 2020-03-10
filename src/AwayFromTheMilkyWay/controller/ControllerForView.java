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
    private double mousePositionX;
    private double mousePositionY;
    Circle spaceship;
    EventHandler<MouseEvent> mouseHandler;
    
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
    public void movimento(){
        GameWindow gameWindow = View.getInstance().getGameWindow();
        GamePane gamePane = gameWindow.getSchermataGioco();
        spaceship = gamePane.getSpaceship();
        
        spaceshipX = spaceship.getCenterX();
        spaceshipY = spaceship.getCenterY();
        System.out.println("spaceshipX :"+spaceshipX);
        System.out.println("spaceshipY :"+spaceshipY);
        double positionX;
        positionX = this.getMousePositionX();
        double positionY;
        positionY = this.getMousePositionY();
        
        /*position = this.getMousePosition(true);
        mousePositionX = position[0];
        mousePositionY = position[1];*/
        
        
        
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    
    @Override
    public void move(){
        double cost = mousePositionX/mousePositionY;
        spaceshipY++;
        spaceshipX = cost+spaceshipX;
        spaceship.setTranslateX(spaceshipX);
        spaceship.setTranslateY(spaceshipY);
        
        /*spaceshipX++;
        spaceshipY++;
        spaceship.setTranslateY(spaceshipY);
        spaceship.setTranslateX(spaceshipX);*/
    }
    
    
    @Override
    public void startMovimento(Scene scenaAttiva, boolean accensione) {
        if(accensione){
            scenaAttiva.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent) -> {
                movimento();
            });
            accensione = false;
        }else{}
          
    }
    
    
    /*@Override
    public double[] getMousePosition(boolean accensione){
        double[] position;
        position = new double[1];
        if(accensione){
            
            EventHandler<MouseEvent> mouseHandler = (MouseEvent event) -> {
                position[0] = event.getX();
                position[1] = event.getY();
                System.out.print("AAAAAAAAAAAAAAAAAAposition"+position[0]);
               
            };
            accensione = false;
        }
        return position;
    }*/
    
    @Override
    public double getMousePositionX(){
    
        
        
        mouseHandler = (MouseEvent event) -> {
            positioningX = event.getX();
            System.out.println("positioning x: "+positioningX);
            
        };
        return positioningX;
    }
    
    
    @Override
    public double getMousePositionY(){
    
        
        mouseHandler = (MouseEvent event) -> {
              positioningY = event.getY();
              System.out.println("positioning y: "+positioningX);
        };
        return positioningY;
    }
    
    
    
    
}//end class sss
