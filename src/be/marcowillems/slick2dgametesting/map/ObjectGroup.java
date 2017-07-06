/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.marcowillems.slick2dgametesting.map;

import java.awt.Color;
import java.util.List;

public class ObjectGroup extends Layer {

    private Color color; // color used to display the objects in this group
    // TODO: draworder?

    private List<ObjectGroup.Object> objects;

    public class Object {

        private int id; // unique ID of the object
        private String name; // name of the object
        // TODO: type?
        private int x;
        private int y;
        private int width = 0;
        private int height = 0;
        private int rotation = 0;
        private int gid = -1; // (optional) reference to a tile
        private boolean visible = true;

        private java.util.Map<String, String> properties;
        // TODO: image

    }

    public class Ellipse extends ObjectGroup.Object {

    }

    public class Polygon extends ObjectGroup.Object {

        private List<Integer> pointsX;
        private List<Integer> pointsY;
    }

    public class Polyline extends ObjectGroup.Object {

        private List<Integer> pointsX;
        private List<Integer> pointsY;
    }

}
