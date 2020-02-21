/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author giorg
 */
public class PlayerDataPane extends GridPane {
    
    public PlayerDataPane(){
        super();
    }//prova
    
    public void populatePane(){
    
        Label rimbalziDesiderati = new Label("Rimbalzi Desiderati: ");
        rimbalziDesiderati.setPrefSize(400, 60);
        Label nome  = new Label("nome: ");
        nome.setPrefSize(400, 60);
        Label forza = new Label("forza: ");
        forza.setPrefSize(400, 60);
        Label rimbalziEffettuati = new Label("rimbalzi effettuati: ");
        rimbalziEffettuati.setPrefSize(400, 60);
        Label numLivello = new Label("livello numero ");
        numLivello.setPrefSize(400, 60);
        Label opzioni = new Label("opzioni");
        opzioni.setPrefSize(400, 60);
        
        
        
        this.add(rimbalziDesiderati,0,0);
        this.add(nome,1,0);
        this.add(forza,0,1);
        this.add(rimbalziEffettuati,1,1);
        this.add(numLivello,2,0);
        this.add(opzioni,2,1);
        
    }
    
}
