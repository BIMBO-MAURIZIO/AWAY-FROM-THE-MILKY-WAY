/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.utils.Utils;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public class GamePane extends AnchorPane {//sarà la schermata di gioco che  dovràconvivere nella stessa scena con la playerDataPane.
    
    private Circle spaceship;  
    private Circle planet1;  
    private Circle planet2;  
    Image mercurio = new Image("AwayFromTheMilkyWay/configuration/media/images/mercurio.png");
    Image giove = new Image("AwayFromTheMilkyWay/configuration/media/images/giove.png");
    
    
    public GamePane(){//avevo intenzione di mettere qui la dipendenza dal livello così da cambiare lo scenario in base al livello automaticamente
        super();
       
    }
        
    
    public void setScenario(int levelNumber) throws IOException {
        Image image = new Image("AwayFromTheMilkyWay/configuration/media/images/spazio2.jpg");
        ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
       // this.setBackground(new Background(new BackgroundFill(RED,CornerRadii.EMPTY,Insets.EMPTY)));
        
        switch(levelNumber){
            
            case 1 :  spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "SpaceshipY")),
                                             50);//x, y , raggio   
            
                      planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1Radius")));
                      planet1.setFill(new ImagePattern(mercurio));
                      planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2Radius")));
                      planet2.setFill(new ImagePattern(giove));
                      spaceship.setFill(javafx.scene.paint.Color.RED);
                      //planet1.setFill(javafx.scene.paint.Color.IVORY);
                      //planet2.setFill(javafx.scene.paint.Color.OLIVE);
                      this.getChildren().addAll(spaceship,planet1,planet2);
                      
                
            case 2 :
                
            case 3 :
        
            case 4 :
        
            case 5 :
        
            case 6 :        
        
            case 7 :    
        
            case 8 :    
        }
        
        
    }//end setScenario
    
    public Circle getSpaceship(){
        return this.spaceship;
    }
    
    public Circle getPlanet1(){
        return this.planet1;
    }
    
}   
