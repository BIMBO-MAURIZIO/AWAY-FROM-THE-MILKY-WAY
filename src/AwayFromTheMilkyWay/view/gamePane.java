/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author giorg
 */
public class gamePane extends AnchorPane {//sarà la schermata di gioco che  dovràconvivere nella stessa scena con la playerDataPane.
    
    public void gamePane(int levelNumber){//avevo intenzione di mettere qui la dipendenza dal livello così da cambiare lo scenario in base al livello automaticamente
        int level = levelNumber;
        switch(levelNumber){
            
            case 1 ://questicasi andranno pienati con la configurazione dello scenario di gioco nei vari livelli
                    //la quale verrà letta da un file di testo esterno attraverso le classi in utils                
                
            case 2 :
                
            case 3 :
        
            case 4 :
        
            case 5 :
        
            case 6 :        
        
            case 7 :    
        
            case 8 :    
        }
        
        
    }
}
