/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.model.Model;
import AwayFromTheMilkyWay.model.SpaceshipModel;
import AwayFromTheMilkyWay.view.View;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public class ControllerForModel implements IControllerForModel {
    private static ControllerForModel instance;
    
    
    
    Circle spaceship ;
    
    public ControllerForModel(){
        
    }
      
           
    public static IControllerForModel getInstance() {
        if(instance == null)
            instance = new ControllerForModel();
        return instance;
    }
    
    
    
   @Override
    public void setSpaceshipCenterX (double x){
        Model.getInstance().getSpaceship().setCenterX(x);
    
    }

    @Override
    public void setSpaceshipCenterY (double y){
        Model.getInstance().getSpaceship().setCenterY(y);
    
    }
    
    @Override
    public double getSpaceshipCenterX (){ //centro dell'astronave nella view
        return View.getInstance().getSpaceship().getCenterX();
        
    }
    
    @Override
    public double getSpaceshipCenterY (){
        return View.getInstance().getSpaceship().getCenterY();
        
    }
    
    
    
     @Override
    public double getMWCenterX(){
        return View.getInstance().getMilkyWay().getCenterX();
    }
    
    @Override
    public double getMWCenterY(){
        return View.getInstance().getMilkyWay().getCenterY();
    }
    
    @Override
    public double getMWRadius(){
        return View.getInstance().getMilkyWay().getRadius();
    }
    
    
}
