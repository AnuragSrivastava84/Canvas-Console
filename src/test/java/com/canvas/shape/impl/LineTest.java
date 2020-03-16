package com.canvas.shape.impl;

import com.canvas.model.Canvas;
import com.canvas.shape.IShape;
import com.canvas.util.CanvasUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Verification for line coordinate")
class LineTest {

    private IShape shape;
    private Canvas canvas;

    @BeforeEach
    public void setUp(){
        shape = new Line();
        canvas = new Canvas(5 ,3);
    }

    @Test
    @DisplayName("Verify the line coordinates are filled with the character x")
    public void verify_the_line_coordinates_are_filled_with_the_character_x(){
        String[] parameters = new String[]{"1","1","3","1"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        shape.setCanvasCoordinate(canvas,parameters);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        int x1 = Integer.valueOf(parameters[0]);
        int x2 = Integer.valueOf(parameters[2]);
        int y = Integer.valueOf(parameters[1]);
        for(int i = x1 ; i <= x2; i++){
            assertTrue(canvasCoordinates[y][i].equalsIgnoreCase("x"));
        }

        parameters = new String[]{"1","2","1","3"};
        int y1 = Integer.valueOf(parameters[1]);
        int y2 = Integer.valueOf(parameters[3]);
        int x = Integer.valueOf(parameters[0]);

        for(int i = y1 ; i <= y2; i++){
            assertTrue(canvasCoordinates[x][i].equalsIgnoreCase("x"));
        }
    }

    @Test
    @DisplayName("Verify if the canvas is empty then the line coordinates are filled with the character x and others are blank")
    public void verify_if_the_canvas_is_empty_then_the_line_coordinates_are_filled_with_the_character_x_and_others_are_blank(){
        String[] parameters = new String[]{"1","1","3","1"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        shape.setCanvasCoordinate(canvas,parameters);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        assertTrue(canvasCoordinates[1][1].equalsIgnoreCase("x"));
        assertTrue(canvasCoordinates[1][2].equalsIgnoreCase("x"));
        assertTrue(canvasCoordinates[1][3].equalsIgnoreCase("x"));
        assertTrue(StringUtils.isBlank(canvasCoordinates[1][4]));
        assertTrue(StringUtils.isBlank(canvasCoordinates[1][5]));
        assertTrue(StringUtils.isBlank(canvasCoordinates[3][1]));
        assertTrue(StringUtils.isBlank(canvasCoordinates[3][5]));
    }



}