/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.utils.Utils;
import AwayFromTheMilkyWay.view.GamePane;
import AwayFromTheMilkyWay.view.GameWindow;
import AwayFromTheMilkyWay.view.View;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author giorg
 */
public class ControllerForView implements IControllerForView {
    private static ControllerForView instance;
    double positioningX;
    double positioningY;
    private double spaceshipX;
    private double spaceshipY;
    private double startSpaceshipX;
    private double startSpaceshipY;
    private double mousePositionX;
    private double mousePositionY;
    Circle spaceship;
    EventHandler<MouseEvent> handler;
    
    
    
     GameWindow gameWindow = View.getInstance().getGameWindow();
     GamePane gamePane = gameWindow.getSchermataGioco();
     Circle cir = gamePane.getPlanet1();
    
    
    
    
    //variabili per il movimento
    int t = 0;
    double x;
    double y;
    double magnitude;
    double xstab;
    double ystab;
    double variableSpaceshipX;
    double variableSpaceshipY;
    Timeline timeline;
    Timeline timeline2;
    
    
    //costanti
    
    private final int WINLENGTH = 1280;
    private final int WINHEIGHT = 720;
    private final int SPACESHIPRADIUS = 50;
    
    public ControllerForView(){
        
    }
      
           
    public static IControllerForView getInstance() {
        if(instance == null)
            instance = new ControllerForView();
        return instance;
    }
    
    
    @Override
    public void setName (String nome){
        GameWindow schermataGioco ;
        schermataGioco = View.getInstance().getGameWindow();
        schermataGioco.setName(nome);
    
    }
    
    
    @Override
    public double getSpaceshipCenterX(){
        GamePane gp = View.getInstance().getGameWindow().getSchermataGioco();
        return gp.getSpaceship().getCenterX();
    }
    
    @Override
    public double getSpaceshipCenterY(){
        GamePane gp = View.getInstance().getGameWindow().getSchermataGioco();
        return gp.getSpaceship().getCenterY();
    }
    
    
    //commento inutile
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //METODI PER IL MOVIMENTO
    @Override
    public void movimento(){
        
        GameWindow gameWindow = View.getInstance().getGameWindow();
        GamePane gamePane = gameWindow.getSchermataGioco();
        gamePane.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        
        spaceship = gamePane.getSpaceship();
        startSpaceshipX = spaceship.getCenterX();
        startSpaceshipY = spaceship.getCenterY();
        
        
        x = mousePositionX-startSpaceshipX;
        y = mousePositionY-startSpaceshipY;
        magnitude = Math.sqrt(x*x+ y*y);
        xstab = x / magnitude;
        ystab = y / magnitude;
        
        

     
        timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move(1))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
     
    @Override
    public void move(double v){
        variableSpaceshipX = ControllerForModel.getInstance().getSpaceshipCenterX();
        variableSpaceshipY = ControllerForModel.getInstance().getSpaceshipCenterY();
        
        
        if (variableSpaceshipX + SPACESHIPRADIUS <= WINLENGTH && variableSpaceshipY + SPACESHIPRADIUS <= WINHEIGHT
            && variableSpaceshipX - SPACESHIPRADIUS >= 0 && variableSpaceshipY - SPACESHIPRADIUS >= 0 ){//condizioni per mantenere la navicella dentro ai bordi
            
            double dx = cir.getCenterX() - variableSpaceshipX;
            double dy = cir.getCenterY() - variableSpaceshipY;
            double distNum = Math.sqrt(dx*dx+ dy*dy);
            
            if(distNum >= SPACESHIPRADIUS+cir.getRadius() ){
                spaceshipX = xstab * t;
                spaceshipY = ystab * t;
                spaceship.setTranslateX(spaceshipX);
                spaceship.setTranslateY(spaceshipY);
                ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+spaceshipX);
                ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+spaceshipY);

                t++;
            }else{
                t=1;
                spaceship.setCenterX(ControllerForModel.getInstance().getSpaceshipCenterX());
                spaceship.setCenterY(ControllerForModel.getInstance().getSpaceshipCenterY());
                timeline.stop();
                timeline2 = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move2(dx,dy))
                );
                timeline2.setCycleCount(Timeline.INDEFINITE);
                timeline2.play();
                /*double dxNorm = dx / distNum;
                double dyNorm = dy / distNum;//direzioni della retta che unisce i due centri
                double tgx = -dyNorm;
                double tgy = dxNorm;

               
                spaceshipX = tgx * t;
                spaceshipY = tgy * t;
                spaceship.setTranslateX(spaceshipX);
                spaceship.setTranslateY(spaceshipY);
                ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+spaceshipX);
                ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+spaceshipY);
                
                t++;*/
                
                }
            
            
        
        }else { 
            timeline.stop();
            System.out.print("FUORI");
        }
  
    }
    
    
    
    @Override
    public void move2(double dx, double dy){
        System.out.println("entro");
        double distNum = Math.sqrt(dx*dx+ dy*dy);
        double dxNorm = dx / distNum;
                double dyNorm = dy / distNum;//direzioni della retta che unisce i due centri
                double tgx = dyNorm;
                double tgy = -dxNorm;

                System.out.println("centro della navicella X : "+ spaceship.getCenterX());
                spaceshipX = tgx * t;
                spaceshipY = tgy * t;
                System.out.println("spx e sp y :"+spaceshipX+" "+spaceshipY);
                spaceship.setTranslateX(spaceshipX);
                spaceship.setTranslateY(spaceshipY);
                ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+spaceshipX);
                ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+spaceshipY);
                
                t++;
    }
    
   
    
    @Override
    public void startMovimento() {
       GameWindow gameWindow = View.getInstance().getGameWindow();
       GamePane gamePane = gameWindow.getSchermataGioco();
       handler = new EventHandler<MouseEvent>() {  
            public void handle(MouseEvent event) {  
                mousePositionX = event.getX();
                mousePositionY = event.getY();
                movimento();
                
            }
        };
       
        gamePane.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);    
    }
     
}//end class sss
