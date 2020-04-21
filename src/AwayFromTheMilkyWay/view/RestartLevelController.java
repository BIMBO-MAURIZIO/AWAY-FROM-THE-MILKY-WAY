/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class RestartLevelController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void restartLevel(){
        View.getInstance().getAlertStage().close();
        ControllerForView.getInstance().restartLevel();
        View.getInstance().getDataPane().enableButton();
    }
    
    public void exit() throws IOException{
        View.getInstance().getAlertStage().close();
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
        View.getInstance().getDataPane().enableButton();
        ControllerForView.getInstance().setCurrentLevel(1);//ogni qualvolta l'utente cliccherà exit e poi nuova partita dovrà ripartire da livello 1
        
    }
    
}
