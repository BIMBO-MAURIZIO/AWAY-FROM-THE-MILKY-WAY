/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public class GamePane extends AnchorPane {//sarà la schermata di gioco che  dovràconvivere nella stessa scena con la playerDataPane.
    
    private Circle spaceship;  
    
    
    public GamePane(){//avevo intenzione di mettere qui la dipendenza dal livello così da cambiare lo scenario in base al livello automaticamente
        super();
       
    }
        
    
    public void setScenario(int levelNumber) {
        Image image = new Image("AwayFromTheMilkyWay/media/images/spazio2.jpg");
        ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
       // this.setBackground(new Background(new BackgroundFill(RED,CornerRadii.EMPTY,Insets.EMPTY)));
        
        switch(levelNumber){
            
            case 1 :  spaceship = new Circle(100,100,50);//x, y , raggio   
                      this.getChildren().add(spaceship);
                
            case 2 :
                
            case 3 :
        
            case 4 :
        
            case 5 :
        
            case 6 :        
        
            case 7 :    
        
            case 8 :    
        }
        
        
    }
}
