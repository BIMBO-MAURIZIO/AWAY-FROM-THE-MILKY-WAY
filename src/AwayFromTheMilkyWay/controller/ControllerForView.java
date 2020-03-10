/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.view.GamePane;
import AwayFromTheMilkyWay.view.GameWindow;
import AwayFromTheMilkyWay.view.View;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.MOUSE_PRESSED;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
    
    public void movimento(){
        GameWindow gameWindow = View.getInstance().getGameWindow();
        GamePane gamePane = gameWindow.getSchermataGioco();
        spaceship = gamePane.getSpaceship();
        
        spaceshipX = spaceship.getCenterX();
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    
    }
    
    public void move(){
        spaceshipX++;
        spaceship.setTranslateX(spaceshipX);
    }
    
    public void startMovimento(Scene scenaAttiva, boolean accensione){
        scenaAttiva.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
        

    }
    
}//end class
