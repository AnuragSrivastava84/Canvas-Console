package com.canvas.util;

import com.canvas.model.Canvas;

/**
 * <h1>CanvasUtil Class</h1>
 * Provides the utility methods for the canvas
 *
 * <h2>Methods</h2>
 * {@link #setCanvasCoordinateArray(Canvas)}
 * {@link #drawCanvas(Canvas)}
 */
public class CanvasUtil {

    /**
     * This method is used to set the canvas edges with the
     * character "|" and "-"
     * @param canvas
     */
    public static void setCanvasCoordinateArray(Canvas canvas){
        String[][] canvasCoordinateArray = canvas.getCanvasCoordinateArray();
        for(int i=0; i < canvas.getHeight()+2; i++){
            for(int j=0 ; j< canvas.getWidth()+2; j++){
                if(i==0 || i == canvas.getHeight()+1){
                    canvasCoordinateArray[i][j] = "-";
                }else if(i >0 && (j==0 || j == canvas.getWidth()+1)){
                    canvasCoordinateArray[i][j] = "|";
                }else{
                    canvasCoordinateArray[i][j] = " ";
                }
            }
        }
        canvas.setCanvasCoordinateArray(canvasCoordinateArray);
    }

    /**
     * This method is used to draw the canvas as per the
     * coordinates values set the canvas
     * @param canvas
     */
    public static void drawCanvas(Canvas canvas){
        for (String[] xCoordinate : canvas.getCanvasCoordinateArray()) {
            for(String yCoordinate : xCoordinate){
                System.out.print(yCoordinate);
            }
            System.out.println();
        }
    }
}
