
package AwayFromTheMilkyWay.controller;


public interface IControllerForModel {
    
   public void setSpaceshipCenterX (double x);
   public void setSpaceshipCenterY (double y);
   public void setName();
   public void setObs1CenterY (double x);
   public void setObs2CenterX (double x);
   
   public double getSpaceshipCenterX ();
   public double getSpaceshipCenterY ();
   public double getMWCenterX();
   public double getMWCenterY();
   public double getMWRadius();
  
}
