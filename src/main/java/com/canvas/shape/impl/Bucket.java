package com.canvas.shape.impl;

import com.canvas.model.Canvas;
import com.canvas.shape.IShape;
import org.apache.commons.lang3.StringUtils;

/**
 * <h1>Bucket</h1>
 * Implementation class for {@link IShape} interface
 * It provides the implementation of the methods which are executed
 * while executing the command B
 *
 * <h2>Method</h2>
 * {@link #setCanvasCoordinate(Canvas, String...)}
 */
public class Bucket implements IShape {

    /**
     * This method is used to set the coordinate values with the
     * filled character or string which been passed as a parameter
     * @param canvas
     * @param parameters
     */
    @Override
    public void setCanvasCoordinate(Canvas canvas, String... parameters) {
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        int col = Integer.valueOf(parameters[0]);
        int row = Integer.valueOf(parameters[1]);
        fillBucket(canvasCoordinates,row,col, parameters[2]);
        canvas.setCanvasCoordinateArray(canvasCoordinates);
    }

    /**
     * This is the recursive method which is used to fill the coordinate
     * with the character or string where the existing coordinate value is
     * blank
     * @param canvasCoordinates
     * @param row
     * @param col
     * @param colorCharacter
     */
    private void fillBucket(String[][] canvasCoordinates, int row, int col, String colorCharacter){
        String coordinate = canvasCoordinates[row][col];
        if(StringUtils.isBlank(coordinate)){
            canvasCoordinates[row][col] = colorCharacter;
            fillBucket(canvasCoordinates,row+1,col,colorCharacter);
            fillBucket(canvasCoordinates, row-1, col, colorCharacter);
            fillBucket(canvasCoordinates, row, col+1, colorCharacter);
            fillBucket(canvasCoordinates, row, col-1, colorCharacter);
        }
    }
}
