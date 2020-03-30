/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import javafx.scene.Scene;

/**
 *
 * @author giorg
 */
public interface IControllerForView {
    
    public void setName (String nome);
    public void movimento();
    public void move(double v);
    public void move2(/*double dx, double dy*/);
    public void startMovimento();
    public double getSpaceshipCenterX();
    public double getSpaceshipCenterY();
    public void pauseAnimations();
    public void playAnimations();
    
}
