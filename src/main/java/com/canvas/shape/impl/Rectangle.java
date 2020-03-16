package com.canvas.shape.impl;

import com.canvas.model.Canvas;
import com.canvas.model.CanvasCoordinate;
import com.canvas.shape.IShape;

/**
 * <h1>Rectangle</h1>
 * Implementation class for {@link IShape} interface
 * It provides the implementation of the methods which are executed
 * while executing the command R
 *
 * <h2>Method</h2>
 * {@link #setCanvasCoordinate(Canvas, String...)}
 */
public class Rectangle implements IShape {

    /**
     * This method is used to set the coordinate values with the
     * character "x" for drawing the rectangle
     * @param canvas
     * @param parameters
     */
    @Override
    public void setCanvasCoordinate(Canvas canvas, String... parameters) {
        String[][] canvasCoordinateArray = canvas.getCanvasCoordinateArray();

        CanvasCoordinate sourceCoordinates = new CanvasCoordinate(Integer.valueOf(parameters[0]), Integer.valueOf(parameters[1]));
        CanvasCoordinate destinationCoordinates = new CanvasCoordinate(Integer.valueOf(parameters[2]), Integer.valueOf(parameters[3]));

        for(int y = sourceCoordinates.getY(); y <= destinationCoordinates.getY(); y++){
            for(int x = sourceCoordinates.getX(); x <= destinationCoordinates.getX() ; x++){
                if(y == sourceCoordinates.getY() || y == destinationCoordinates.getY()) {
                    canvasCoordinateArray[y][x] = "x";
                }else if(y > sourceCoordinates.getY() && (x == sourceCoordinates.getX() || x == destinationCoordinates.getX()) ){
                    canvasCoordinateArray[y][x] = "x";
                }else{
                    canvasCoordinateArray[y][x] = " ";
                }
            }
        }
        canvas.setCanvasCoordinateArray(canvasCoordinateArray);
    }
}
