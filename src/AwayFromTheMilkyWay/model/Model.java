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
    private SpaceshipModel spaceship ;
    private MilkyWayModel milkyWay;
    private Planets pianeti = new Planets();
    


    public Model(){
        //DOMANDA: ma è necessario che esistano le classi SpaceshipModel e MilkyWayModel? questi non potrebber essere semplici cerchi?
        //DOMANDA: secondo me metodi sotto dovrebbero venire dal ControllerForModel. Infatti i controller dovrebbero poter prendere info da dove gli pare, ma il model
        //dovrebbe richiamare solo il controllerForModel e la View solo il ControllerForView. Quindi da riveder di cambiare questi metodi.
        spaceship = new SpaceshipModel(ControllerForModel.getInstance().getSpaceshipCenterX(),ControllerForModel.getInstance().getSpaceshipCenterY(),45);
        milkyWay = new MilkyWayModel(ControllerForModel.getInstance().getMWCenterX(),ControllerForModel.getInstance().getMWCenterY(),ControllerForModel.getInstance().getMWRadius());
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
    public MilkyWayModel getMilkyWay(){
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
    
}//end class
