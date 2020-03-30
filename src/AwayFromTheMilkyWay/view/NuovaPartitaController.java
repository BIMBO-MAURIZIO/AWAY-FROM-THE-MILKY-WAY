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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class NuovaPartitaController implements Initializable {
        
    @FXML TextField textField;
    String name;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void back() throws IOException{
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
    }
    
    public void iniziaPartita(){
        
        name = textField.getText();
        View.getInstance().openGameWindow(1);
        ControllerForView.getInstance().setName(name);
        
    }
    
    
      
}
