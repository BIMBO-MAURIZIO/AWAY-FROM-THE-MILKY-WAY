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
    
    public Circle[] scanPlanets(int level) throws IOException;
    public Circle[] scanFixObstacles(int level) throws IOException;
    public Circle[] scanMovingObstacles(int level) throws IOException;
    
    public String getName();
    public Circle getOstacoloMobile1();
    public Circle getOstacoloMobile2();
    public int getRimbalziEffettuati();
    public Circle getSpaceship();
    public int getCurrentLevel();
    public Circle getMilkyWay();
    public int getRimbDesiderati();
    
    public void increaseLevel();
    public void decreaseLevel();
    public void setLevel(int n);
    public void setRimbDesiderati(int i);
    public void setRimbEffettuati(int i);
    public void setName(String s);
    public void incrementaRimbalziEffettuati();
    
}//end class
