/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import java.io.IOException;



/**
 *
 * @author giorg
 */
public interface IView {
   abstract void changeCurrentWindow(String window) throws IOException;
   abstract void openGameWindow(int level) ;
   public GameWindow getGameWindow();
  
}
