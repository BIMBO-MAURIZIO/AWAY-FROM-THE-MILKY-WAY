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
    
    private Stage stage;
    private static View instance;
        
        
    
    public View(){
        stage = new Stage();
    }
      
           
    public static IView getInstance() {
        if(instance == null)
            instance = new View();
        return instance;
    }
    
   
    
    
    @Override
    public void changeCurrentWindow(String window) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(window));
    
        Scene scene = new Scene(root, 1280, 800);
    
        stage.setTitle("Away From the Milky Way");
        stage.setScene(scene);
        stage.show();
    
    
    }
    
}
