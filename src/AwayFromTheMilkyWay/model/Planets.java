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
public class Planets {
    private Circle pl1;
    private Circle pl2;
    private Circle pl3;
    private Circle pl4;
    Circle[] a = new Circle[4];
    
    public Planets(){}
    
    public Circle[] scanning(int level) throws IOException{
        switch(level){
            
            case 1 :  pl1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "planet1X")),
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
            case 2 :
                
            case 3 :
        
            case 4 :
        
            case 5 :
        
            case 6 :        
        
            case 7 :    
        
            case 8 :    
        }
        return a;
    }
    
}
