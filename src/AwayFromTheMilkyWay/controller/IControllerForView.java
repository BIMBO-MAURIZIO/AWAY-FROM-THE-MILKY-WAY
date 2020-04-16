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
public interface IControllerForView {
    
    public void setName (String nome);
    public void movimento(double v);
    public void move(double vx,double vy,double v);
    public void bounce(double dx,double dy,double distNum,double v);
    public void setDirection();
    public void setPower();
    public double getSpaceshipCenterX();
    public double getSpaceshipCenterY();
    public double getMWCenterX();
    public double getMWCenterY();
    public double getMWRadius();
    public void pauseAnimations();
    public void playAnimations();
    public double truncate(double a);
    public void Configuration();
    
}
