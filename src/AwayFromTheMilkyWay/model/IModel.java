/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.model;

import java.io.IOException;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public interface IModel {
    
    public void incrementaRimbalziEffettuati();
    public int getRimbalziEffettuati();
    public Circle getSpaceship();
    public Circle[] scanPlanets(int level) throws IOException;
    public int getCurrentLevel();
    public MilkyWayModel getMilkyWay();
    public void increaseLevel();
    public void decreaseLevel();
    public void setLevel(int n);
    public void setRimbDesiderati(int i);
    public int getRimbDesiderati();
    public void setRimbEffettuati(int i);
    public void setName(String s);
    public String getName();
    
}//end class
