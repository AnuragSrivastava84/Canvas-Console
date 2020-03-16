package com.canvas.shape.impl;

import com.canvas.model.Canvas;
import com.canvas.shape.IShape;
import com.canvas.util.CanvasUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Verification of rectangle coordinates")
class RectangleTest {

    private IShape shape;
    private Canvas canvas;

    @BeforeEach
    public void setUp(){
        shape = new Rectangle();
        canvas = new Canvas(5, 3);
    }

    @Test
    @DisplayName("Verify the rectangle edges are filled with the character x")
    public void verify_the_rectangle_edges_are_filled_with_the_character_x(){
        String[] parameters = new String[]{"2","1","4","3"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        shape.setCanvasCoordinate(canvas, parameters);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[1][2],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[1][3],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[1][4],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[2][2],"x"));
        assertTrue(StringUtils.isBlank(canvasCoordinates[2][3]));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[2][4],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[3][2],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[3][3],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[3][4],"x"));
    }

    @Test
    @DisplayName("Verify if the canvas is empty then the rectangle edges are filled with the character x and others are blank")
    public void verify_if_the_canvas_is_empty_then_the_rectangle_edges_are_filled_with_the_character_x_and_others_are_blank(){
        String[] parameters = new String[]{"2","1","4","3"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        shape.setCanvasCoordinate(canvas, parameters);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[1][2],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[1][3],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[1][4],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[2][2],"x"));
        assertTrue(StringUtils.isBlank(canvasCoordinates[2][3]));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[2][4],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[3][2],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[3][3],"x"));
        assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[3][4],"x"));

        assertTrue(StringUtils.isBlank(canvasCoordinates[1][1]));
        assertTrue(StringUtils.isBlank(canvasCoordinates[1][5]));

        assertTrue(StringUtils.isBlank(canvasCoordinates[2][1]));
        assertTrue(StringUtils.isBlank(canvasCoordinates[2][5]));

        assertTrue(StringUtils.isBlank(canvasCoordinates[3][1]));
        assertTrue(StringUtils.isBlank(canvasCoordinates[3][5]));

    }


}