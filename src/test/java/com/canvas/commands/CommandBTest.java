package com.canvas.commands;

import com.canvas.ICommand;
import com.canvas.model.Canvas;
import com.canvas.util.CanvasUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Verification of command B")
class CommandBTest {

    private ICommand command;
    private Canvas canvas;

    @BeforeEach
    public void setUp(){
        command = new CommandB();
        canvas = new Canvas(5,3);
    }

    @Test
    @DisplayName("Verify validate command method returns true if all the validations are passed")
    public void verify_validate_command_method_returns_true_if_all_the_validations_are_passed(){
        String[] parameter = new String[]{"2","1","C"};
        assertTrue(command.validateCommand(canvas,parameter));
    }


    @Test
    @DisplayName("Verify validate command method returns false if all or any of the validation is failed")
    public void verify_validate_command_method_returns_false_if_all_or_any_of_the_validation_is_failed(){
        String[] parameter = new String[]{"2","1","C","1"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"2","X","C"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"1","4","C"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"0","0","C"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"6","1","C"};
        assertFalse(command.validateCommand(canvas, parameter));

        canvas = null;
        assertFalse(command.validateCommand(canvas, parameter));
    }

    @Test
    @DisplayName("Verify command B executes if all the validation passed")
    public void verify_command_B_executes_if_all_the_validation_passed(){
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

    @Test
    @DisplayName("Verify command B does not execute if any of the validation failed")
    public void verify_command_B_does_not_execute_if_any_of_the_validation_failed(){
        String[] parameter = new String[]{"1","x","3","1"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        command.execute(canvas, parameter);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        for(int i=0; i < canvas.getHeight()+2; i++) {
            for (int j = 0; j < canvas.getWidth() + 2; j++) {
                if (i == 0 || i == canvas.getHeight() + 1) {
                    assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j], "-"));
                } else if (i > 0 && (j == 0 || j == canvas.getWidth() + 1)) {
                    assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[i][j], "|"));
                } else {
                    assertTrue(StringUtils.isBlank(canvasCoordinates[i][j]));
                }
            }
        }
    }

}