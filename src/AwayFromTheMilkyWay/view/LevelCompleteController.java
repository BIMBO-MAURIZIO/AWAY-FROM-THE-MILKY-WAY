
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
import AwayFromTheMilkyWay.utils.Resources;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class LevelCompleteController implements Initializable {

    @FXML private Label sup;
    @FXML private Button next;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sup.setLayoutX(125);
        sup.setLayoutY(57);
        sup.setMinSize(70,46);
        sup.setMaxSize(70,46);
        sup.setText(sup.getText().toUpperCase());
        next.setLayoutX(68);
        next.setLayoutY(135);
        next.setText(next.getText().toUpperCase());
    }      
    
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
    
    
    public void nextLevel(){
        View.getInstance().getAlertStage().close();
        ControllerForView.getInstance().nextLevel(ControllerForView.getInstance().getCurrentLevel());
        View.getInstance().getDataPane().enableButton();
    }
}
