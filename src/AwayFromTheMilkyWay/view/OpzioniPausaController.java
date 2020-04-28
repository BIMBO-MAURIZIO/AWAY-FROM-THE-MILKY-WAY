/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
import AwayFromTheMilkyWay.utils.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



public class OpzioniPausaController implements Initializable {

   
    @FXML private Button salva;
    @FXML private Button exit;
    @FXML private Button effetti;
    @FXML private Button musica;
    @FXML private Button backo;
    @FXML private Label tit1o;
    @FXML private Label tit2o;
    @FXML private ChoiceBox immagine;
    @FXML private ChoiceBox songs;
    static int sceltaImg;
   
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
        
        int currLev = ControllerForView.getInstance().getCurrentLevel();
        switch (currLev) {
            case 1:
            case 2:
                immagine.setItems(FXCollections.observableArrayList("astronave"));
                break;
            case 3:
            case 4:
                immagine.setItems(FXCollections.observableArrayList("astronave","pizza"));
                break;
            case 5:
            case 6:
                immagine.setItems(FXCollections.observableArrayList("astronave","pizza","ciambella"));
                break;
            case 7:
            case 8:
                immagine.setItems(FXCollections.observableArrayList("astronave","pizza","ciambella","orologio"));
                break;
            default:
                immagine.setItems(FXCollections.observableArrayList("astronave"));
                break;
        }
        
        immagine.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov,
                    Number Value, Number new_value) {
                        sceltaImg = new_value.intValue();
                switch (sceltaImg) {
                    case 0:
                        View.getInstance().getGamePane().setSpaceshipIm(Resources.GeneralImages.SPACESHIP.getImage());
                        break;
                    case 1:
                        View.getInstance().getGamePane().setSpaceshipIm(Resources.GeneralImages.PIZZA.getImage());
                        break;
                    case 2:
                        View.getInstance().getGamePane().setSpaceshipIm(Resources.GeneralImages.CIAMBELLA.getImage());
                        break;
                    case 3:
                        View.getInstance().getGamePane().setSpaceshipIm(Resources.GeneralImages.OROLOGIO.getImage());
                        break;
                    default:
                        break;
                }
                        
            }
        });
 
        songs.setItems(FXCollections.observableArrayList("traccia 1","traccia 2","traccia 3"));
        
    
           
        salva.setLayoutX(153);
        salva.setLayoutY(77);
        salva.setText(salva.getText().toUpperCase());
        exit.setLayoutX(153);
        exit.setLayoutY(212);
        exit.setText(exit.getText().toUpperCase());
        musica.setLayoutX(205);
        musica.setLayoutY(347);
        effetti.setLayoutX(295);
        effetti.setLayoutY(347);
        backo.setLayoutX(30);
        backo.setLayoutY(25);
        tit1o.setLayoutX(694);
        tit1o.setLayoutY(75);
        tit1o.setMinSize(374,112);
        tit1o.setMaxSize(374,112);
        tit1o.setText(tit1o.getText().toUpperCase());
        tit2o.setLayoutX(646);
        tit2o.setLayoutY(173);
        tit2o.setMinSize(450,106);
        tit2o.setMaxSize(450,106);
        tit2o.setText(tit2o.getText().toUpperCase());
    }   
      
    
    
    public void back(){

        View.getInstance().getPauseStage().close();
        View.getInstance().getMainStage().show();
       
        ControllerForView.getInstance().playAnimations();
    
    }
    
    @FXML
    private void keyPressed(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.ESCAPE) {
            back();
        }
    }
    
    public void saveGame(){
        ControllerForView.getInstance().saveGame();
    }
    
    public void exit() throws IOException{
        View.getInstance().getPauseStage().close();
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
        View.getInstance().getMainStage().show();
        Resources.Music.SOUNDTRACK.stop();
        Resources.Music.SOUNDINTRO.play();
        View.getInstance().getDataPane().enableButton();
        ControllerForView.getInstance().setCurrentLevel(1);
    }
    
    public void toggleMusic(){//ricordati che per i tasti sviluppati in game il discorso deve essere opposto,ossia l'if deve essere fattomsolamente per la musica SOUNDTRACK
        if(musica.getId().equals("volume"))
            musica.setId("volumeOff");
        else
            musica.setId("volume");
        Resources.Music.SOUNDTRACK.toggleMusicEnabled();
        Resources.Music.SOUNDINTRO.toggleMusicEnabled();
        if(Resources.Music.SOUNDTRACK.getToggleMusic()){
            Resources.Music.SOUNDTRACK.play();
            
        }else{
            Resources.Music.SOUNDTRACK.stop();
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
    
    public static int getScelta(){
        return OpzioniPausaController.sceltaImg;
    }
    
    
    
}