/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author giorg
 */
public class TextReader {
    public String readFileInfo(String filename, String searchedWord) throws FileNotFoundException, IOException{
        //con questo metodo vorrei far leggere il file fino alla riga che ci interessa, ad esempio
        //una in cui c'è scritto "POSIZIONE X dell'astronave" e fare ritornare al metodo la stringa della riga sottostante
        //che sarà effettivamente il valore che cerchiamo, da poter assegnare poi agli oggetti creati nello scenario di gioco.
        String[] words = null;//inizializzo un arrai per porre poi le parole che reggo
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufReader = new BufferedReader(fileReader);
        
        String utilsString = null;
        String wantedData;
        String line;
        
        while ((line = bufReader.readLine()) != null) {
            
            words = line.split(" ");
            for(String word : words){
                if(word.equals(searchedWord)){
                
                    utilsString = line;//salvo la linea considerata nella variabile
                    
                }
            }    
        }
        fileReader.close();
        
       words = utilsString.split(" = ");
       return words[2];// in teoria le mie scritture saranno del tipo "lunghezza-Astronave = 1000". Quindi spezzando la stringa inprossimità del carattere
       // = otterrò 2 stringhe di cui la seconnda sarà il dato che cerco.
        
            
        
        
        
        
    }
    
}
