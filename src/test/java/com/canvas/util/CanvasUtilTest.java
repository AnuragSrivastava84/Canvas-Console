package com.canvas.util;

import com.canvas.model.Canvas;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Verification for canvas util methods")
public class CanvasUtilTest {

    Canvas canvas ;
    private String[][] canvasCoordinates;

    @BeforeEach
    public void init(){
        canvas = new Canvas(5 ,3);
        canvasCoordinates = canvas.getCanvasCoordinateArray();
    }

    @Test
    @DisplayName("Verify canvas height")
    public void verify_The_Canvas_Height(){
        assertTrue(canvasCoordinates.length == canvas.getHeight()+2);
    }

    @Test
    @DisplayName("Verify canvas width")
    public void verify_The_Canvas_Width(){
        assertTrue(canvasCoordinates[0].length == canvas.getWidth()+2);
    }

    @Test
    @DisplayName("Verify canvas height and width edges symbols are | and -")
    public void verify_canvas_height_and_width_edges_symbols(){
        CanvasUtil.setCanvasCoordinateArray(canvas);
        for(int i=0; i<=canvas.getHeight()-1; i++){
            for(int j=1; j<=canvas.getWidth()-1; j++){
                if(i==0 || i == canvas.getHeight()+1){
                    assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j],"-"));
                }else if(i >0 && (j==0 || j == canvas.getWidth()+1)){
                    assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j],"|"));
                }
            }
        }

    }
}