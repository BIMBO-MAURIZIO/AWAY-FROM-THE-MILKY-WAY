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
        rimbalziDesiderati.setPrefSize(600, 90);
        Label nome  = new Label("nome: ");
        nome.setPrefSize(600, 90);
        Label forza = new Label("forza: ");
        forza.setPrefSize(600, 90);
        Label rimbalziEffettuati = new Label("rimbalzi effettuati: ");
        rimbalziEffettuati.setPrefSize(600, 90);
        
        
        this.add(rimbalziDesiderati,0,0);
        this.add(nome,1,0);
        this.add(forza,0,1);
        this.add(rimbalziEffettuati,1,1);
        /*this.add(new Label("a"),0,0);
        this.add(new Label("a"),1,0);
        this.add(new Label("a"),0,1);
        this.add(new Label("a"),1,1);*/
    }
    
}
