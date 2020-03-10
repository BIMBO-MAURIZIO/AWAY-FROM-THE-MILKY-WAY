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
    public void move();
    public void startMovimento(Scene scenaAttiva, boolean accensione);
}
