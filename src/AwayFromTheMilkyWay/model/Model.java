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
    private MilkyWayModel milkyWay;
    private Planets pianeti = new Planets();
    


    public Model(){
        //DOMANDA: ma è necessario che esistano le classi SpaceshipModel e MilkyWayModel? questi non potrebber essere semplici cerchi?
        //DOMANDA: secondo me metodi sotto dovrebbero venire dal ControllerForModel. Infatti i controller dovrebbero poter prendere info da dove gli pare, ma il model
        //dovrebbe richiamare solo il controllerForModel e la View solo il ControllerForView. Quindi da riveder di cambiare questi metodi.
        spaceship = new SpaceshipModel(ControllerForView.getInstance().getSpaceshipCenterX(),ControllerForView.getInstance().getSpaceshipCenterY(),45);
        milkyWay = new MilkyWayModel(ControllerForView.getInstance().getMWCenterX(),ControllerForView.getInstance().getMWCenterY(),ControllerForView.getInstance().getMWRadius());
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
    
    
    @Override
    public MilkyWayModel getMilkyWay(){
        return this.milkyWay;
    }
    
}//end class
