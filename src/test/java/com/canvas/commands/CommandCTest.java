package com.canvas.commands;

import com.canvas.ICommand;
import com.canvas.model.Canvas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Verification of command C")
class CommandCTest {

    private Canvas canvas;
    private ICommand command;

    @BeforeEach
    public void setUp(){
        command = new CommandC();
    }

    @Test
    @DisplayName("Verify validate command returns true if all the validation passed")
    public void verify_validate_command_returns_true_if_all_the_validation_passed(){
        String[] parameters = new String[]{"5","3"};
        command.execute(canvas,parameters);
        assertTrue(command.validateCommand(canvas, parameters));
    }

    @Test
    @DisplayName("Verify validate command returns false if all or any of the validation failed")
    public void verify_validate_command_returns_false_if_all_or_any_of_the_validation_failed(){
        String[] parameters = new String[]{"x","3"};
        command.execute(canvas,parameters);
        assertFalse(command.validateCommand(canvas, parameters));

        parameters = new String[]{"5","3","5"};
        assertFalse(command.validateCommand(canvas, parameters));

        parameters = new String[]{"5","X","5"};
        assertFalse(command.validateCommand(canvas, parameters));
    }

    @Test
    @DisplayName("Verify command executes if all the validation passed")
    public void verify_command_executes_if_the_all_the_validation_passed(){
        String[] parameters = new String[]{"5","3"};
        canvas = command.execute(canvas,parameters);
        assertTrue(null != canvas);
    }

    @Test
    @DisplayName("Verify command does not executes if any of the validation failed")
    public void verify_command_does_not_executes_if_any_of_the_validation_failed(){
        String[] parameters = new String[]{"X","3"};
        canvas = command.execute(canvas,parameters);
        assertTrue(null == canvas);

        parameters = new String[]{"5","3","5"};
        canvas = command.execute(canvas,parameters);
        assertTrue(null == canvas);
    }
}