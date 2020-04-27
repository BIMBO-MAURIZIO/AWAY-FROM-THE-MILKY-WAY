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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class RestartLevelController implements Initializable {

    
    @FXML private Label lose;
    @FXML private Label cosa;
    @FXML private Button retry;
    @FXML private Button esci;

 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lose.setLayoutX(98);
        lose.setLayoutY(37);
        lose.setMinSize(114,35);
        lose.setMaxSize(114,35);
        lose.setText(lose.getText().toUpperCase());
        cosa.setLayoutX(94);
        cosa.setLayoutY(91);
        cosa.setMinSize(130,33);
        cosa.setMaxSize(130,33);
        cosa.setText(cosa.getText().toUpperCase());
        retry.setLayoutX(67);
        retry.setLayoutY(155);
        esci.setLayoutX(195);
        esci.setLayoutY(155);
        esci.setText(esci.getText().toUpperCase());
        
    }

    public void restartLevel(){
        View.getInstance().getAlertStage().close();
        ControllerForView.getInstance().restartLevel();
        View.getInstance().getDataPane().enableButton();
    }
    
    public void exit() throws IOException{
        View.getInstance().getAlertStage().close();
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
        Resources.Music.SOUNDINTRO.play();
        View.getInstance().getDataPane().enableButton();
        ControllerForView.getInstance().setCurrentLevel(1);//ogni qualvolta l'utente cliccherà exit e poi nuova partita dovrà ripartire da livello 1
        
    }
    
}
