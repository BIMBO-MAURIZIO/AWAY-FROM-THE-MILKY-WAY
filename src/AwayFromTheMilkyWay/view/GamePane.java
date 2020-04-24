/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
import AwayFromTheMilkyWay.utils.Resources;
import AwayFromTheMilkyWay.utils.Utils;
import java.io.IOException;
import javafx.scene.control.Button;
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
    
    private Circle spaceship, planet1, planet2,planet3,planet4,milkyWay,fixObstacle1,fixObstacle2,movingObstacle1,movingObstacle2;  
   
    public GamePane(){//avevo intenzione di mettere qui la dipendenza dal livello così da cambiare lo scenario in base al livello automaticamente
        super();
       
    }
        
    
    public void setScenario(int levelNumber) throws IOException {
        //Image image = new Image("AwayFromTheMilkyWay/configuration/media/images/spazio2.jpg");
        ImageView imageView = new ImageView(Resources.GeneralImages.BACKGROUND.getImage());
        
        
        Button help = new Button();
        help.setPrefSize(40, 40);
        help.setMaxSize(40, 40);
        help.setLayoutX(1240);
        help.setLayoutY(40);
        

        help.setOnAction(event -> {
            ControllerForView.getInstance().nextLevel(ControllerForView.getInstance().getCurrentLevel());
        });
        this.getChildren().addAll(imageView,help);
        
        if(levelNumber == 1){
            
                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
                    spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                    
                    planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1Radius")));
                    planet1.setFill(new ImagePattern(Resources.GeneralImages.MERCURIO.getImage()));
                    
                    planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2Radius")));
                    planet2.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                    
                    planet4 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet4X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet4Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet4Radius")));
                    planet4.setFill(new ImagePattern(Resources.GeneralImages.MARTE.getImage()));
                    
                    planet3 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet3X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet3Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet3Radius")));
                    planet3.setFill(new ImagePattern(Resources.GeneralImages.URANIO.getImage()));
                     
                    milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "milkyWayRadius")));
                    milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                    
                    
                    
                    this.getChildren().addAll(spaceship,planet1,planet2,planet3,planet4,milkyWay);
                    
                    
                
        }else if(levelNumber == 2){   
                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
                    spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                    
                    milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "milkyWayRadius")));
                    milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                    
                    planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1Radius")));
                    planet1.setFill(new ImagePattern(Resources.GeneralImages.URANIO.getImage()));
                    
                    planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2Radius")));
                    planet2.setFill(new ImagePattern(Resources.GeneralImages.TERRA.getImage()));
                    
                    planet3 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet3X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet3Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet3Radius")));
                    planet3.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                    
                    planet4 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet4X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet4Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet4Radius")));
                    planet4.setFill(new ImagePattern(Resources.GeneralImages.MARTE.getImage()));
                    
                    fixObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle1Radius")));
                    fixObstacle1.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE1.getImage()));
                    
                    
                    
                    this.getChildren().addAll(spaceship,planet1,planet2,planet3,planet4,milkyWay,fixObstacle1);
        }else if(levelNumber == 3){
                                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
                                    spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                                    
                                    milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "milkyWayRadius")));
                                    milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                                    planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet1Radius")));
                                    planet1.setFill(new ImagePattern(Resources.GeneralImages.URANIO.getImage()));
                                    
                                    planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet2X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet2Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet2Radius")));
                                    planet2.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                                    
                                    planet3 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet3X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet3Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet3Radius")));
                                    planet3.setFill(new ImagePattern(Resources.GeneralImages.TERRA.getImage()));
                    
                                    planet4 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet4X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet4Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "planet4Radius")));
                                    planet4.setFill(new ImagePattern(Resources.GeneralImages.MARTE.getImage()));
                                    
                                    fixObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "fixObstacle1Radius")));
                                    fixObstacle1.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE1.getImage()));
                                    
                                    movingObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "movingObstacle1X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "movingObstacle1Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level3.txt", "movingObstacle1Radius")));
                                    movingObstacle1.setFill(new ImagePattern(Resources.GeneralImages.ALIEN.getImage()));
            
                                    this.getChildren().addAll(spaceship,planet1,planet2,planet3,planet4,milkyWay,fixObstacle1,movingObstacle1);
        
        }else if(levelNumber == 4){
                                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
                                    spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                                    
                                    milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "milkyWayRadius")));
                                    milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                                        planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet1X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet1Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet1Radius")));
                                        planet1.setFill(new ImagePattern(Resources.GeneralImages.MERCURIO.getImage()));

                                        planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet2X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet2Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet2Radius")));
                                        planet2.setFill(new ImagePattern(Resources.GeneralImages.NETTUNO.getImage()));
                                        
                                        planet3 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet3X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet3Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet3Radius")));
                                        planet3.setFill(new ImagePattern(Resources.GeneralImages.TERRA.getImage()));
                    
                                        planet4 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet4X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet4Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "planet4Radius")));
                                        planet4.setFill(new ImagePattern(Resources.GeneralImages.MARTE.getImage()));

                                        fixObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "fixObstacle1X")),
                                                    Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "fixObstacle1Y")),
                                                    Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "fixObstacle1Radius")));
                                        fixObstacle1.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE1.getImage()));

                                        fixObstacle2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "fixObstacle2X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "fixObstacle2Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level4.txt", "fixObstacle2Radius")));
                                        fixObstacle2.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE2.getImage()));
                                    
                                    this.getChildren().addAll(spaceship,planet1,planet2,planet3,planet4,milkyWay,fixObstacle1,fixObstacle2);
        
        }else if(levelNumber == 5){
                                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
                                    spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                                    
                                    milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "milkyWayRadius")));
                                    milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                                    
                                    planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet1X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet1Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet1Radius")));
                                    planet1.setFill(new ImagePattern(Resources.GeneralImages.MARTE.getImage()));

                                    planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet2X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet2Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet2Radius")));
                                    planet2.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                                    
                                    planet3 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet3X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet3Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "planet3Radius")));
                                        planet3.setFill(new ImagePattern(Resources.GeneralImages.TERRA.getImage()));
   

                                    fixObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "fixObstacle1X")),
                                                    Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "fixObstacle1Y")),
                                                    Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "fixObstacle1Radius")));
                                    fixObstacle1.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE1.getImage()));

                                    fixObstacle2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "fixObstacle2X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "fixObstacle2Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "fixObstacle2Radius")));
                                    fixObstacle2.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE2.getImage()));
                                    
                                    movingObstacle2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "movingObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "movingObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level5.txt", "movingObstacle2Radius")));   
                                    movingObstacle2.setFill(new ImagePattern(Resources.GeneralImages.ALIEN2.getImage()));
                                    
                                    this.getChildren().addAll(spaceship,planet1,planet2,planet3,milkyWay,fixObstacle1,fixObstacle2,movingObstacle2);
        
        }else if(levelNumber == 6){
                                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
                                    spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                                    
                                    milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "milkyWayRadius")));
                                    milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                                    
                                   
                                    planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet1Radius")));
                                    planet1.setFill(new ImagePattern(Resources.GeneralImages.MERCURIO.getImage()));
                                    
                                    planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet2X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet2Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet2Radius")));
                                    planet2.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                                    
                                    planet3 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet3X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet3Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet3Radius")));
                                    planet3.setFill(new ImagePattern(Resources.GeneralImages.MARTE.getImage()));
                                    
                                    planet4 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet4X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet4Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "planet4Radius")));
                                    planet4.setFill(new ImagePattern(Resources.GeneralImages.TERRA.getImage()));
                                    
                                    fixObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "fixObstacle1Radius")));
                                    fixObstacle1.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE1.getImage()));
                                    
                                    movingObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "movingObstacle1X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "movingObstacle1Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level6.txt", "movingObstacle1Radius")));
                                    movingObstacle1.setFill(new ImagePattern(Resources.GeneralImages.ALIEN.getImage()));
            
                                    this.getChildren().addAll(spaceship,planet1,planet2,planet3,planet4,milkyWay,fixObstacle1,movingObstacle1);
        
        
        }else if(levelNumber == 7){
                                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
                                    spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                                    
                                    milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "milkyWayRadius")));
                                    milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                                    
                                    planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet1Radius")));
                                    planet1.setFill(new ImagePattern(Resources.GeneralImages.MERCURIO.getImage()));
                                    
                                    planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet2X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet2Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet2Radius")));
                                    planet2.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                                    
                                    planet3 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet3X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet3Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet3Radius")));
                                    planet3.setFill(new ImagePattern(Resources.GeneralImages.MARTE.getImage()));
                                    
                                    planet4 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet4X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet4Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "planet4Radius")));
                                    planet4.setFill(new ImagePattern(Resources.GeneralImages.NETTUNO.getImage()));
                                    
                                    movingObstacle2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "movingObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "movingObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level7.txt", "movingObstacle2Radius")));   
                                    movingObstacle2.setFill(new ImagePattern(Resources.GeneralImages.ALIEN2.getImage()));
                                    
                                    this.getChildren().addAll(spaceship,planet1,planet2,planet3,planet4,milkyWay,movingObstacle2);
                                    
                                    
        
        }else if(levelNumber == 8){
                                    spaceship = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "SpaceshipX")),
                                             Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "SpaceshipY")),
                                             45);//x, y , raggio   
                                    spaceship.setFill(new ImagePattern(Resources.GeneralImages.SPACESHIP.getImage()));
                                    
                                    milkyWay = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "milkyWayX")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "milkyWayY")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "milkyWayRadius")));
                                    milkyWay.setFill(new ImagePattern(Resources.GeneralImages.MILKYWAY.getImage()));
                                    
                                    planet1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet1Radius")));
                                    planet1.setFill(new ImagePattern(Resources.GeneralImages.MERCURIO.getImage()));
                                    
                                    planet2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet2X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet2Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet2Radius")));
                                    planet2.setFill(new ImagePattern(Resources.GeneralImages.GIOVE.getImage()));
                                    
                                    planet3 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet3X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet3Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet3Radius")));
                                    planet3.setFill(new ImagePattern(Resources.GeneralImages.TERRA.getImage()));
                                    
                                    planet4 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet4X")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet4Y")),
                                               Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "planet4Radius")));
                                    planet4.setFill(new ImagePattern(Resources.GeneralImages.NETTUNO.getImage()));
                                    
                                    fixObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "fixObstacle1X")),
                                                    Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "fixObstacle1Y")),
                                                    Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "fixObstacle1Radius")));
                                    fixObstacle1.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE1.getImage()));

                                    fixObstacle2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "fixObstacle2X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "fixObstacle2Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "fixObstacle2Radius")));
                                    fixObstacle2.setFill(new ImagePattern(Resources.GeneralImages.OBSTACLE2.getImage()));
                                    
                                    movingObstacle1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "movingObstacle1X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "movingObstacle1Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "movingObstacle1Radius")));
                                    movingObstacle1.setFill(new ImagePattern(Resources.GeneralImages.ALIEN.getImage()));
                                    
                                    movingObstacle2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "movingObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "movingObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level8.txt", "movingObstacle2Radius")));   
                                    movingObstacle2.setFill(new ImagePattern(Resources.GeneralImages.ALIEN2.getImage()));
                                    
                                    this.getChildren().addAll(spaceship,planet1,planet2,planet3,planet4,milkyWay,fixObstacle1,fixObstacle2,movingObstacle2,movingObstacle1);
        
        }
                      
    }//end setScenario
    
    public Circle getSpaceship(){
        return this.spaceship;
    }
    
    public Circle getMO1(){
        return this.movingObstacle1;
    }
    
    public Circle getMO2(){
        return this.movingObstacle2;
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
