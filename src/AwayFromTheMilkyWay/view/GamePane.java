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
        /*Image image = new Image("https://www.bing.com/images/search?view=detailV2&ccid=3y8QfgkM&id=00E329B414A7CF7C3EF1372AB68C0902A187840E&thid=OIP.3y8QfgkM4By-_ZTBD2bK9QHaE5&mediaurl=http%3a%2f%2f1.bp.blogspot.com%2f-_jVVwk2TstI%2fUa51EWn7rJI%2fAAAAAAAAC4o%2frcfnqpSUZn8%2fs1600%2fReal%252BSpace%252BPictures-729670.jpg&exph=331&expw=500&q=space&simid=608015283837994335&selectedIndex=1&ajaxhist=0");
        ImageView imageView = new ImageView();
        this.getChildren().add(imageView);*/
        this.setBackground(new Background(new BackgroundFill(RED,CornerRadii.EMPTY,Insets.EMPTY)));
        
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
