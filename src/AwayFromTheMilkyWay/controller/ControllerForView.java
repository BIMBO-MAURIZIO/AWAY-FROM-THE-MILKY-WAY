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
    private double spaceshipX;
    private double spaceshipY;
    private double mousePositionX;
    private double mousePositionY;
    Circle spaceship;
    
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
        
        double[] position = new double[1];
        position = this.getMousePosition(true);
        mousePositionX = position[0];
        mousePositionY = position[1];
        
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        
    }
    
    
    @Override
    public void move(){
        double cost = mousePositionX/mousePositionY;
        spaceshipY++;
        spaceshipX = cost+spaceshipX;
        spaceship.setTranslateX(spaceshipX);
        spaceship.setTranslateY(spaceshipY);
    }
    
    
    @Override
    public void startMovimento(Scene scenaAttiva, boolean accensione) {
        if(accensione){
            scenaAttiva.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent) -> {
                movimento();
            });
        }else{}
          
    }
    
    public double[] getMousePosition(boolean accensione){
        double[] position;
        position = new double[1];
        if(accensione){
            
            EventHandler<MouseEvent> mouseHandler = (MouseEvent event) -> {
                position[0] = event.getX();
                position[1] = event.getY();           
            };
            accensione = false;
        }
        return position;
    }
}//end class sss
