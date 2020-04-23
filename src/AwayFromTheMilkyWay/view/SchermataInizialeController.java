/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.utils.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class SchermataInizialeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void nuovaPartita() throws IOException{
        View.getInstance().changeCurrentWindow("nuovaPartita.fxml");
    }
    
    
    public void caricaPartita() throws IOException{
        View.getInstance().changeCurrentWindow("caricaPartita.fxml");
    }
    
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
}//ciao

