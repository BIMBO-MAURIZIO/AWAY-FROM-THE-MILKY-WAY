/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class LevelCompleteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void nextLevel(){
        View.getInstance().getAlertStage().close();
        ControllerForView.getInstance().nextLevel(ControllerForView.getInstance().getCurrentLevel());
        View.getInstance().getDataPane().enableButton();
    }
}
