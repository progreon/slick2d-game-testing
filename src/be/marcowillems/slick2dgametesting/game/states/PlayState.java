/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.marcowillems.slick2dgametesting.game.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author Marco
 */
public class PlayState extends BasicGameState {
    
    public static final int ID = 1;
    
    private SpriteSheet spriteSheet;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawString("Let's play a game!", 50, 50);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            game.enterState(MenuState.ID);
        }
    }
    
}
