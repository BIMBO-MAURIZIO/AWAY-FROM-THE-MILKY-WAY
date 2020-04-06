/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.model.Model;
import AwayFromTheMilkyWay.model.SpaceshipModel;

/**
 *
 * @author giorg
 */
public class ControllerForModel implements IControllerForModel {
    private static ControllerForModel instance;
    
    
    
    SpaceshipModel spaceship ;
    
    public ControllerForModel(){
        
    }
      
           
    public static IControllerForModel getInstance() {
        if(instance == null)
            instance = new ControllerForModel();
        return instance;
    }
    
    
    
   @Override
    public void setSpaceshipCenterX (double x){
        spaceship = Model.getInstance().getSpaceship();
        spaceship.setCenterX(x);
    
    }
    
    
    
    @Override
    public void setSpaceshipCenterY (double y){
        spaceship = Model.getInstance().getSpaceship();
        spaceship.setCenterY(y);
    
    }
    
    @Override
    public double getSpaceshipCenterX (){
        spaceship = Model.getInstance().getSpaceship();
        return spaceship.getCenterX();
        
    }
    
    @Override
    public double getSpaceshipCenterY (){
        spaceship = Model.getInstance().getSpaceship();
        return spaceship.getCenterY();
        
    }
    
    
    
}
