package com.canvas.commands;

import com.canvas.ICommand;
import com.canvas.model.Canvas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Verification of command Q")
class CommandQTest {

    private ICommand command;
    private Canvas canvas;

    @BeforeEach
    public void setUp(){
        command = new CommandQ();
    }

    @Test
    @DisplayName("Verify validate method returns true if all validation conditions are passed")
    public void verify_validate_method_returns_true_if_all_validation_conditions_are_passed(){
        String[] parameter = new String[0];
        assertTrue(command.validateCommand(canvas,parameter));
    }

    @Test
    @DisplayName("Verify validate method returns false if all or any of the validation is failed")
    public void verify_validate_method_returns_false_if_all_or_any_of_the_validation_is_failed(){
        String[] parameter = new String[]{"1"};
        assertFalse(command.validateCommand(canvas,parameter));
    }

}