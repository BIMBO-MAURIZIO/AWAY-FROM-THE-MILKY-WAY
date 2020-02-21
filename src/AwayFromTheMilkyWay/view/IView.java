/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AwayFromTheMilkyWay.view;

import java.io.IOException;
import javafx.stage.Stage;



/**
 *
 * @author giorg
 */
public interface IView {
    abstract void changeCurrentWindow(Stage stage, String window, String title, int windowWidth, int windowHeight) throws IOException;
}
