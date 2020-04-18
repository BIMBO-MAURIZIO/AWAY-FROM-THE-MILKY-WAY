/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;


import AwayFromTheMilkyWay.utils.Resources;
import AwayFromTheMilkyWay.utils.Utils;
import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author giorg
 */
public class PlayerDataPane extends GridPane {
    int level, rimbalziEff,rimbalziDes,power;
    private String name;
    private ProgressBar pb;
    private Timeline t ;
    private Label nome,rimbalziEffettuati,rimbalziDesiderati,numLivello;
    private Button opzioni;

    private static final String RED_BAR    = "red-bar";
    private static final String YELLOW_BAR = "yellow-bar";
    private static final String GREEN_BAR  = "green-bar";
    private static final String[] BCS = { RED_BAR, YELLOW_BAR, GREEN_BAR };
    
  
  public PlayerDataPane(){
        super();
    }
    
    
    //metodi per popolare la PDP
    public void populatePane(){

        
        rimbalziDesiderati = new Label("Rimbalzi Desiderati: "+ rimbalziDes);
        rimbalziDesiderati.setPrefSize(427, 90);
        rimbalziDesiderati.setAlignment(Pos.CENTER);
        
        nome  = new Label("nome: " + name);
        nome.setPrefSize(427, 90);
        nome.setAlignment(Pos.CENTER);
        
        pb = new ProgressBar();
        pb.setPrefSize(200, 40);//dimensioni della barra
        pb.setMaxWidth(200);
        pb.setProgress(0);
        pb.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double progress = newValue == null ? 0 : newValue.doubleValue();
                if (progress < 0.5) {
                    setBarStyleClass(pb, GREEN_BAR);
                } else if (progress < 0.8) {
                    setBarStyleClass(pb, YELLOW_BAR);
                } else {
                    setBarStyleClass(pb, RED_BAR);
                }
            }
            private void setBarStyleClass(ProgressBar bar, String barStyleClass) {
                bar.getStyleClass().removeAll(BCS);
                bar.getStyleClass().add(barStyleClass);
            }
        });    
        
        final VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().setAll(pb);
        layout.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        rimbalziEffettuati = new Label("rimbalzi effettuati: "+ rimbalziEff);
        rimbalziEffettuati.setPrefSize(427, 90);
        rimbalziEffettuati.setAlignment(Pos.CENTER);
        
        numLivello = new Label("livello numero "+ level);
        numLivello.setPrefSize(426, 90);
        numLivello.setAlignment(Pos.CENTER);
        
        opzioni = new Button("opzioni");
        opzioni.setPrefSize(426, 90);
        opzioni.setOnAction(event -> {
            View.getInstance().pause();
        });
        
        
        
        this.add(rimbalziDesiderati,0,0);
        this.add(nome,1,0);
        this.add(layout,0,1);
        this.add(rimbalziEffettuati,1,1);
        this.add(numLivello,2,0);
        this.add(opzioni,2,1);
        //this.setGridLinesVisible(true);
        
        
      
    }
    
    
    public void fillGrid(){
        Image image = Resources.GeneralImages.GRID.getImage();
        BackgroundSize backgroundSize = new BackgroundSize(1280, 180, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        //GridPane.setHalignment(pb, HPos.CENTER);//serve a centrare la progressBar
    }
    
    
    public void adaptToLevel(int level) throws IOException{
        if(level == 1){
            setRimbDes(Integer.parseInt(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level1.txt", "rimbalziDes")));
            setLevel(level);
        }else if(level == 2){
            setRimbDes(Integer.parseInt(Utils.getInstance().searchWord("src\\AwayFromTheMilkyWay\\configuration\\txtFiles\\Level2.txt", "rimbalziDes")));
            setLevel(level);
        }
    }
    
    
    //metodi per operare sulla PDP
    public void setName(String nm){
        this.name = nm;
        update();
    }
    
    public void setRimbDes(int n){
        this.rimbalziDes = n;
        update();
    }
    
    public void setRimbalziEff(int rimb){
        this.rimbalziEff = rimb;
        update();
    }
    
    public void setLevel(int l){
        this.level = l;
        update();
    }
    
    public void setPB(double progress){
        this.pb.setProgress(progress);
    }
    
    public void startPB(){
        pb.setProgress(0);
        t = new Timeline(new KeyFrame(
                Duration.seconds(0.1), // ogni quanto va chiamata la funzione
                x -> setPB((pb.getProgress()+0.1)%1)
                
        ));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
    
    
    public void stopPB(){
        t.stop();
    }
    
    public double getProgressPB(){
        return pb.getProgress();
    }
    
    public void disableButton(){
        this.opzioni.setDisable(true);
    }
    
    
    public void enableButton(){
        this.opzioni.setDisable(false);
    }
    
    
    
    
    
    public void update(){
        nome.setText("nome: " + name);
        rimbalziDesiderati.setText("rimbalzi desiderati: "+ rimbalziDes);
        rimbalziEffettuati.setText("rimbalzi effettuati: "+ rimbalziEff);
        numLivello.setText("livello numero "+ level);
        
    }
     
   

    
}
