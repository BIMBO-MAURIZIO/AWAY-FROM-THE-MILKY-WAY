/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.utils.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author giorg
 */

public class SchermataInizialeController implements Initializable {

    @FXML Button effetti ;
    @FXML Button musica ;
    @FXML AnchorPane ap;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void nuovaPartita() throws IOException{
        View.getInstance().changeCurrentWindow("nuovaPartita.fxml");
    }
    
    
    public void caricaPartita() throws IOException{
        View.getInstance().changeCurrentWindow("caricaPartita.fxml");
    }
    
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
    
    public void toggleMusic(){//ricordati che per i tasti sviluppati in game il discorso deve essere opposto,ossia l'if deve essere fattomsolamente per la musica SOUNDTRACK
        //musica.getStylesheets().add(getClass().getResource("grafica.css").toExternalForm());
        Resources.Music.SOUNDTRACK.toggleMusicEnabled();
        Resources.Music.SOUNDINTRO.toggleMusicEnabled();
        if(Resources.Music.SOUNDINTRO.getToggleMusic())
            Resources.Music.SOUNDINTRO.play();
        else
            Resources.Music.SOUNDINTRO.stop();
    }
    
    public void toggleEffects(){
       
        Resources.SoundEffects.BUTTONCLICK.toggleSoundEnabled();
        Resources.SoundEffects.DEFEAT.toggleSoundEnabled();
        Resources.SoundEffects.EXPLOSION.toggleSoundEnabled();
        Resources.SoundEffects.PLANETHIT.toggleSoundEnabled();
        Resources.SoundEffects.VICTORY.toggleSoundEnabled();
    }
    
    
      
}

