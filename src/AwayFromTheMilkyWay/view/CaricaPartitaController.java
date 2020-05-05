
package AwayFromTheMilkyWay.view;

import AwayFromTheMilkyWay.controller.ControllerForView;
import AwayFromTheMilkyWay.utils.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;


public class CaricaPartitaController implements Initializable {

    private @FXML ListView lv;
    private String scelta = null;
    File f ;
    @FXML private Button carica;
    @FXML private Button canc;
    @FXML private Button backc;
    @FXML private Label tit1c;
    @FXML private Label tit2c;
    @FXML private Label scegli;
    @FXML private AnchorPane ap;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ap.setBackground(new Background(new BackgroundImage(Resources.GeneralImages.BACKGROUNDF.getImage(),
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundPosition.CENTER,
                                                            BackgroundSize.DEFAULT)));
        
        backc.setGraphic(new ImageView(Resources.GeneralImages.BACK.getImage()));
        
        if(new File("gameProfiles").exists()){
        //File f = new File("gameProfiles/");
            f = new File("gameProfiles/");
            String[] allFiles = f.list();
            ObservableList<String> list = FXCollections.observableArrayList(allFiles);
            lv.setItems(list);
            lv.setCellFactory(lv -> {
                ListCell<String> cell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(item);
                        }
                    }
                };
                cell.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
                    if ((! cell.isEmpty())) {
                        String item = cell.getItem();
                        scelta = item;
                        System.out.println("Right clicked "+item);
                    }
                });
            return cell ;
            });
        }
        
        
        carica.setLayoutX(47);
        carica.setLayoutY(410);
        carica.setMinSize(223,50);
        carica.setMaxSize(223,50);
        carica.setText(carica.getText().toUpperCase());
        canc.setLayoutX(323);
        canc.setLayoutY(410);
        canc.setMinSize(223,50);
        canc.setMaxSize(223,50);
        canc.setText(canc.getText().toUpperCase());
        backc.setLayoutX(53);
        backc.setLayoutY(45);
        tit1c.setLayoutX(694);
        tit1c.setLayoutY(75);
        tit1c.setMinSize(374,112);
        tit1c.setMaxSize(374,112);
        tit1c.setText(tit1c.getText().toUpperCase());
        tit2c.setLayoutX(646);
        tit2c.setLayoutY(173);
        tit2c.setMinSize(450,106);
        tit2c.setMaxSize(450,106);
        tit2c.setText(tit2c.getText().toUpperCase());
        scegli.setLayoutX(210);
        scegli.setLayoutY(95);
        scegli.setMinSize(170,58);
        scegli.setMaxSize(170,58);
        scegli.setText(scegli.getText().toUpperCase());
        lv.setLayoutX(125);
        lv.setLayoutY(155);
        lv.setMinSize(345,227);
        lv.setMaxSize(345,227);

    }    
    
    
    public void back() throws IOException{
        View.getInstance().changeCurrentWindow("schermataIniziale.fxml");
    }
    
    
    public void buttonSound(){
        Resources.SoundEffects.BUTTONCLICK.play();
    }
    
    
    public void caricaPartita(){
        if(scelta != null)
            ControllerForView.getInstance().loadGame(scelta);
            
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Away From the Milky Way");
            alert.setContentText("per caricare un profilo devi prima sceglierlo dalla lista");
            alert.show();
        }
    }
    
    
    public void cancellaProfilo(){
        if(scelta != null){
            Boolean r = ControllerForView.getInstance().deleteLog(scelta);
            if(r){
                scelta = null;
                File f = new File("gameProfiles/");
                String[] allFiles = f.list();
                ObservableList<String> list = FXCollections.observableArrayList(allFiles);
                lv.setItems(list);
            }
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Away From the Milky Way");
            alert.setContentText("per cancellare un profilo devi prima sceglierlo dalla lista");
            alert.show();
            
        }
    }
    
}
