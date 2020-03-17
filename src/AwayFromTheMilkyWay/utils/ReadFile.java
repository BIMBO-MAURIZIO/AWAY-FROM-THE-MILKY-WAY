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




public class ReadFile {
 
    BufferedReader buffRead;
   
    
    public ReadFile() throws IOException{
        
    }
    
    
    public void readTxt(String filePath) throws FileNotFoundException, IOException{
        File file = new File(filePath);
        buffRead = new BufferedReader(new FileReader(file));
        String line;
        String increasing = null;
        while ((line = buffRead.readLine()) != null)
            System.out.print(line);
            //increasing += line;
        //return increasing;
    }
    
    
   
}
