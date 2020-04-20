/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.model;

/**
 *
 * @author giorg
 */
public class GameStatus {
    private int rimbEffettuati ;
    private int livello ;
    private int rimbDesiderati;
    private String nome;
    
    
    public GameStatus(){
         this.livello = 1;
         this.rimbEffettuati = 0;
         
    }
     
     
    public void increaseLevel(){
         this.livello++;
    }
    
    public void decreaseLevel(){
        this.livello = this.livello - 1;
    }
    
    public void setLevel(int n){
        this.livello = n;
    }
    
    public void setRimbDesiderati(int i){
        this.rimbDesiderati = i;
    }
    
    public int getRimbDes(){
        return this.rimbDesiderati;
    }
    
    
    public int getRimbEff(){
        return this.rimbEffettuati;
    }
    
    public int getLevel(){
        return this.livello;
    }
    
    public void incrementaRimbEff(){
        this.rimbEffettuati ++;
    }
    
    public void setRimbEffettuati(int i){
        this.rimbEffettuati = i;
    }
    
    public void setName(String name){
        this.nome = name;
    }
    
    public String getName(){
        return this.nome;
    }
}
