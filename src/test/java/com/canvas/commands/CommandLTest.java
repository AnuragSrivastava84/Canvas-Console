package com.canvas.commands;

import com.canvas.ICommand;
import com.canvas.model.Canvas;
import com.canvas.util.CanvasUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Verification of command L")
class CommandLTest {

    private ICommand command;
    private Canvas canvas;

    @BeforeEach
    public void setUp(){
        command = new CommandL();
        canvas = new Canvas(5,3);
    }

    @Test
    @DisplayName("Verify validate command method returns true if all the validations passed")
    public void verify_validate_command_method_returns_true_if_all_the_validations_passed(){
        String[] parameter = new String[]{"1","1","3","1"};
        assertTrue(command.validateCommand(canvas,parameter));
    }

    @Test
    @DisplayName("Verify validate command method returns false if all or any of the validations failed")
    public void verify_validate_command_method_returns_false_if_all_or_any_of_the_validations_failed(){
        String[] parameter = new String[]{"1","1","3","1","7"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"1","X","3","1"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"1","6","3","1"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"1","1","3","2"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"5","1","3","2"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"1","3","3","2"};
        assertFalse(command.validateCommand(canvas, parameter));

        parameter = new String[]{"1","3","1","2"};
        assertFalse(command.validateCommand(canvas, parameter));

        canvas = null;
        assertFalse(command.validateCommand(canvas, parameter));
    }

    @Test
    @DisplayName("Verify command L executes if all the validation passed")
    public void verify_command_L_executes_if_all_the_validation_passed(){
        String[] parameter = new String[]{"1","1","3","1"};
        CanvasUtil.setCanvasCoordinateArray(canvas);
        command.execute(canvas, parameter);
        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        for(int i = Integer.valueOf(parameter[0]); i<= Integer.valueOf(parameter[2]); i++){
            assertTrue(StringUtils.equalsIgnoreCase(canvasCoordinates[Integer.valueOf(parameter[1])][i],"x"));
        }
    }

    @Test
    @DisplayName("Verify command L does not execute if any of the validation failed")
    public void verify_command_L_does_not_execute_if_any_of_the_validation_failed(){
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