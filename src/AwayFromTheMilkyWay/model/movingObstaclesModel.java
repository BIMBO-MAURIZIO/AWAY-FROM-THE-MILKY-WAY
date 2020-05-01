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
public class movingObstaclesModel {
    
    
    
        
    private Circle mo1;
    private Circle mo2;
    private Circle[] a = new Circle[2];
    
    public movingObstaclesModel(){
        
    }
        //dovrei creare questi oggetti prendendo i dari dalla view
    
    public Circle[] scanning(int level) throws IOException{
        if(level == 1){
                        
                        a[0] = null;
                        a[1] = null;
                        return a;
        }else if(level == 2){
        
                        a[0]=null;
                        a[1]= null;
                        return a;
        }else if(level == 3){
                        mo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level3.txt", "movingObstacle1X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level3.txt", "movingObstacle1Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level3.txt", "movingObstacle1Radius")));
                      
        
                        a[0]=mo1;
                        a[1]= null;
                        return a;
        }else if(level == 4){
        
                        a[0]=null;
                        a[1]= null;
                        return a;
                        
        }else if(level == 5){
                        mo2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "movingObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "movingObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "movingObstacle2Radius")));
        
                        a[0]=null;
                        a[1]= mo2;
                        return a;
        }else if(level == 6){
                        mo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level6.txt", "movingObstacle1X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level6.txt", "movingObstacle1Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level6.txt", "movingObstacle1Radius")));
                      
        
                        a[0]=mo1;
                        a[1]= null;
                        return a;
        }else if(level == 7){
                        mo2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level7.txt", "movingObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level7.txt", "movingObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level7.txt", "movingObstacle2Radius")));
                      
        
                        a[0]= null;
                        a[1]= mo2;
                        return a;
        }else if(level == 8){
                        mo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "movingObstacle1X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "movingObstacle1Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "movingObstacle1Radius")));
                        mo2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "movingObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "movingObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "movingObstacle2Radius")));
                      
        
                        a[0]= mo1;
                        a[1]= mo2;
                        return a;
        }
        return a;
        
    }
}
