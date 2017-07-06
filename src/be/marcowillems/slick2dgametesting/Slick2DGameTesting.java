/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.marcowillems.slick2dgametesting;

import be.marcowillems.slick2dgametesting.game.Game;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.Arrays;
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
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, URISyntaxException {
        loadNativeLibraries();
        System.out.println(System.getProperty("java.library.path"));
        
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Game("Slick2D Game Testing"));
            appgc.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
            appgc.setVSync(true);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(Slick2DGameTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static boolean loadNativeLibraries() {
        try {
            String nativeLibDir = new File(Slick2DGameTesting.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent() + File.separator + "lib/lwjgl-native/";
            String OS = System.getProperty("os.name").toLowerCase();
            String OSDir;
            if (OS.contains("win")) {
                OSDir = nativeLibDir + "windows";
            } else if (OS.contains("mac")) {
                OSDir = nativeLibDir + "macosx";
            } else if (OS.contains("nux")) {
                OSDir = nativeLibDir + "linux";
            } else if (OS.contains("sunos")) {
                OSDir = nativeLibDir + "solaris";
            } else {
                System.out.println("Your OS is not supported!!");
                return false;
            }
            System.setProperty("java.library.path", System.getProperty("java.library.path") + File.pathSeparator + OSDir);
            Field field = ClassLoader.class.getDeclaredField("sys_paths");
            field.setAccessible( true );
            field.set(null, null);
            return true;
        } catch (URISyntaxException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
//            Logger.getLogger(Slick2DGameTesting.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
