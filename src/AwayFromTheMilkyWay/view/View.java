/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
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
    private GameWindow game;
    private Scene scene;
        
    
    
    public View(){
        stage = new Stage();
    }
      
           
    public static IView getInstance() {
        if(instance == null)
            instance = new View();
        return instance;
    }
    
    public void closeWindow(){
        if(this.stage != null){
            
            this.stage.close();
            this.stage = null;
        }
    
    }
    
   
    //metodi per switchare le scene
    
    @Override
    public void changeCurrentWindow(String window) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource(window));
    
        scene = new Scene(root, 1280, 800);
    
        stage.setTitle("Away From the Milky Way");
        stage.setScene(scene);
        stage.show();
        
        
    
    
    }
    
    @Override
    public void openGameWindow(int level){
        
        game = new GameWindow();
        game.composeWindow(level);
        scene = new Scene(game, 1280, 900);
        ControllerForView.getInstance().startMovimento();
        
        stage.setTitle("Away From the Milky Way");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    
    }
    
   
    //metodi per restituire oggetti relativi alla finestra
    
    @Override
    public GameWindow getGameWindow(){
        return this.game;
    }
    
    
    @Override
    public Scene getScene(){
        return this.scene;
    }
    
   
 
    
    
}//end class
