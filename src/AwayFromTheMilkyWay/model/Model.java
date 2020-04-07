/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.model;

import AwayFromTheMilkyWay.controller.ControllerForView;
import java.io.IOException;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public class Model implements IModel {
    
    private GameStatus gameStatus;
    private static Model instance;
    private SpaceshipModel spaceship ;
    private Planets pianeti = new Planets();
    


    public Model(){
        spaceship = new SpaceshipModel(ControllerForView.getInstance().getSpaceshipCenterX(),ControllerForView.getInstance().getSpaceshipCenterY(),20);
        gameStatus = new GameStatus();
        
    }
      
           
    public static IModel getInstance() {
        if(instance == null)
            instance = new Model();
        return instance;
    }
    
    
    @Override
    public Circle[] scanPlanets(int level) throws IOException{
        return pianeti.scanning(level);
    }
    
    
    
    
    
    //metodi getter di GameStatus
    
    @Override
    public int getRimbalziEffettuati() {
        return this.gameStatus.rimbEffettuati;
                
    }
    
    
    @Override
    public void incrementaRimbalziEffettuati() {
        this.gameStatus.rimbEffettuati++;
    
    }
    
    @Override
    public int getCurrentLevel(){
        return this.gameStatus.livello;
    
    }
    
    //getter di spaceship model
    
    @Override
    public SpaceshipModel getSpaceship(){
        return this.spaceship;
    }
    
    
 
    
}//end class
