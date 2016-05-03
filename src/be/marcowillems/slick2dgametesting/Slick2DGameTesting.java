/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.marcowillems.slick2dgametesting;

import be.marcowillems.slick2dgametesting.game.Game;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;

/**
 *
 * @author Marco
 */
public class Slick2DGameTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Game("Slick2D Game Testing"));
            appgc.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(Slick2DGameTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
