/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.model;

/**
 *
 * @author giorg
 */
public class Model implements IModel {
    
    private GameStatus gameStatus;
    private static Model instance;


    public Model(){
        
    }
      
           
    public static IModel getInstance() {
        if(instance == null)
            instance = new Model();
        return instance;
    }

    
    @Override
    public int getRimbalziEffettuati() {
        return this.gameStatus.rimbEffettuati;
                
    }
    
    
    @Override
    public void incrementaRimbalziEffettuati() {
        this.gameStatus.rimbEffettuati ++;
    
    }
    
    
}//end class
