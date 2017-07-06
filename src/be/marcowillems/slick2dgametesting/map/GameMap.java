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
public class GameMap {
    
    private int width; // map width in tiles
    private int height; // map height in tiles
    private int tileWidth; // width of a tile
    private int tileHeight; // height of a tile
    private Color bgColor; // background color of the map
    
    private java.util.Map<String, String> properties;
    private List<TileSet> tileSets;
    private List<Layer> layers;
    
}
