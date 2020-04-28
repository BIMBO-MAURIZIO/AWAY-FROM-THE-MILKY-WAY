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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;




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
    
    
    public String searchWord(String filePath,String searchedWord) throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException{
        File file = new File(filePath);
        buffRead = new BufferedReader(new FileReader(file));
        String line;
        String increasing = "";
        while ((line = buffRead.readLine()) != null){
            increasing += line+"\n";
        }
    
        String result = "";
        String[] splittedString;// = new String[300]; se ci fossero problemi rimetti questo
        splittedString = increasing.split("\n");
        for(int i = 0; i < 300; i++){
            if(splittedString[i].equals(searchedWord)){
                result = splittedString[i+1];
                buffRead.close();
                break;
            } 
        }
        return result;
  
    }
    
    public void writeFile(File file, String txt){
		try {
			PrintWriter out = new PrintWriter (new FileWriter(file));
			out.println(txt);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
                }
    }

    /*public boolean fileCheck(File file){
        
    }*/


}