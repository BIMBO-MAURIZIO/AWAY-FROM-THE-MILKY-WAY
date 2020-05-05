
package AwayFromTheMilkyWay.view;


import java.io.IOException;
import javafx.scene.layout.BorderPane;


public class GameWindow extends BorderPane {
    
    private PlayerDataPane schermataDati = new PlayerDataPane();
    private GamePane schermataGioco = new GamePane();
    
    public GameWindow(){
        super();
    }
    
    
    public void composeWindow(int level) throws IOException{
        schermataGioco = new GamePane();
        schermataGioco.setScenario(level);
        schermataGioco.setMaxSize(1280, 720);
        schermataGioco.setMinSize(1280, 720);
        schermataGioco.setPrefSize(1280, 720);
       
        
        schermataDati.setPrefSize(1280, 180);
        schermataDati.setMaxSize(1280, 180);
        schermataDati.setMinSize(1280, 180);
        schermataDati.populatePane();
        schermataDati.fillGrid();
        schermataDati.adaptToLevel(level);
   
        this.setCenter(schermataGioco);
        this.setBottom(schermataDati);
       
    }
    
   
   public GamePane getSchermataGioco(){
       return this.schermataGioco;
   }
    
   
   public PlayerDataPane getPDP(){
       return this.schermataDati;
   }
   
   
}
