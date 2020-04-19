/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.utils;

import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author giorg
 */
public class Resources {
    
    public enum GeneralImages
    {   
        SPAZIO("media/images/spazio5.jpg"),
        MERCURIO("media/images/mercurio.png"),
        GIOVE("media/images/giove.png"),
        MILKYWAY("media/images/milkyWay.png"),
        GRID("media/images/grid.png"),
        SPACEMAN("media/images/spaceMan.png"),
        SPACEMANICON("media/images/spaceManIcon.png"),
        CIRCLE("media/images/circle.png");
        private Image img = null;
        
        GeneralImages(String fileSrc)
        {
            URL imgSrc = this.getClass().getResource(fileSrc);            
            img = new Image(imgSrc.toString());
        }
        
        public Image getImage()
        {
            return this.img;
        }        
        
    }
    
    
    
    public enum Explosion
    {
        EXP1("media/images/explosion1.png"),
        EXP2("media/images/explosion2.png"),
        EXP3("media/images/explosion3.png"),
        EXP4("media/images/explosion4.png"),
        EXP5("media/images/explosion5.png"),
        EXP6("media/images/explosion6.png"),
        EXP7("media/images/explosion7.png"),
        EXP8("media/images/explosion8.png"),
        EXP9("media/images/explosion9.png"),
        EXP10("media/images/explosion10.png"),
        EXP11("media/images/explosion11.png"),
        EXP12("media/images/explosion12.png"),
        EXP13("media/images/explosion13.png"),
        EXP14("media/images/explosion14.png"),
        EXP15("media/images/explosion15.png"),
        EXP16("media/images/explosion16.png"),
        EXP17("media/images/explosion17.png"),
        EXP18("media/images/explosion18.png"),
        EXP19("media/images/explosion19.png"),
        EXP20("media/images/explosion20.png"),
        EXP21("media/images/explosion21.png"),
        EXP22("media/images/explosion22.png"),
        EXP23("media/images/explosion23.png"),
        EXP24("media/images/explosion24.png"),
        EXP25("media/images/explosion25.png"),
        EXP26("media/images/explosion26.png"),
        EXP27("media/images/explosion27.png"),
        EXP28("media/images/explosion28.png"),
        EXP29("media/images/explosion29.png"),
        EXP30("media/images/explosion30.png"),
        EXP31("media/images/explosion31.png"),
        EXP32("media/images/explosion32.png"),
        EXP33("media/images/explosion33.png"),
        EXP34("media/images/explosion34.png"),
        EXP35("media/images/explosion35.png"),
        EXP36("media/images/explosion36.png");
         private Image img = null;
        
        Explosion(String fileSrc)
        {
            URL imgSrc = this.getClass().getResource(fileSrc);
            img = new Image(imgSrc.toString());
        }
        
        public Image getImage()
        {
            return this.img;
        }
    } 
    
    
    public enum Backwash
    {
        BCK1("media/images/circle1.png"),
        BCK2("media/images/circle2.png"),
        BCK3("media/images/circle3.png"),
        BCK4("media/images/circle4.png");
        private Image img = null;
        
        Backwash(String fileSrc)
        {
            URL imgSrc = this.getClass().getResource(fileSrc);
            img = new Image(imgSrc.toString());
        }
        
        public Image getImage()
        {
            return this.img;
        }
    } 
    
    
    public enum SoundEffects{
        
        PLANETHIT("media/sounds/impattoPianeti.mp3"),
        VICTORY("media/sounds/vittoria.mp3"),
        DEFEAT("media/sounds/sconfitta.mp3"),
        EXPLOSION("media/sounds/esplosione.mp3");
        
        
        private boolean soundEnabled;
        private AudioClip media;
        private final static double MUSIC_VOLUME = 0.10;
        
        SoundEffects(String fileSrc)
        {
            URL url = this.getClass().getResource(fileSrc);
            media = new AudioClip(url.toString());
            this.soundEnabled = true;
            
        }
        
        public void play()
        {
            if(this.soundEnabled)
                media.setVolume(MUSIC_VOLUME);
                media.play();
        }
        
        public void toggleSoundEnabled()
        {
            this.soundEnabled = !soundEnabled;
        }
    }
    
    
    public enum Music{
    
        //SOUNDTRACK("src\\AwayFromTheMilkyWay\\configuration\\media\\sounds\\song1.mp3");
        SOUNDTRACK("media/sounds/song1.mp3");
             
        private boolean musicEnabled;
        private MediaPlayer audioMedia;
        private final static double MUSIC_VOLUME = 0.01;
        Music(String fileSrc){
        
            URL url = this.getClass().getResource(fileSrc);
            audioMedia = new MediaPlayer(new Media(url.toString()));
            audioMedia.setCycleCount(MediaPlayer.INDEFINITE);
            this.musicEnabled = true;
        }
        
        public void play(){
            if(this.musicEnabled)
            {
                this.audioMedia.setVolume(MUSIC_VOLUME);
                this.audioMedia.play();
            }
            else
                this.audioMedia.stop();
        }
        
        public void stop(){
        
            this.audioMedia.stop();
        }
        
        public void toggleMusicEnabled(){
        
            this.musicEnabled = !musicEnabled;
        }
        
        
    }
    
}
