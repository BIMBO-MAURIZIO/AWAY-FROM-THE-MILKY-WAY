
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.utils.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class SchermataInizialeController implements Initializable {

    @FXML private Button nuova;
    @FXML private Button carica;
    @FXML private Button effetti;
    @FXML private Button musica;
    @FXML private Button istruzioni;
    @FXML private Label tit1;
    @FXML private Label tit2;   
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Resources.Music.SOUNDINTRO.getToggleMusic())
            musica.setId("volume");
        else
            musica.setId("volumeOff");
        
        
        if(Resources.SoundEffects.BUTTONCLICK.getToggleEffect())
            effetti.setId("effetti");
        else
            effetti.setId("effettiOff");
        
        nuova.setLayoutX(153);
        nuova.setLayoutY(77);
        nuova.setText(nuova.getText().toUpperCase());
        carica.setLayoutX(153);
        carica.setLayoutY(212);
        carica.setText(carica.getText().toUpperCase());
        musica.setLayoutX(163);
        musica.setLayoutY(347);
        effetti.setLayoutX(253);
        effetti.setLayoutY(347);
        istruzioni.setLayoutX(343);
        istruzioni.setLayoutY(347);
        tit1.setLayoutX(694);
        tit1.setLayoutY(75);
        tit1.setMinSize(374,112);
        tit1.setMaxSize(374,112);
        tit1.setText(tit1.getText().toUpperCase());
        tit2.setLayoutX(646);
        tit2.setLayoutY(173);
        tit2.setMinSize(450,106);
        tit2.setMaxSize(450,106);
        tit2.setText(tit2.getText().toUpperCase());
       
    
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
    
    public void toggleMusic(){
        if(musica.getId().equals("volume"))
            musica.setId("volumeOff");
        else
            musica.setId("volume");
        Resources.Music.SOUNDTRACK.toggleMusicEnabled();
        Resources.Music.SOUNDTRACK2.toggleMusicEnabled();
        Resources.Music.SOUNDTRACK3.toggleMusicEnabled();
        Resources.Music.SOUNDINTRO.toggleMusicEnabled();
        if(Resources.Music.SOUNDINTRO.getToggleMusic()){
            Resources.Music.SOUNDINTRO.play();
            
        }else{
            Resources.Music.SOUNDINTRO.stop();
        }
    }
    
    public void toggleEffects(){
        if(effetti.getId().equals("effetti"))
            effetti.setId("effettiOff");
        else
            effetti.setId("effetti");
        
        Resources.SoundEffects.BUTTONCLICK.toggleSoundEnabled();
        Resources.SoundEffects.DEFEAT.toggleSoundEnabled();
        Resources.SoundEffects.EXPLOSION.toggleSoundEnabled();
        Resources.SoundEffects.PLANETHIT.toggleSoundEnabled();
        Resources.SoundEffects.VICTORY.toggleSoundEnabled();
    }
    
    public void instructions() throws IOException{
        View.getInstance().changeCurrentWindow("instructions.fxml");
    }
    
      
}

