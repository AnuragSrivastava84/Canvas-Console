package com.canvas.factory;

import com.canvas.ICommand;
import com.canvas.constants.CommandType;
import com.canvas.model.Canvas;
import com.canvas.util.CanvasUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Verification of command factory")
class CommandFactoryTest {

    private Canvas canvas;

    @BeforeEach
    public void setUp(){
        canvas = new Canvas(5,3);
    }

    @Test
    @DisplayName("Verify canvas is drawn after passing command C as a parameter")
    public void verify_canvas_is_drawn_after_passing_command_C_as_a_parameter(){
        ICommand command = CommandFactory.getCommand(CommandType.C);
        String[] parameters = new String[]{"5","3"};
        canvas = command.execute(canvas,parameters);
        assertTrue(null != canvas);
    }

    @Test
    @DisplayName("Verify line is drawn after passing command L as a parameter")
    public void verify_line_is_drawn_after_passing_command_L_as_a_parameter(){
        ICommand command = CommandFactory.getCommand(CommandType.L);
        String[] parameter = new String[]{"1","1","3","1"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        command.execute(canvas, parameter);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        for(int i = Integer.valueOf(parameter[0]); i<= Integer.valueOf(parameter[2]); i++){
            assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[Integer.valueOf(parameter[1])][i],"x"));
        }
    }


    @Test
    @DisplayName("Verify rectangle is drawn after passing command R as a parameter")
    public void verify_rectangle_is_drawn_after_passing_command_R_as_a_parameter(){
        ICommand command = CommandFactory.getCommand(CommandType.R);
        String[] parameters = new String[]{"2","1","4","3"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        command.execute(canvas, parameters);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        int row = Integer.valueOf(parameters[1]);
        int rowLength = Integer.valueOf(parameters[3]);

        int col = Integer.valueOf(parameters[0]);
        int colLength = Integer.valueOf(parameters[2]);

        for(int i = row; i<=rowLength; i++){
            for(int j = col; j<=colLength; j++){
                if(i==row || i== rowLength ) {
                    assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j], "x"));
                }else if( i>row && (j == col || j== colLength)){
                    assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j], "x"));
                }else{
                    assertTrue(StringUtils.isBlank(canvasCoordinates[i][j]));
                }
            }
        }
    }

    @Test
    @DisplayName("Verify canvas is filled after passing command B as a parameter")
    public void verify_canvas_is_filled_after_passing_command_B_as_a_parameter(){
        ICommand command = CommandFactory.getCommand(CommandType.B);
        String[] parameters = new String[]{"2","1","C"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        command.execute(canvas, parameters);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        for(int i=1; i<=canvas.getHeight()-1; i++){
            for(int j=1; j<=canvas.getWidth()-1; j++){
                assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j],parameters[2]));
            }
        }
    }
}