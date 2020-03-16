package com.canvas.shape.impl;

import com.canvas.model.Canvas;
import com.canvas.shape.IShape;
import com.canvas.util.CanvasUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Verification of bucket coordinates")
class BucketTest {

    private IShape shape;
    private Canvas canvas;

    @BeforeEach
    public void setUp(){
        shape = new Bucket();
        canvas = new Canvas(5,3);
    }

    @Test
    @DisplayName("Verify the empty canvas is filled with the passed character")
    public void verify_the_empty_canvas_is_filled_with_the_passed_character(){
        String[] parameters = new String[]{"2","3","o"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        shape.setCanvasCoordinate(canvas, parameters);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        for(int i=1; i<=canvas.getHeight()-1; i++){
            for(int j=1; j<=canvas.getWidth()-1; j++){
                assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j],parameters[2]));
            }
        }
    }

    @Test
    @DisplayName("Verify the canvas edges are not filled with the passed character")
    public void verify_the_canvas_edges_are_not_filled_with_the_passed_character(){
        String[] parameters = new String[]{"2","3","o"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        shape.setCanvasCoordinate(canvas, parameters);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        for(int i=0; i<=canvas.getHeight()-1; i++){
            for(int j=1; j<=canvas.getWidth()-1; j++){
                if(i==0 || i == canvas.getHeight()+1){
                    assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j],"-"));
                    assertFalse(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j],parameters[2]));
                }else if(i >0 && (j==0 || j == canvas.getWidth()+1)){
                    assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j],"|"));
                    assertFalse(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j],parameters[2]));
                }
            }
        }
    }

    @Test
    @DisplayName("Verify already filled coordinate is not replaced with new character")
    public void verify_already_filled_coordinate_is_not_replaced_with_new_character(){
        String[] parameters = new String[]{"2","3","o"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        canvasCoordinates[1][2] = "x";
        canvasCoordinates[2][3] = "x";
        canvasCoordinates[4][3] = "x";
        canvas.setCanvasCoordinateArray(canvasCoordinates);
        shape.setCanvasCoordinate(canvas, parameters);
        assertFalse(StringUtils.equalsIgnoreCase(canvasCoordinates[1][2],"o"));
        assertFalse(StringUtils.equalsIgnoreCase(canvasCoordinates[2][3],"o"));
        assertFalse(StringUtils.equalsIgnoreCase(canvasCoordinates[4][3],"o"));
    }

}