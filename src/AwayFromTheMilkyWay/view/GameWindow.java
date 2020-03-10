/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;


import javafx.scene.layout.BorderPane;



public class GameWindow extends BorderPane {
    
    PlayerDataPane schermataDati = new PlayerDataPane();
    
    
    public GameWindow(){
        super();
        
    }
    
    
    public void composeWindow(int level){
        GamePane schermataGioco = new GamePane();
        schermataGioco.setScenario(level);
        schermataGioco.setPrefSize(1280, 720);
        
        
        schermataDati.setPrefSize(1280, 180);
        schermataDati.populatePane();
   
        this.setCenter(schermataGioco);
        this.setBottom(schermataDati);
       
    }
    
    
   public void setName(String nm){
       schermataDati.setName(nm) ;
    
   }
    
   
}
