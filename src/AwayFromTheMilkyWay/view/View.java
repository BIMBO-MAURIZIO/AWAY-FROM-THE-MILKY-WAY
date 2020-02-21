/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author giorg
 */
public class View implements IView{
    
    //metodo per switchare le finestre
    private void changeCurrentWindow(Stage stage, String window, String title, int windowWidth, int windowHeight) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(window));
    
        Scene scene = new Scene(root, windowWidth, windowHeight);
    
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    
    
    }
    
}
