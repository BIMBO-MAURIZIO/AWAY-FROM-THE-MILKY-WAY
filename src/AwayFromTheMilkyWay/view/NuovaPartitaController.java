
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
import AwayFromTheMilkyWay.utils.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class NuovaPartitaController implements Initializable {
        
    @FXML private Label tit11;
    @FXML private Label tit22;
    @FXML private Label nome;
    @FXML private Button back;
    @FXML private Button start;
    @FXML private TextField textField;
    private String name;
    private Alert errorAlert = new Alert(AlertType.ERROR);
   
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        tit11.setLayoutX(694);
        tit11.setLayoutY(75);
        tit11.setMinSize(374,112);
        tit11.setMaxSize(374,112);
        tit11.setText(tit11.getText().toUpperCase());
        tit22.setLayoutX(646);
        tit22.setLayoutY(173);
        tit22.setMinSize(450,106);
        tit22.setMaxSize(450,106);
        tit22.setText(tit22.getText().toUpperCase());
        back.setLayoutX(53);
        back.setLayoutY(45);
        nome.setLayoutX(150);
        nome.setLayoutY(279);
        nome.setMinSize(172,34);
        nome.setMaxSize(172,34);
        nome.setText(nome.getText().toUpperCase());
        textField.setLayoutX(337);
        textField.setLayoutY(277);
        start.setLayoutX(253);
        start.setLayoutY(339);
        start.setMinSize(150,50);
        start.setMaxSize(150,50);
        start.setText(start.getText().toUpperCase());
       
    }   
    @FXML
    private void keyPressed(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.ENTER) {
            iniziaPartita();
        }
    }
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
    
    public void back() throws IOException{
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
    }
    
    public void iniziaPartita(){
        name = textField.getText();
        String path = "src\\AwayFromTheMilkyWay\\configuration\\logs\\"+name;
        File f= new File(path);
        if(name.isEmpty()){
            errorAlert =  new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input non valido!");
            errorAlert.setContentText("Inserisci il nome!");
            Stage stage = (Stage) errorAlert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(Resources.GeneralImages.SPACEMANICON.getImage());
            errorAlert.show();
          
        }else if(name.length() >=  20){
            errorAlert =  new Alert(AlertType.ERROR); 
            errorAlert.setHeaderText("Input non valido!");
            errorAlert.setContentText("Il tuo nickname deve avere meno di 30 caratteri!");
            Stage stage = (Stage) errorAlert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(Resources.GeneralImages.SPACEMANICON.getImage());
            errorAlert.show();
            
        }else if(f.exists()){
            errorAlert =  new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input non valido!");
            errorAlert.setContentText("Questo nickname è già esistente!");
            Stage stage = (Stage) errorAlert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(Resources.GeneralImages.SPACEMANICON.getImage());
            errorAlert.show();
        }else{   
            View.getInstance().openGameWindow(1);
            ControllerForView.getInstance().setName(name);
            
        }   
        
        
    }
    
     
    
    
      
    
    
    
   
}
