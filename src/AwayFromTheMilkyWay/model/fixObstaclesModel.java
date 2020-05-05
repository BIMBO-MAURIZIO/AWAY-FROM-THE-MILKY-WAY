
package AwayFromTheMilkyWay.model;

import AwayFromTheMilkyWay.utils.Utils;
import java.io.IOException;
import javafx.scene.shape.Circle;


public class fixObstaclesModel {
    private Circle fo1;
    private Circle fo2;
    private Circle[] a = new Circle[2];
    
    public fixObstaclesModel(){}
    
    
    public Circle[] scanning(int level) throws IOException{
        if(level == 1){

                        a[0] = null;
                        a[1] = null;
                       
                        return a;
                      
        }else if(level == 2){
            
                        fo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level2.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level2.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level2.txt", "fixObstacle1Radius")));              
                        a[0] = fo1;
                        a[1] = null;
                       
                        return a;
                        
       }else if(level == 3){     
           
                        fo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level3.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level3.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level3.txt", "fixObstacle1Radius")));
                        a[0] = fo1;
                        a[1] = null;
                       
                        return a;
       }else if(level == 4){  
           
                        fo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level4.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level4.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level4.txt", "fixObstacle1Radius")));
                        fo2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level4.txt", "fixObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level4.txt", "fixObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level4.txt", "fixObstacle2Radius")));
                        a[0] = fo1;
                        a[1] = fo2;
                       
                        return a;
                        
       }else if(level == 5){  
           
                        fo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "fixObstacle1Radius")));
                        fo2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "fixObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "fixObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level5.txt", "fixObstacle2Radius")));
                        a[0] = fo1;
                        a[1] = fo2;
                       
                        return a;
                        
       }else if(level == 6){ 
           
                        fo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level6.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level6.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level6.txt", "fixObstacle1Radius")));
                        a[0] = fo1;
                        a[1] = null;
                       
                        return a;            
            
       }else if(level == 7){           
                        
                        a[0] = null;
                        a[1] = null;
                       
                        return a;            
            
       }else if(level == 8){    
           
                        fo1 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "fixObstacle1X")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "fixObstacle1Y")),
                                                Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "fixObstacle1Radius")));
                        fo2 = new Circle(Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "fixObstacle2X")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "fixObstacle2Y")),
                                            Double.parseDouble(Utils.getInstance().searchWord("txtFiles/Level8.txt", "fixObstacle2Radius")));
                        a[0] = fo1;
                        a[1] = fo2;
                       
                        return a;
                        
       }  
       return a;
    }
    
}

