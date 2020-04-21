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
public class PlanetsModel {
    private Circle pl1;
    private Circle pl2;
    private Circle pl3;
    private Circle pl4;
    Circle[] a = new Circle[4];
    
    public PlanetsModel(){}
    
    public Circle[] scanning(int level) throws IOException{
       if(level == 1){
                      pl1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1Radius")));
                      
                      pl2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet2Radius")));
                
                
                      a[0] = pl1;
                      a[1] = pl2;
                      a[2] = null;
                      a[3] = null;
                      return a;
                      
       }else if(level == 2){           
            pl1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet1Radius")));
                      
                      pl2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2X")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2Y")),
                                           Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "planet2Radius")));
                
                
                      a[0] = pl1;
                      a[1] = pl2;
                      a[2] = null;
                      a[3] = null;
                      return a;
       }   
            
        
       return a;
    }
    
}
