/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.controller;

import AwayFromTheMilkyWay.model.Model;
import AwayFromTheMilkyWay.utils.Resources;
import AwayFromTheMilkyWay.view.View;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author giorg
 */
public class ControllerForView implements IControllerForView {
    private static ControllerForView instance;
    private double startSpaceshipX,startSpaceshipY,mousePositionX,mousePositionY,angolo;
    private Circle spaceship,milkyWay,pl1,pl2,pl3,pl4,varCir,fOb1,fOb2,mOb1;
    private EventHandler<MouseEvent> handler,handler2,handler3,handler4;
    private Point2D NrotatedNormal;
    private Circle[] a,b;
    
    Line line;
    
    
    
     //private GameWindow gameWindow;
     //private GamePane gamePane ;
    
    
    
    
    //variabili per il movimento
    private double t = 0;
    private double x,y,magnitude,xstab,ystab,variableSpaceshipX,variableSpaceshipY;
    private Point2D shipSpeed;
    private Timeline timeline,timelineObs;
    private boolean sound;
    //AnimationTimer a;
    
    
    
    
    
    
    
    //costanti
    
    private final int WINLENGTH = 1280;
    private final int WINHEIGHT = 717;//sottraiamo 3 da 720 perhè il rendering non riesce a seguire la logica
    private final int SPACESHIPRADIUS = 45;
    
    public ControllerForView(){
        
    }
      
           
    public static IControllerForView getInstance() {
        if(instance == null)
            instance = new ControllerForView();
        return instance;
    }
    
    
    @Override
    public void setName (String nome){
        View.getInstance().getDataPane().setName(nome);
    
    }
    
    
    //questi metodi vanno messi nel controllerForModel!!!!!
    @Override
    public double getSpaceshipCenterX(){
        return Model.getInstance().getSpaceship().getCenterX();
    }
    
    @Override
    public double getSpaceshipCenterY(){
        return Model.getInstance().getSpaceship().getCenterY();
    }
    
    
    @Override
    public double getMWCenterX(){
        return Model.getInstance().getMilkyWay().getCenterX();
    }
    
    @Override
    public double getMWCenterY(){
        return Model.getInstance().getMilkyWay().getCenterY();
    }
    
    @Override
    public double getMWRadius(){
        return Model.getInstance().getMilkyWay().getRadius();
    }
    
    @Override
    public int getCurrentLevel(){
        return Model.getInstance().getCurrentLevel();
    }
    
    
    @Override
    public void setCurrentLevel(int level){
        Model.getInstance().setLevel(level);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //METODI PER IL MOVIMENTO
    @Override
    public void movimento(double v){
        
        ConfigurationPlanets();//visualizza quanti e quali pianeti stanno nella scena dipendentemente dal livello
        ConfigurationFixObstacles();
        View.getInstance().getGamePane().getChildren().remove(line);
        View.getInstance().getGamePane().removeEventHandler(MouseEvent.MOUSE_PRESSED, handler4);
        sound = true;
        ControllerForModel.getInstance().setName();
        Model.getInstance().setRimbDesiderati(View.getInstance().getRimbDes());
        System.out.println("velocità2 :"+v);
        //spaceship = View.getInstance().getSpaceship();
        milkyWay = View.getInstance().getMilkyWay();
        System.out.println(spaceship.getCenterX());
        System.out.println(spaceship.getCenterY());
        
        ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX());
        ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY());
        
