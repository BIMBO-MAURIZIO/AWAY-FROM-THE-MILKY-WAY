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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class OpzioniPausaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    
}