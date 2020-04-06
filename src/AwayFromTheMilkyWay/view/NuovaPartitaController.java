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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class NuovaPartitaController implements Initializable {
        
    @FXML TextField textField;
    String name;
    Alert errorAlert = new Alert(AlertType.ERROR);
    
    @FXML
    private void keyPressed(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.ENTER) {
            iniziaPartita();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void back() throws IOException{
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
    }
    
    public void iniziaPartita(){
        name = textField.getText();
        if(name.isEmpty()){
            
            errorAlert.setHeaderText("Input non valido!");
            errorAlert.setContentText("Inserisci il nome!");
            errorAlert.showAndWait();
        }else if(name.length()>= 30){
             
            errorAlert.setHeaderText("Input non valido!");
            errorAlert.setContentText("Il tuo nickname deve avere meno di 30 caratteri!");
            errorAlert.showAndWait();
        }else{   
            View.getInstance().openGameWindow(1);
            ControllerForView.getInstance().setName(name);
        }
        
        
    }
    
    
      
}
