
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.utils.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class InstructionsController implements Initializable {

    @FXML private Label tit1i;
    @FXML private Label tit2i;
    @FXML private Label testo;
    @FXML private Button backi;
    
   

 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tit1i.setLayoutX(694);
        tit1i.setLayoutY(75);
        tit1i.setMinSize(374,112);
        tit1i.setMaxSize(374,112);
        tit1i.setText(tit1i.getText().toUpperCase());
        tit2i.setLayoutX(646);
        tit2i.setLayoutY(173);
        tit2i.setMinSize(450,106);
        tit2i.setMaxSize(450,106);
        tit2i.setText(tit2i.getText().toUpperCase());
        backi.setLayoutX(53);
        backi.setLayoutY(45);
        testo.setLayoutX(85);
        testo.setLayoutY(45);
    }  
    
    public void back() throws IOException{
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
    }
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
    
    
}
