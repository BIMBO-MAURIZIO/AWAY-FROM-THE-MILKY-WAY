
package AwayFromTheMilkyWay.controller;


import AwayFromTheMilkyWay.utils.Resources;
import AwayFromTheMilkyWay.view.View;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;


public class AwayFromTheMilkyWay extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        

        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
        Resources.Music.SOUNDINTRO.play();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
