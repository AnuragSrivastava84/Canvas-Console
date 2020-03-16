package com.canvas.model;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Canvas Class</h1>
 * Defines the height, width and
 * coordinates of the canvas
 */
@Getter
@Setter
public class Canvas {

    private int height;
    private int width;
    private String[][] canvasCoordinateArray;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvasCoordinateArray = new String[height+2][width+2];
    }
}
