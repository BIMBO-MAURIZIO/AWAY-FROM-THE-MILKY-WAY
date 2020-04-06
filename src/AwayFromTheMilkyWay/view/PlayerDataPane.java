/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author giorg
 */
public class PlayerDataPane extends GridPane {
    int level;
    int rimbalziEff;
    int rimbDes;
    String name;
    int power;
    
    Label nome, forza,rimbalziEffettuati,numLivello;
    
    Button opzioni;
    
    public PlayerDataPane(){
        super();
   }//prova
    
    public void populatePane(){
       
        
        
        Label rimbalziDesiderati = new Label("Rimbalzi Desiderati: "+ rimbDes);
        rimbalziDesiderati.setPrefSize(427, 90);
        
        
        
        nome  = new Label("nome: " + name);
        nome.setPrefSize(427, 90);
        //Font carattere = new Font("Arial",24);
        //nome.setFont(carattere);
        
        forza = new Label("forza: " + power);
        forza.setPrefSize(427, 90);
        
        rimbalziEffettuati = new Label("rimbalzi effettuati: "+ rimbalziEff);
        rimbalziEffettuati.setPrefSize(427, 90);
        
        numLivello = new Label("livello numero "+ level);
        numLivello.setPrefSize(426, 90);
        
        opzioni = new Button("opzioni");
        opzioni.setPrefSize(426, 90);
        
        opzioni.setOnAction(event -> {
            
        View.getInstance().pause();
           
        });
        
        
        
        this.add(rimbalziDesiderati,0,0);
        this.add(nome,1,0);
        this.add(forza,0,1);
        this.add(rimbalziEffettuati,1,1);
        this.add(numLivello,2,0);
        this.add(opzioni,2,1);
        
    }
    
    public void setName(String nm){
        this.name = nm;
        this.update();
        //this.populatePane();
          
    }
    
    public void setRimbalziEff(int rimb){
        this.rimbalziEff = rimb;
        this.update();
    }
    
    
    public void update(){
        nome.setText("nome: " + name);
        rimbalziEffettuati.setText("rimbalzi effettuati: "+ rimbalziEff);
        numLivello.setText("livello numero "+ level);
        
    }
     
   

    
}
