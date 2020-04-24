/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.model;

import AwayFromTheMilkyWay.controller.ControllerForModel;
import java.io.IOException;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public class Model implements IModel {
    
    private GameStatus gameStatus;
    private static Model instance;
    private Circle spaceship,milkyWay,ostacoloMobile1,ostacoloMobile2; 
    private movingObstaclesModel ostacoliMobili;
    private PlanetsModel pianeti;
    private fixObstaclesModel ostacoliFissi;
    


    public Model(){
        spaceship = new Circle(ControllerForModel.getInstance().getSpaceshipCenterX(),ControllerForModel.getInstance().getSpaceshipCenterY(),45);
        milkyWay = new Circle(ControllerForModel.getInstance().getMWCenterX(),ControllerForModel.getInstance().getMWCenterY(),ControllerForModel.getInstance().getMWRadius());
        gameStatus = new GameStatus();
        
    }
      
           
    public static IModel getInstance() {
        if(instance == null)
            instance = new Model();
        return instance;
    }
    
    
    @Override
    public Circle[] scanPlanets(int level) throws IOException{
        pianeti  = new PlanetsModel();
        return pianeti.scanning(level);
    }
    
    @Override
    public Circle[] scanFixObstacles(int level) throws IOException{
        ostacoliFissi  = new fixObstaclesModel();
        return ostacoliFissi.scanning(level);
    }
    
    @Override
    public Circle[] scanMovingObstacles(int level) throws IOException{
        ostacoliMobili = new movingObstaclesModel();//non va bene non sa quale dei due ostacoli creare
        ostacoloMobile1 = ostacoliMobili.scanning(level)[0];
        ostacoloMobile2 = ostacoliMobili.scanning(level)[1];
        return ostacoliMobili.scanning(level);
    }
    
    
    //metodi getter di GameStatus
    
    @Override
    public int getRimbalziEffettuati() {
        return this.gameStatus.getRimbEff();
                
    }
    
    
    @Override
    public void incrementaRimbalziEffettuati() {
        this.gameStatus.incrementaRimbEff();
    
    }
    
    @Override
    public int getCurrentLevel(){
        return this.gameStatus.getLevel();
    
    }
    
    //getter di spaceship model
    
    @Override
    public Circle getSpaceship(){
        return this.spaceship;
    }
    
    
    @Override
    public Circle getMilkyWay(){
        return this.milkyWay;
    }
    
    @Override
    public void increaseLevel(){
        this.gameStatus.increaseLevel();
    }
    
    @Override
    public void decreaseLevel(){
        this.gameStatus.decreaseLevel();
    }
    
    @Override
    public void setLevel(int n){
        this.gameStatus.setLevel(n);
    }
    
    
    @Override
    public void setRimbDesiderati(int i){
         this.gameStatus.setRimbDesiderati(i);
     }
    
    @Override
    public int getRimbDesiderati(){
        return this.gameStatus.getRimbDes();
    }
    
    @Override
    public void setRimbEffettuati(int i){
        this.gameStatus.setRimbEffettuati(i);
    }
    
    @Override
    public void setName(String s){
        this.gameStatus.setName(s);
    }
    
    @Override
    public String getName(){
        return this.gameStatus.getName();
    }
    
  
    @Override
    public Circle getOstacoloMobile1(){
        return this.ostacoloMobile1;
    }
    
  
    
    
    @Override
    public Circle getOstacoloMobile2(){
        return this.ostacoloMobile2;
    }
    
}//end class