        startSpaceshipX = spaceship.getCenterX();
        startSpaceshipY = spaceship.getCenterY();
        
        
        x = mousePositionX-startSpaceshipX;
        y = mousePositionY-startSpaceshipY;
        magnitude = Math.sqrt(x*x+ y*y);
        xstab = x / magnitude;
        ystab = y / magnitude;
        t = 1.00;

        
        timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> move(xstab,ystab,v))
                
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
     
    @Override
    public void move(double vx, double vy, double v){
        
        
        variableSpaceshipX = Model.getInstance().getSpaceship().getCenterX();
        variableSpaceshipY = Model.getInstance().getSpaceship().getCenterY();
        
        if (variableSpaceshipX + SPACESHIPRADIUS < WINLENGTH && variableSpaceshipY + SPACESHIPRADIUS < WINHEIGHT
            && variableSpaceshipX - SPACESHIPRADIUS > 2 && variableSpaceshipY - SPACESHIPRADIUS > 2 ){//condizioni per mantenere la navicella dentro ai bordi
            double dx,dy,distNum;

            if(pl1 != null && Math.sqrt((variableSpaceshipX - pl1.getCenterX())*(variableSpaceshipX - pl1.getCenterX())+(variableSpaceshipY - pl1.getCenterY())*(variableSpaceshipY - pl1.getCenterY()))<= SPACESHIPRADIUS+pl1.getRadius() ){
                Resources.SoundEffects.PLANETHIT.play();
                varCir = pl1;
                double dx1 = variableSpaceshipX - pl1.getCenterX();
                double dy1 =  variableSpaceshipY - pl1.getCenterY();
                double distNum1 = Math.sqrt(dx1*dx1+ dy1*dy1);
                dx = dx1;
                dy = dy1;
                distNum = distNum1;
                timeline.stop();
                bounce(dx,dy,distNum,v);
                startSpaceshipX = Model.getInstance().getSpaceship().getCenterX();
                startSpaceshipY = Model.getInstance().getSpaceship().getCenterY();

            }else if (pl2 != null && Math.sqrt((variableSpaceshipX - pl2.getCenterX())*(variableSpaceshipX - pl2.getCenterX())+(variableSpaceshipY - pl2.getCenterY())*(variableSpaceshipY - pl2.getCenterY()))<= SPACESHIPRADIUS+pl2.getRadius() ){
                Resources.SoundEffects.PLANETHIT.play();
                varCir = pl2;
                double dx2 = variableSpaceshipX - pl2.getCenterX();
                double dy2 =  variableSpaceshipY - pl2.getCenterY();
                double distNum2 = Math.sqrt(dx2*dx2+ dy2*dy2);
                dx = dx2;
                dy = dy2;
                distNum = distNum2;
                timeline.stop();
                bounce(dx,dy,distNum,v);
                startSpaceshipX = Model.getInstance().getSpaceship().getCenterX();
                startSpaceshipY = Model.getInstance().getSpaceship().getCenterY();
            
            }else if(pl3 != null && Math.sqrt((variableSpaceshipX - pl3.getCenterX())*(variableSpaceshipX - pl3.getCenterX())+(variableSpaceshipY - pl3.getCenterY())*(variableSpaceshipY - pl3.getCenterY()))<= SPACESHIPRADIUS+pl3.getRadius() ){
                Resources.SoundEffects.PLANETHIT.play();
                varCir = pl3;
                double dx3 = variableSpaceshipX - pl3.getCenterX();
                double dy3 =  variableSpaceshipY - pl3.getCenterY();
                double distNum3 = Math.sqrt(dx3*dx3+ dy3*dy3);
                dx = dx3;
                dy = dy3;
                distNum = distNum3;
                timeline.stop();
                bounce(dx,dy,distNum,v);
                startSpaceshipX = Model.getInstance().getSpaceship().getCenterX();
                startSpaceshipY = Model.getInstance().getSpaceship().getCenterY();
            
            }else if(pl4 != null && Math.sqrt((variableSpaceshipX - pl4.getCenterX())*(variableSpaceshipX - pl4.getCenterX())+(variableSpaceshipY - pl4.getCenterY())*(variableSpaceshipY - pl4.getCenterY()))<= SPACESHIPRADIUS+pl4.getRadius() ){ 
                Resources.SoundEffects.PLANETHIT.play();
                varCir = pl4;
                double dx4 = variableSpaceshipX - pl4.getCenterX();
                double dy4 =  variableSpaceshipY - pl4.getCenterY();
                double distNum4 = Math.sqrt(dx4*dx4+ dy4*dy4);
                dx = dx4;
                dy =  dy4;
                distNum = distNum4;
                timeline.stop();
                bounce(dx,dy,distNum,v);
                startSpaceshipX = Model.getInstance().getSpaceship().getCenterX();
                startSpaceshipY = Model.getInstance().getSpaceship().getCenterY();
            }else if((fOb1 != null && Math.sqrt(Math.pow(variableSpaceshipX - fOb1.getCenterX(), 2) + Math.pow(variableSpaceshipY - fOb1.getCenterY(), 2)) < SPACESHIPRADIUS+fOb1.getRadius()) ||
                     (fOb2 != null && Math.sqrt(Math.pow(variableSpaceshipX - fOb2.getCenterX(), 2) + Math.pow(variableSpaceshipY - fOb2.getCenterY(), 2)) < SPACESHIPRADIUS+fOb2.getRadius())){
                timeline.stop();
                View.getInstance().explosion();
                
                
            }else if(Math.sqrt((variableSpaceshipX - milkyWay.getCenterX())*(variableSpaceshipX - milkyWay.getCenterX())+(variableSpaceshipY - milkyWay.getCenterY())*(variableSpaceshipY - milkyWay.getCenterY())) < milkyWay.getRadius()){ //caso di vittoria del gioco   
                  //la condizione nell'if impne che appena la distanza fra i due cerchi è minore del raggio della via lattea il giocatore ha vinto
                
                double differenceX = milkyWay.getCenterX()-variableSpaceshipX;
                double differenceY = milkyWay.getCenterY()-variableSpaceshipY;
                double diagonal = Math.sqrt((differenceX+differenceX)+(differenceY*differenceY));
                double NdifferenceX = differenceX/diagonal;
                double NdifferenceY = differenceY/diagonal;
                
                if((Math.abs(milkyWay.getCenterX() - variableSpaceshipX) > 1) && (Math.abs(milkyWay.getCenterY() - variableSpaceshipY) > 1)){//fino a quando l'astronave non si è allineata con il centro della milkyway
                    if(sound){
                        //Resources.SoundEffects.BACKWASH.play();
                    }
                    sound = false;
                    spaceship.setTranslateX(NdifferenceX);
                    spaceship.setTranslateY(NdifferenceY);
                
                    ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+NdifferenceX);
                    ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+NdifferenceY);
                    spaceship.setCenterX(Model.getInstance().getSpaceship().getCenterX());
                    spaceship.setCenterY(Model.getInstance().getSpaceship().getCenterY());    
                }else{
                    timeline.stop();
                    if(Model.getInstance().getRimbDesiderati() == Model.getInstance().getRimbalziEffettuati())
                        View.getInstance().backwashWin();  
                    else
                        View.getInstance().backwashLose();
                }
            }else{//caso in cui non ci sono collisioni
                
                shipSpeed = new Point2D(vx * v,vy * v);
             
                double trX = shipSpeed.getX()*t;
                double trY = shipSpeed.getY()*t;
                
                spaceship.setTranslateX(trX);
                spaceship.setTranslateY(trY);
                
                ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+trX);
                ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+trY);
                spaceship.setCenterX(Model.getInstance().getSpaceship().getCenterX());
                spaceship.setCenterY(Model.getInstance().getSpaceship().getCenterY());
                
                if (t > 0.1)//se t avesse dovuto raggiungere 0 la decellerazione sarebbe stata troppo lenta
                    t = t-0.001;
                else{
                    timeline.stop();
                    Resources.Music.SOUNDTRACK.stop();
                    View.getInstance().createAlert("restartLevel.fxml");
                    Resources.SoundEffects.DEFEAT.play();
                }
            }
        
        }else { 
            System.out.println("centri astronave : "+spaceship.getCenterX()+" "+spaceship.getCenterY() );
            timeline.stop();
            View.getInstance().explosion();
            
        }
  
    }
    
    
    
    
    @Override 
    public void bounce(double dx,double dy,double distNum,double v){
        //a.stop();
        //timeline.stop();
        Model.getInstance().incrementaRimbalziEffettuati();
        System.out.println(Model.getInstance().getRimbalziEffettuati());
        System.out.println("coordinate astronave : " + spaceship.getCenterX()+" ; "+spaceship.getCenterY());
        View.getInstance().getGameWindow().getPDP().setRimbalziEff(Model.getInstance().getRimbalziEffettuati());
        
        double dxNorm = -dx / distNum;
        double dyNorm = -dy / distNum;//direzioni della retta che unisce i due centri
        Point2D normal = new Point2D(dxNorm,dyNorm);
                
                /*procedimento applicato per il rimbalzo:
                si considerano due versori che indicano ciò che è descritto accanto a loro nella loro definizione(guarda sotto)
                si fa ruotare il vettore 2 normalizzato attorno all 'origine di un angolo -B, e se questo vettore diventa congruente con il vettore 1 normalizzato allora
                siaamo riusciti a capire che la pallina è  stata lanciata verso sinistra e quindi l' angolo A che rappresenza l'angolo di incidenza assume in modulo
                lo stessp valore di prima ,ma cambia in segno.
                */
        Point2D center = new Point2D(spaceship.getCenterX(),spaceship.getCenterY());
        Point2D vect1 = new Point2D(center.getX() - startSpaceshipX, center.getY() - startSpaceshipY);
        Point2D Nvect1 = vect1.normalize();/*unisce il centro dell'astro quando va a sbattere al centro iniziale*/
        Point2D vect2 = new Point2D(varCir.getCenterX() - startSpaceshipX, varCir.getCenterY() - startSpaceshipY);
        Point2D Nvect2 = vect2.normalize();/*unisce il piantea e l'astronave nella sua posizione iniziale*/
        System.out.println("vettore 1 :"+Nvect1.toString());
        //System.out.println("vettore 2 :"+vect2.toString());
        double A = normal.angle(shipSpeed);
        double B = vect1.angle(vect2);
        
        Point2D s = new Rotate(-B,0,0).transform(Nvect2.getX(), Nvect2.getY());
        angolo = angolo + (180 -2*Math.abs(A));

        if (truncate(s.getX()) == truncate(Nvect1.getX()) && truncate(s.getY()) == truncate(Nvect1.getY())){
            A=-A;
            angolo = angolo - 2*(180 -2*Math.abs(A)); //il 2 sta per togliere il(180 -2 ec.) che avevamo sommato sopra
        }    
               
        //commento        
        System.out.println("angolo A : "+ A);
        Point2D rN = new Rotate(-2*A,spaceship.getCenterX(),spaceship.getCenterY()).transform(startSpaceshipX, startSpaceshipY);
        
       
        System.out.println("angolo C : "+ angolo);
        View.getInstance().getSpaceship().setRotate(angolo);//secondo me il prob è che la rotazione viene fatta sempre considerando la navicella dritta
        double diffX = rN.getX()- spaceship.getCenterX();
        double diffY = rN.getY()- spaceship.getCenterY();
        double rad = Math.sqrt((diffX*diffX)+(diffY*diffY));
        NrotatedNormal = new Point2D(diffX/rad, diffY/rad);
        System.out.println("NrotatedNormal : "+NrotatedNormal.toString());
        KeyFrame kf = new KeyFrame(Duration.seconds(0.025), x -> move(NrotatedNormal.getX(),NrotatedNormal.getY(),v));
        
        for(int i=0;i<10;i++){//avvia la traslazione
            spaceship.setTranslateX(NrotatedNormal.getX()*t);
            spaceship.setTranslateY(NrotatedNormal.getY()*t);
            if (t > 0.1)
                    t = t-0.0009;
            else
                    timeline.stop();    
            ControllerForModel.getInstance().setSpaceshipCenterX(spaceship.getCenterX()+(NrotatedNormal.getX()*t));
            ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+(NrotatedNormal.getY()*t));
            spaceship.setCenterX(Model.getInstance().getSpaceship().getCenterX());
            spaceship.setCenterY(Model.getInstance().getSpaceship().getCenterY());
       
        }
        System.out.println("coordinate astronave dopo il for : " + spaceship.getCenterX()+" ; "+spaceship.getCenterY());
        
        timeline.getKeyFrames().set(0,kf);      

        timeline.play();
                
        /*a = new AnimationTimer(){
            @Override
            public void handle(long now){
                 move(NrotatedNormal.getX(),NrotatedNormal.getY(),1);
            }
        };
        a.start();
        */
    }
    
   
   
    @Override
    public void setDirection() {
    
        System.out.println(View.getInstance().getNome()+"  DDDDDD");
        handler = new EventHandler<MouseEvent>() {  //handler che traccia la freccia ddirezionale
            public void handle(MouseEvent event) { 
                if(!View.getInstance().getGamePane().getChildren().isEmpty())//controlla prima se la linea c'è
                    View.getInstance().getGamePane().getChildren().remove(line);
                double varMousePositionX = event.getX();
                double varMousePositionY = event.getY();
                spaceship = View.getInstance().getSpaceship();
                angolo = Math.toDegrees(Math.atan2(varMousePositionY-spaceship.getCenterY(),varMousePositionX-spaceship.getCenterX()));
                View.getInstance().getSpaceship().setRotate(angolo);
                if(varMousePositionX<=1280 && varMousePositionY<= 718){
                    line = new Line(View.getInstance().getSpaceship().getCenterX(),View.getInstance().getSpaceship().getCenterY(),varMousePositionX,varMousePositionY);
                    View.getInstance().getGamePane().getChildren().add(line);
                }
                System.out.println(" angolo "+angolo);
            }
        };
        
        View.getInstance().getGamePane().addEventHandler(MouseEvent.MOUSE_MOVED, handler);
        
        
        handler2 = new EventHandler<MouseEvent>() {  //handler che traccia la freccia ddirezionale
            public void handle(MouseEvent event) { 
                View.getInstance().getGamePane().getChildren().remove(line);

            }
        };
        
        View.getInstance().getGamePane().addEventHandler(MouseEvent.MOUSE_EXITED, handler2);
       
        
        handler3 = new EventHandler<MouseEvent>() {  
            public void handle(MouseEvent event) {  
                mousePositionX = event.getX();
                mousePositionY = event.getY();
                View.getInstance().getDataPane().startPB();
                setPower();
            }
        };
       
        View.getInstance().getGamePane().addEventHandler(MouseEvent.MOUSE_PRESSED, handler3);    
    }
    
    
    @Override
    public void setPower(){
        View.getInstance().getGamePane().removeEventHandler(MouseEvent.MOUSE_PRESSED, handler3);
        View.getInstance().getGamePane().removeEventHandler(MouseEvent.MOUSE_EXITED, handler2);
        View.getInstance().getGamePane().removeEventHandler(MouseEvent.MOUSE_MOVED, handler);

        
        handler4 = new EventHandler<MouseEvent>() {  
            public void handle(MouseEvent event) {
                View.getInstance().getDataPane().stopPB();
                System.out.println("velocità :"+ View.getInstance().getDataPane().getProgressPB());
                movimento((View.getInstance().getDataPane().getProgressPB()*3/1)+2);
            }
        };
       
       
        View.getInstance().getGamePane().addEventHandler(MouseEvent.MOUSE_PRESSED, handler4);    
    }
    
    
    @Override
    public void pauseAnimations(){
        if(this.timeline != null)
            this.timeline.pause();
        //this.a.stop();
    }
    
    @Override
    public void playAnimations(){
        if(this.timeline != null)
            this.timeline.play();
    //this.a.start();
    }
     
        
    @Override
    public double truncate(double a){
        double b = a*10000000;
        double c = Math.floor(b);
        double d = c/10000000;
        return d;
    }
    //aaa
    @Override
    public void ConfigurationPlanets(){//cominica al controller quanti e quali pineti ci sono nel livello
        a = new Circle[4];
        int cl = Model.getInstance().getCurrentLevel();
        try {
            a[0] = Model.getInstance().scanPlanets(cl)[0];
            a[1] = Model.getInstance().scanPlanets(cl)[1];
            a[2] = Model.getInstance().scanPlanets(cl)[2];
            a[3] = Model.getInstance().scanPlanets(cl)[3];
        } catch (IOException ex) {
            Logger.getLogger(ControllerForView.class.getName()).log(Level.SEVERE, null, ex);
        }
       pl1 = a[0];
       pl2 = a[1];
       pl3 = a[2];
       pl4 =a[3];
        
    }
    
    @Override
    public void ConfigurationFixObstacles(){//cominica al controller quanti e quali ostacoli ci sono nel livello
        b = new Circle[2];
        int cl = Model.getInstance().getCurrentLevel();
        try {
            b[0] = Model.getInstance().scanFixObstacles(cl)[0];
            b[1] = Model.getInstance().scanFixObstacles(cl)[1];
            
        } catch (IOException ex) {
            Logger.getLogger(ControllerForView.class.getName()).log(Level.SEVERE, null, ex);
        }
       fOb1 = b[0];
       fOb2 = b[1];
      
    }
    

    @Override    
    public void restartLevel(){
        Model.getInstance().setRimbEffettuati(0);
        View.getInstance().openGameWindow(Model.getInstance().getCurrentLevel());
        View.getInstance().getDataPane().setName(Model.getInstance().getName());
        Resources.Music.SOUNDTRACK.play();
    }    
    
    @Override    
    public void nextLevel(int livelloCorrente){
        if(livelloCorrente != 8){
            Model.getInstance().setRimbEffettuati(0);
            View.getInstance().openGameWindow(livelloCorrente+1);
            View.getInstance().getDataPane().setName(Model.getInstance().getName());
            Resources.Music.SOUNDTRACK.play();
            Model.getInstance().increaseLevel();
            
        }else{
            //TO-DO
        }
    } 
    
    @Override
    public void moveObstacles(){
        if(mOb1 != null){
             timelineObs = new Timeline(new KeyFrame(
                Duration.seconds(0.025), // ogni quanto va chiamata la funzione
                x -> moveObsVer())
                
            );
            timelineObs.setCycleCount(Timeline.INDEFINITE);
            timelineObs.play();
        }
    }
    
    @Override
    public void moveObsVer(){
        double orientation = 1;
        if(mOb1.getCenterY() < 100 || mOb1.getCenterY() > 620)
            orientation = -orientation;
        double trY = orientation * 0.5;
        mOb1.setTranslateY(trY);
       
        ControllerForModel.getInstance().setSpaceshipCenterY(spaceship.getCenterY()+trY);
                
        mOb1.setCenterY(Model.getInstance().getSpaceship().getCenterY());
    }
        
        
        
}//end class sss
