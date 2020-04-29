
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
import AwayFromTheMilkyWay.utils.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class VittoriaController implements Initializable {

    @FXML private Label win;
    @FXML private Label win1;
    @FXML private Button esci1;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        win.setLayoutX(108);
        win.setLayoutY(45);
        win.setMinSize(102,34);
        win.setMaxSize(102,34);
        win.setText(win.getText().toUpperCase());
        win1.setLayoutX(90);
        win1.setLayoutY(93);
        win1.setMinSize(135,34);
        win1.setMaxSize(135,34);
        win1.setText(win1.getText().toUpperCase());
        esci1.setLayoutX(128);
        esci1.setLayoutY(152);
        esci1.setText(esci1.getText().toUpperCase());
    }   
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
    
    
    public void exit() throws IOException{
        View.getInstance().getAlertStage().close();
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
        Resources.Music.SOUNDINTRO.play();
        View.getInstance().getDataPane().enableButton();
        ControllerForView.getInstance().setCurrentLevel(1); 
    }
}
