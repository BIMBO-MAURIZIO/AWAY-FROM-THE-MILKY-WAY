/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
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
    
    public void nextLevel(){
        View.getInstance().getAlertStage().close();
        ControllerForView.getInstance().nextLevel(ControllerForView.getInstance().getCurrentLevel());
        View.getInstance().getDataPane().enableButton();
    }
}
