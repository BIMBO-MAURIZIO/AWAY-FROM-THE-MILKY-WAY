
package AwayFromTheMilkyWay.controller;

import javafx.scene.shape.Line;

public interface IControllerForView {
    
    public double getSpaceshipCenterX();
    public double getSpaceshipCenterY();
    public double getMWCenterX();
    public double getMWCenterY();
    public double getMWRadius();
    public int getCurrentLevel();
    public Line getLine();
    
    public void setName (String nome);
    public void setCurrentLevel(int level);
    
    public void movimento(double v);
    public void move(double vx,double vy,double v);
    public void bounce(double dx,double dy,double distNum,double v);
    public void setDirection();
    public void setPower();

    public void pauseAnimations();
    public void playAnimations();
    
    public void ConfigurationPlanets();
    public void ConfigurationFixObstacles();
     public void ConfigurationMovingObstacles();
    public void moveObstacles();
    public void moveObsVer();
    public void moveObsOri();
    public void restartLevel();
    public void nextLevel(int livelloCorrente);
    
    public double truncate(double a);
    public void hint(int level);
    public void saveGame();
    public void loadGame(String nome);
    public boolean deleteLog(String nome);
}
