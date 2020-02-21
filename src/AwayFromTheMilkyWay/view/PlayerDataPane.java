/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author giorg
 */
public class PlayerDataPane extends GridPane {
    int level;
    
    public PlayerDataPane(){
        super();
    }//prova
    
    public void populatePane(){
        
        
        Label rimbalziDesiderati = new Label("Rimbalzi Desiderati: ");
        rimbalziDesiderati.setPrefSize(427, 90);
        Label nome  = new Label("nome: ");
        nome.setPrefSize(427, 90);
        Font carattere = new Font("Batang",24);
        nome.setFont(carattere);
        Label forza = new Label("forza: ");
        forza.setPrefSize(427, 90);
        Label rimbalziEffettuati = new Label("rimbalzi effettuati: ");
        rimbalziEffettuati.setPrefSize(427, 90);
        Label numLivello = new Label("livello numero "+ level);
        numLivello.setPrefSize(426, 90);
        Button opzioni = new Button("opzioni");
        opzioni.setPrefSize(426, 90);
        
        
        
        this.add(rimbalziDesiderati,0,0);
        this.add(nome,1,0);
        this.add(forza,0,1);
        this.add(rimbalziEffettuati,1,1);
        this.add(numLivello,2,0);
        this.add(opzioni,2,1);
        
    }
    
}
