
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.utils.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;





public class SchermataInizialeController implements Initializable {

    @FXML private Button nuova;
    @FXML private Button carica;
    @FXML private Button effetti;
    @FXML private Button musica;
    @FXML private Button istruzioni;
    @FXML private Label tit1;
    @FXML private Label tit2;   
    @FXML private AnchorPane ap;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ap.setBackground(new Background(new BackgroundImage(Resources.GeneralImages.BACKGROUNDF.getImage(),
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundPosition.CENTER,
                                                            BackgroundSize.DEFAULT)));
        istruzioni.setGraphic(new ImageView(Resources.GeneralImages.ISTRUZIONI.getImage()));
        
        
        if(Resources.Music.SOUNDINTRO.getToggleMusic()){
            musica.setGraphic(new ImageView(Resources.GeneralImages.VOLUMEON.getImage()));
            musica.setId("volume");
        }else{
            musica.setGraphic(new ImageView(Resources.GeneralImages.VOLUMEOFF.getImage()));
            musica.setId("volumeOff");      
        }
        
        if(Resources.SoundEffects.BUTTONCLICK.getToggleEffect()){
            effetti.setGraphic(new ImageView(Resources.GeneralImages.EFFETTION.getImage()));
            effetti.setId("eff");
        }else{
            effetti.setGraphic(new ImageView(Resources.GeneralImages.EFFETTIOFF.getImage()));
            effetti.setId("effettiOff");
        }
        
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
        if(musica.getId().equals("volume")){
            musica.setGraphic(new ImageView(Resources.GeneralImages.VOLUMEOFF.getImage()));
            musica.setId("volumeOff");
        }else{
            musica.setGraphic(new ImageView(Resources.GeneralImages.VOLUMEON.getImage()));
            musica.setId("volume");
        }
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
        if(effetti.getId().equals("eff")){
            effetti.setGraphic(new ImageView(Resources.GeneralImages.EFFETTIOFF.getImage()));
            effetti.setId("effettiOff");
        }else{
            effetti.setGraphic(new ImageView(Resources.GeneralImages.EFFETTION.getImage()));
            effetti.setId("eff");
        }

        
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

