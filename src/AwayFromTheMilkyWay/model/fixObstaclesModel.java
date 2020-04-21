/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.model;

import AwayFromTheMilkyWay.utils.Utils;
import java.io.IOException;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public class fixObstaclesModel {
    private Circle fo1;
    private Circle fo2;
    Circle[] a = new Circle[2];
    
    public fixObstaclesModel(){}
    
    public Circle[] scanning(int level) throws IOException{
        if(level == 1){
                        fo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "fixObstacle1X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "fixObstacle1Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "fixObstacle1Radius")));
                      
                      
                
                
                        a[0] = fo1;
                        a[1] = null;
                        return a;
                      
        }else if(level == 2){           
                        fo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle1Radius")));
                      
                        fo2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "fixObstacle2Radius")));
                
                
                        a[0] = fo1;
                        a[1] = fo2;
                        return a;
       }   
            
        
       return a;
    }
    
}

