/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.utils.Resources;
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
    
    private Circle spaceship, planet1, planet2, milkyWay;  
   
    public GamePane(){//avevo intenzione di mettere qui la dipendenza dal livello così da cambiare lo scenario in base al livello automaticamente
        super();
       
    }
        
    
    public void setScenario(int levelNumber) throws IOException {
        //Image image = new Image("AwayFromTheMilkyWay/configuration/media/images/spazio2.jpg");
        ImageView imageView = new ImageView(Resources.GeneralImages.BACKGROUND.getImage());
        this.getChildren().add(imageView);
      
        
        if(levelNumber == 1){
            
              spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
            
                      planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1Radius")));
                      planet1.setFill(new ImagePattern(Resources.GeneralImages.MERCURIO.getImage()));
                      planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2Radius")));
                      planet2.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                      spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                      
                      milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "milkyWayRadius")));
                      milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                      this.getChildren().addAll(spaceship,planet1,planet2,milkyWay);
                
        }else if(levelNumber == 2){   
                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
            
                      planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1Radius")));
                      planet1.setFill(new ImagePattern(Resources.GeneralImages.MERCURIO.getImage()));
                      planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2Radius")));
                      planet2.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                      spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                      milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "milkyWayRadius")));
                      milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                      this.getChildren().addAll(spaceship,planet1,planet2,milkyWay);
            }
                      
            
        
        
        
    }//end setScenario
    
    public Circle getSpaceship(){
        return this.spaceship;
    }
    
    public Circle getMilkyWay(){
        return this.milkyWay;
    }
    
    public Circle getPlanet1(){
        return this.planet1;
    }
    
    public void setSpaceshipIm(Image i){
        this.spaceship.setFill(new ImagePattern(i));
    }
    
}   
