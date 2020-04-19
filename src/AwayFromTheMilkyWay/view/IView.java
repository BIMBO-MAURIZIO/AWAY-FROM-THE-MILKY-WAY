/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



/**
 *
 * @author giorg
 */
public interface IView {
   abstract void changeCurrentWindow(String window) throws IOException;
   abstract void openGameWindow(int level) ;
   public GameWindow getGameWindow();
   public Scene getScene();
   public void pause();
   public Stage getPauseStage();
   public Stage getMainStage();
   public Circle getMilkyWay();
   public void explosion();
   public Circle getSpaceship();
   public GamePane getGamePane();
   public PlayerDataPane getDataPane();
   public void createAlert(String window);
   public Stage getAlertStage();
   public void handleExit();
   public void backwash();
   
   
}
