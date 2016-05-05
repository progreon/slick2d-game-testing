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

    private final int SCALE = 3;
    private final int TILE_SIZE = 8;
    private SpriteSheet spriteSheet;
    private final Image[] arrows;

    // TODO: to a map class
    private final int[][] mapTileIDs;
    private final int mapWidth;
    private final int mapHeight;
    
    // TODO: to (a) location class(es)?
    private int mapCenterX;
    private int mapCenterY;
    private int playerMapX;
    private int playerMapY;
    
    // TODO: to (a) location class(es)?
    private final boolean moveByTile = true;
    private final boolean centerPlayer = true;
    private final boolean followPlayer = !true; // useless when centerPlayer is true!

    // TODO: to (a) location class(es)?
    private final int MOVE_DELTA = 1;
    private boolean moving = false;
    private int direction = 0; // 0 = down, 1 = left, 2 = up, 3 = right
    private int moved = 0;
//    private final int waitMillis = 100;
//    private int waitMillisPast = 0;

    public PlayState() {
        mapTileIDs = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 2, 2, 3, 3, 3, 3, 2, 2, 0},
            {0, 2, 3, 3, 1, 3, 3, 3, 2, 0},
            {0, 2, 3, 3, 3, 3, 3, 3, 2, 0},
            {0, 2, 3, 3, 3, 3, 3, 1, 2, 0},
            {0, 2, 3, 3, 3, 3, 3, 3, 2, 0},
            {0, 2, 2, 3, 3, 3, 3, 2, 2, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        mapWidth = mapTileIDs.length * TILE_SIZE;
        mapHeight = mapTileIDs[0].length * TILE_SIZE;
        arrows = new Image[4];
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        spriteSheet = new SpriteSheet(new Image("images/basictiles.png"), TILE_SIZE, TILE_SIZE);
        spriteSheet.setFilter(Image.FILTER_NEAREST);

        for (int i = 0; i < 4; i++) {
            arrows[i] = spriteSheet.getSprite(i, 1);
            arrows[i].setFilter(Image.FILTER_NEAREST);
        }

        centerMapAtTile(3, 7);
        putPlayerOnTile(4, 4);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawString("x: " + playerMapX + "\ny: " + playerMapY, 25, 25);
        g.scale(SCALE, SCALE);

        spriteSheet.startUse();
        for (int y = 0; y < mapTileIDs.length; y++) {
            for (int x = 0; x < mapTileIDs[y].length; x++) {
                renderTileByID(container, spriteSheet, mapTileIDs[y][x], x, y);
            }
        }
        spriteSheet.endUse();

        arrows[direction].draw(getPlayerX(container), getPlayerY(container));
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            game.enterState(MenuState.ID);
        }
        if (!moving) {
            if (input.isKeyDown(Input.KEY_DOWN)) {
                moving = true;
                direction = 0;
            }
            if (input.isKeyDown(Input.KEY_LEFT)) {
                moving = true;
                direction = 1;
            }
            if (input.isKeyDown(Input.KEY_UP)) {
                moving = true;
                direction = 2;
            }
            if (input.isKeyDown(Input.KEY_RIGHT)) {
                moving = true;
                direction = 3;
            }
        }
        if (moving) {
            if (moveByTile) {
                movePlayer(direction, MOVE_DELTA);
                moved += MOVE_DELTA;
                if (moved >= TILE_SIZE) {
                    moved = 0;
                }
                if (moved == 0) {
                    moving = false;
                }
            } else {
                movePlayer(direction, MOVE_DELTA);
                moving = false;
            }
        }
    }

    private void renderTileByID(GameContainer container, SpriteSheet ss, int tileID, int x, int y) {
        int sx = tileID % ss.getHorizontalCount();
        int sy = tileID / ss.getVerticalCount();
        ss.renderInUse(x * TILE_SIZE + getMapX(container), y * TILE_SIZE + getMapY(container), sx, sy);
    }

    // TODO: to (a) location class(es)?
    private void centerMapAtTile(int x, int y) {
        mapCenterX = TILE_SIZE / 2 + TILE_SIZE * x;
        mapCenterY = TILE_SIZE / 2 + TILE_SIZE * y;
    }

    // TODO: to (a) location class(es)?
    private void putPlayerOnTile(int x, int y) {
        playerMapX = TILE_SIZE / 2 + TILE_SIZE * x;
        playerMapY = TILE_SIZE / 2 + TILE_SIZE * y;
    }
    
    // TODO: to (a) location class(es)?
    private void movePlayer(int direction, int delta) {
        switch (direction) {
            case 0:
                playerMapY += delta;
                break;
            case 1:
                playerMapX -= delta;
                break;
            case 2:
                playerMapY -= delta;
                break;
            case 3:
                playerMapX += delta;
                break;
        }
        if (followPlayer) {
            switch (direction) {
                case 0:
                    mapCenterY += delta;
                    break;
                case 1:
                    mapCenterX -= delta;
                    break;
                case 2:
                    mapCenterY -= delta;
                    break;
                case 3:
                    mapCenterX += delta;
                    break;
            }
        }
    }

    private int getContainerCenterX(GameContainer container) {
        return container.getWidth() / (2 * SCALE);
    }

    private int getContainerCenterY(GameContainer container) {
        return container.getHeight() / (2 * SCALE);
    }

    private int getMapX(GameContainer container) {
        if (centerPlayer) {
            mapCenterX = playerMapX;
        }
        return (getContainerCenterX(container) - mapCenterX);
    }

    private int getMapY(GameContainer container) {
        if (centerPlayer) {
            mapCenterY = playerMapY;
        }
        return (getContainerCenterY(container) - mapCenterY);
    }

    private int getPlayerX(GameContainer container) {
        return getMapX(container) + playerMapX - TILE_SIZE / 2;
    }

    private int getPlayerY(GameContainer container) {
        return getMapY(container) + playerMapY - TILE_SIZE / 2;
    }

}
