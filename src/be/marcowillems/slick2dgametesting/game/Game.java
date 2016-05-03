/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.marcowillems.slick2dgametesting.game;

import be.marcowillems.slick2dgametesting.game.states.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author Marco
 */
public class Game extends StateBasedGame {
    
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = WINDOW_WIDTH * 9 / 16;

    public Game(String name) {
        super(name);
        this.addState(new MenuState());
        this.addState(new PlayState());
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.getState(MenuState.ID).init(container, this);
        this.getState(PlayState.ID).init(container, this);
        this.enterState(MenuState.ID);
    }
    
}
