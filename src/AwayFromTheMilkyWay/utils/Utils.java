/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class Utils {
 
    private BufferedReader buffRead;
    private static Utils instance;
    
    public Utils(){
        
    }
    
    public static Utils getInstance(){
        if(instance == null)
            instance = new Utils();
        return instance;
        
    }
    
    
    /*public String readTxt(String filePath) throws FileNotFoundException, IOException{
        File file = new File(filePath);
        buffRead = new BufferedReader(new FileReader(file));
        String line;
        String increasing = "";
        while ((line = buffRead.readLine()) != null){
            //System.out.println(line);
            increasing += line+"\n";
        }
        //System.out.println(increasing);
            
        return increasing;
    }
    
    
    public String searchWord(String increasing, String searchedWord) throws ArrayIndexOutOfBoundsException{
        String result = "";
        String[] splittedString = new String[100];
        splittedString = increasing.split("\n");
        for(int i = 0; i < 100; i++){
            if(splittedString[i].equals(searchedWord)){
                result = splittedString[i+1];
                break;
            } 
        }
        return result;

    }*/
    public String searchWord(String filePath,String searchedWord) throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException{
        File file = new File(filePath);
        buffRead = new BufferedReader(new FileReader(file));
        String line;
        String increasing = "";
        while ((line = buffRead.readLine()) != null){
            //System.out.println(line);
            increasing += line+"\n";
        }
        //System.out.println(increasing);
    
        String result = "";
        String[] splittedString = new String[300];
        splittedString = increasing.split("\n");
        for(int i = 0; i < 300; i++){
            if(splittedString[i].equals(searchedWord)){
                result = splittedString[i+1];
                break;
            } 
        }
        return result;
  
    }
}