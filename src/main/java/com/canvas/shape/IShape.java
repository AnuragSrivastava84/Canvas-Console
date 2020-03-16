package com.canvas.shape;

import com.canvas.model.Canvas;

/**
 * Shape interface describes the method which is required to set the 
 * coordinates for drawing the shape with the canvas
 * <h2></>Implementation classes</h2>
 * {@link com.canvas.shape.impl.Bucket},{@link com.canvas.shape.impl.Line},
 * {@link com.canvas.shape.impl.Rectangle}
 *
 * <h2>Methods</h2>
 * {@link #setCanvasCoordinate(Canvas, String...)}
 *
 */
public interface IShape {
    void setCanvasCoordinate(Canvas canvas, String... parameters);
}
