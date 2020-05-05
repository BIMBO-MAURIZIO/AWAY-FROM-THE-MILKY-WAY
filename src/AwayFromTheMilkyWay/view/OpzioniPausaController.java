
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;



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
    @FXML private Label astronavi;
    @FXML private Label canzoni;
    @FXML private AnchorPane ap;
    private static int sceltaImg;
    private static int sceltaSong;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ap.setBackground(new Background(new BackgroundImage(Resources.GeneralImages.BACKGROUNDF.getImage(),
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundPosition.CENTER,
                                                            BackgroundSize.DEFAULT)));
        
        backo.setGraphic(new ImageView(Resources.GeneralImages.BACK.getImage()));
        
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
        
        updateCBI();
        int currLev = ControllerForView.getInstance().getCurrentLevel();
        switch (currLev) {
            case 1:
            case 2:
                immagine.setItems(FXCollections.observableArrayList("ASTRONAVE"));
                break;
            case 3:
            case 4:
                immagine.setItems(FXCollections.observableArrayList("ASTRONAVE","PIZZA"));
                break;
            case 5:
            case 6:
                immagine.setItems(FXCollections.observableArrayList("ASTRONAVE","PIZZA","CIAMBELLA"));
                break;
            case 7:
            case 8:
                immagine.setItems(FXCollections.observableArrayList("ASTRONAVE","PIZZA","CIAMBELLA","OROLOGIO"));
                break;
            default:
                immagine.setItems(FXCollections.observableArrayList("ASTRONAVE"));
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
                        sceltaImg = 0;
                        break;
                }        
            }
        });
        
        updateCBS();
        songs.setItems(FXCollections.observableArrayList("MUSICA ELETTRONICA","MUSICA CLASSICA","BANANA SONG"));
        songs.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov,
                    Number Value, Number new_value) {
                        sceltaSong = new_value.intValue();
                switch (sceltaSong) {
                    case 0:
                        Resources.Music.SOUNDTRACK2.stop();
                        Resources.Music.SOUNDTRACK3.stop();
                        Resources.Music.SOUNDTRACK.play();   
                        break;
                    case 1:
                        Resources.Music.SOUNDTRACK2.play();
                        Resources.Music.SOUNDTRACK3.stop();
                        Resources.Music.SOUNDTRACK.stop(); 
                        break;
                    case 2:
                        Resources.Music.SOUNDTRACK2.stop();
                        Resources.Music.SOUNDTRACK3.play();
                        Resources.Music.SOUNDTRACK.stop(); 
                        break;
                    default:
                        sceltaSong = 0;
                        break;     
                } 
               
            }
        });
        
    
        salva.setLayoutX(47);
        salva.setLayoutY(400);
        salva.setMinSize(223,50);
        salva.setMaxSize(223,50);
        salva.setText(salva.getText().toUpperCase());
        exit.setLayoutX(323);
        exit.setLayoutY(400);
        exit.setMinSize(223,50);
        exit.setMaxSize(223,50);
        exit.setText(exit.getText().toUpperCase());  
        musica.setLayoutX(230);
        musica.setLayoutY(303);
        effetti.setLayoutX(313);
        effetti.setLayoutY(303);
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
        astronavi.setLayoutX(178);
        astronavi.setLayoutY(101);
        astronavi.setMinSize(104,34);
        astronavi.setMaxSize(104,34);
        astronavi.setText(astronavi.getText().toUpperCase());
        canzoni.setLayoutX(183);
        canzoni.setLayoutY(198);
        canzoni.setMinSize(93,34);
        canzoni.setMaxSize(93,34);
        canzoni.setText(canzoni.getText().toUpperCase());
        immagine.setLayoutX(313);
        immagine.setLayoutY(98);
        immagine.setMinSize(157,37);
        immagine.setMaxSize(157,37);
        songs.setLayoutX(313);
        songs.setLayoutY(195);
        songs.setMinSize(157,37);
        songs.setMaxSize(157,37);
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
        Resources.Music.SOUNDTRACK2.stop();
        Resources.Music.SOUNDTRACK3.stop();
        Resources.Music.SOUNDINTRO.play();
        View.getInstance().getDataPane().enableButton();
        ControllerForView.getInstance().setCurrentLevel(1);
    }
    
    
    public void toggleMusic(){
        if(musica.getId().equals("volume")){
            musica.setId("volumeOff");
            musica.setGraphic(new ImageView(Resources.GeneralImages.VOLUMEOFF.getImage()));
        }else{
            musica.setId("volume");
            musica.setGraphic(new ImageView(Resources.GeneralImages.VOLUMEON.getImage()));
        }
        Resources.Music.SOUNDTRACK.toggleMusicEnabled();
        Resources.Music.SOUNDTRACK2.toggleMusicEnabled();
        Resources.Music.SOUNDTRACK3.toggleMusicEnabled();
        Resources.Music.SOUNDINTRO.toggleMusicEnabled();
        if(Resources.Music.SOUNDTRACK.getToggleMusic() && OpzioniPausaController.getSong() == 0){
            Resources.Music.SOUNDTRACK.play();  
        }else if(Resources.Music.SOUNDTRACK2.getToggleMusic() && OpzioniPausaController.getSong() == 1){
            Resources.Music.SOUNDTRACK2.play();
        }else if(Resources.Music.SOUNDTRACK3.getToggleMusic() && OpzioniPausaController.getSong() == 2){
            Resources.Music.SOUNDTRACK3.play();
        }else{
            Resources.Music.SOUNDTRACK.stop();  
            Resources.Music.SOUNDTRACK2.stop();
            Resources.Music.SOUNDTRACK3.stop();
        }
    }
    
    
    public void toggleEffects(){
        
        if(effetti.getId().equals("eff")){
            effetti.setId("effettiOff");
            effetti.setGraphic(new ImageView(Resources.GeneralImages.EFFETTIOFF.getImage()));
        }else{
            effetti.setId("eff");
            effetti.setGraphic(new ImageView(Resources.GeneralImages.EFFETTION.getImage()));
        }
        Resources.SoundEffects.BUTTONCLICK.toggleSoundEnabled();
        Resources.SoundEffects.DEFEAT.toggleSoundEnabled();
        Resources.SoundEffects.EXPLOSION.toggleSoundEnabled();
        Resources.SoundEffects.PLANETHIT.toggleSoundEnabled();
        Resources.SoundEffects.VICTORY.toggleSoundEnabled();
    }
    
    
    public static int getScelta(){
        return OpzioniPausaController.sceltaImg;
    }
    
    
    public static int getSong(){
        return OpzioniPausaController.sceltaSong;
    }
    
    
    public void updateCBS(){
        switch (sceltaSong) {
            case 0:
                songs.setValue("MUSICA ELETTRONICA");
                break;
            case 1:
                songs.setValue("MUSICA CLASSICA");
                break;
            case 2:
                songs.setValue("BANANA SONG");
                break;
            default:
                break;
        }
    }
    
    
    public void updateCBI(){
        switch (sceltaImg) {
            case 0:
                immagine.setValue("ASTRONAVE");
                break;
            case 1:
                immagine.setValue("PIZZA");
                break;
            case 2:
                immagine.setValue("CIAMBELLA");
                break;
            case 3:
                immagine.setValue("OROLOGIO");
                break;
            default:
                break;
        }
    }
    
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
}