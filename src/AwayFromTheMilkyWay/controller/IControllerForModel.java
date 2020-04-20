/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

/**
 *
 * @author giorg
 */
public interface IControllerForModel {
    
   public void setSpaceshipCenterX (double x);
   public void setSpaceshipCenterY (double y);
   public double getSpaceshipCenterX ();
   public double getSpaceshipCenterY ();
   public double getMWCenterX();
   public double getMWCenterY();
   public double getMWRadius();
   public void setName();
   
   
}
