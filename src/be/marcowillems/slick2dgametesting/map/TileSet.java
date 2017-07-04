/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.marcowillems.slick2dgametesting.map;

import java.util.List;
import java.awt.Color;

/**
 *
 * @author marco
 */
public class TileSet {

    private int firstGID; // first global tile ID of this tileset (this global ID maps to the first tile in this tileset)
    private String name; // name of this tileset
    private int tileWidth; // (maximum) width of the tiles in this tileset
    private int tileHeight; // (maximum) height of the tiles in this tileset
    private int tileCount; // number of tiles in this tileset
    private int columns; // number of tile columns in the tileset

    /**
     * ?? This element is used to specify an offset in pixels, to be applied
     * when drawing a tile from the related tileset.
     */
    private int tileOffsetX;
    private int tileOffsetY;
    private java.util.Map<String, String> properties;
    private TileSet.Image image;
    private List<TileSet.Terrain> terrainTypes;
    private List<TileSet.Tile> tiles;

    // TODO: necessary?
    public class Image {

        private String format; // png, jpg, ...
        private String source;
        private Color trans;
        private int width;
        private int height;
        // TODO: data?
    }

    public class Terrain {

        private String name;
        private int tile;
        private java.util.Map<String, String> properties;

    }

    public class Tile {

        private int id;
        private int[] terrain = new int[]{-1, -1, -1, -1};

        private java.util.Map<String, String> properties;
        private TileSet.Image image;
        // TODO: objectgroup
        private List<Frame> animation;

    }

    public class Frame {

        private int tileId; // local ID of a tile within the parent tileset
        private int duration; // how long (in milliseconds) this frame should be displayed before advancing to the next frame
    }

}
