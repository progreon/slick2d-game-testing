/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.marcowillems.slick2dgametesting.game.states;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author Marco
 */
public class MenuState extends BasicGameState {
    
    public static final int ID = 0;
    
    private MouseOverArea btnPlay;

    public MenuState() {
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        Image btnPlayImage = createButtonImage("Play?", java.awt.Color.yellow, java.awt.Color.red);
        Image btnPlayImageOver = createButtonImage("Let's play!", java.awt.Color.red, java.awt.Color.yellow);
        
        int x = (container.getWidth() - btnPlayImage.getWidth())/2;
        int y = (container.getHeight() - btnPlayImage.getHeight())/2;
        btnPlay = new MouseOverArea(container, btnPlayImage, x, y, new ComponentListener() {

            @Override
            public void componentActivated(AbstractComponent source) {
                game.enterState(PlayState.ID);
            }
        });
        btnPlay.setMouseOverImage(btnPlayImageOver);
        System.out.println("btnPlay: " + btnPlay.getX() + ", " + btnPlay.getY() + ", " + btnPlay.getWidth() + ", " + btnPlay.getHeight());
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        btnPlay.render(container, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }
    
    private Image createButtonImage(String text, java.awt.Color fgColor, java.awt.Color bgColor) throws SlickException {
        Image btnImg = new Image(100, 30);
        Graphics g = btnImg.getGraphics();
        g.setColor(new Color(bgColor.getRGB()));
        g.fillRect(0, 0, btnImg.getWidth(), btnImg.getHeight());
        g.setColor(new Color(fgColor.getRGB()));
        g.setFont(new TrueTypeFont(new java.awt.Font(java.awt.Font.DIALOG, java.awt.Font.BOLD, 18), false));
        int textX = (btnImg.getWidth() - g.getFont().getWidth(text)) / 2;
        int textY = (btnImg.getHeight() - g.getFont().getHeight(text)) / 2;
        g.drawString(text, textX, textY);
        g.destroy();
        
        return btnImg;
    }
    
}
