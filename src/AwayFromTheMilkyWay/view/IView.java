
package AwayFromTheMilkyWay.view;

import java.io.IOException;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public interface IView {
   abstract void changeCurrentWindow(String window) throws IOException;
   abstract void openGameWindow(int level) ;
   public void createAlert(String window);
   public void pause();
   public void handleExit();
   
   public GameWindow getGameWindow();
   public Scene getScene();
   public Stage getPauseStage();
   public Stage getMainStage();
   public Circle getMilkyWay();
   public Circle getSpaceship();
   public GamePane getGamePane();
   public PlayerDataPane getDataPane();
   public Stage getAlertStage();
   public String getNome();
   public Circle getMovingObstacle1();
   public Circle getMovingObstacle2();
   public Button getHelpButton();
   public Timeline getT1();
   public Timeline getT2();
   public Timeline getT3();
   public int getRimbDes();
   
   public void setTimelines();
   public void explosion();
   public void backwashWin();
   public void backwashLose();

}
