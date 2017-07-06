/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.marcowillems.slick2dgametesting.map;

/**
 *
 * @author marco
 */
public abstract class Layer {
    
    private String name;
    private float opacity = 1f;
    private boolean visible = true;
    private int offsetX = 0;
    private int offsetY = 0;
    
    private java.util.Map<String, String> properties;
    
}
