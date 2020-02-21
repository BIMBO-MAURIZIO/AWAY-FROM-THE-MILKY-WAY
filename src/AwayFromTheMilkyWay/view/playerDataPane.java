/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author giorg
 */
public class playerDataPane extends GridPane {
    
    public void playerDataPane(){
        this.add(new Label(),0,0);
        this.add(new Label(),1,0);
        this.add(new Label(),0,1);
        this.add(new Label(),1,1);
    }
    
}
