
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


public class InstructionsController implements Initializable {

    @FXML private Label tit1i;
    @FXML private Label tit2i;
    @FXML private Label testo;
    @FXML private Button backi;
    @FXML private AnchorPane ap;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ap.setBackground(new Background(new BackgroundImage(Resources.GeneralImages.BACKGROUNDF.getImage(),
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundPosition.CENTER,
                                                            BackgroundSize.DEFAULT)));
        
        backi.setGraphic(new ImageView(Resources.GeneralImages.BACK.getImage()));
        testo.setGraphic(new ImageView(Resources.GeneralImages.TESTO.getImage()));
        
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
        testo.setLayoutX(190);
        testo.setLayoutY(75);
    }  
    
    public void back() throws IOException{
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
    }
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
    
}
