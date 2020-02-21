/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/**
 *
 * @author giorg
 */
public class GameWindow extends BorderPane {
    
    public GameWindow(){
        super();
    }
    
    public void composeWindow(){
        GamePane schermataGioco = new GamePane();
        schermataGioco.setScenario(1);
        schermataGioco.setPrefSize(1200, 540);
        PlayerDataPane schermataDati = new PlayerDataPane();
        schermataDati.setPrefSize(1200, 180);
        schermataDati.populatePane();
        //root.setCenter(schermataGioco);
        this.setCenter(schermataGioco);
        this.setBottom(schermataDati);
        /*this.getChildren().add(schermataGioco);
        this.getChildren().add(schermataDati);*/
        //Scene scene = new Scene(root, 1200, 720);
        
      
        
        //devoaggiungere a questa scena la gamePane e la PlayerDataPane
    }
    
}
