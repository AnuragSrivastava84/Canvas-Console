package com.canvas.util;

import com.canvas.constants.CommandParameterLengthConstant;
import com.canvas.model.Canvas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Verification for common commands validation methods")
class ValidationUtilsTest {

    private Canvas canvas;

    @BeforeEach
    void init(){
        canvas = new Canvas(5,3);
    }

    @Test
    @DisplayName("Verify canvas exist")
    public void verify_canvas_exist(){
        assertTrue(ValidationUtils.validateCanvasExist(canvas));
    }

    @Test
    @DisplayName("Verify canvas does not exist")
    public void verify_canvas_does_not_exist(){
        canvas = null;
        assertFalse(ValidationUtils.validateCanvasExist(canvas));
    }

    @Test
    @DisplayName("Verify the expected parameter of command B")
    public void verify_the_expected_parameter_of_command_B(){
        String[] parameters = new String[3];
        assertTrue(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.FILL_BUCKET.getValue(),parameters));
    }

    @Test
    @DisplayName("Verify the test fails if expected parameter does not match as per the command B")
    public void verify_the_test_fails_if_expected_parameter_does_not_match_as_per_the_command_B(){
        String[] parameters = new String[2];
        assertFalse(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.FILL_BUCKET.getValue(),parameters));
    }

    @Test
    @DisplayName("Verify the expected parameter of command C")
    public void verify_the_expected_parameter_of_command_C(){
        String[] parameters = new String[2];
        assertTrue(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.CREATE_CANVAS.getValue(),parameters));
    }

    @Test
    @DisplayName("Verify the test fails if expected parameter does not match as per the command C")
    public void verify_the_test_fails_if_expected_parameter_does_not_match_as_per_the_command_C(){
        String[] parameters = new String[3];
        assertFalse(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.CREATE_CANVAS.getValue(),parameters));
    }

    @Test
    @DisplayName("Verify the expected parameter of command L")
    public void verify_the_expected_parameter_of_command_L(){
        String[] parameters = new String[4];
        assertTrue(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.LINE.getValue(),parameters));
    }

    @Test
    @DisplayName("Verify the test fails if expected parameter does not match as per the command L")
    public void verify_the_test_fails_if_expected_parameter_does_not_match_as_per_the_command_L(){
        String[] parameters = new String[3];
        assertFalse(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.LINE.getValue(),parameters));
    }


    @Test
    @DisplayName("Verify the expected parameter of command Q")
    public void verify_the_expected_parameter_of_command_Q(){
        String[] parameters = new String[0];
        assertTrue(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.QUIT.getValue(),parameters));
    }

    @Test
    @DisplayName("Verify the test fails if expected parameter does not match as per the command Q")
    public void verify_the_test_fails_if_expected_parameter_does_not_match_as_per_the_command_Q(){
        String[] parameters = new String[3];
        assertFalse(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.QUIT.getValue(),parameters));
    }


    @Test
    @DisplayName("Verify the expected parameter of command R")
    public void verify_the_expected_parameter_of_command_R(){
        String[] parameters = new String[4];
        assertTrue(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.RECTANGLE.getValue(),parameters));
    }

    @Test
    @DisplayName("Verify the test fails if expected parameter does not match as per the command R")
    public void verify_the_test_fails_if_expected_parameter_does_not_match_as_per_the_command_R(){
        String[] parameters = new String[3];
        assertFalse(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.RECTANGLE.getValue(),parameters));
    }

    @Test
    @DisplayName("Verify the passed parameters should be converted to integer")
    public void verify_the_passed_parameters_should_be_converted_to_integer(){
        String[] parameters = new String[]{"1","2"};
        assertTrue(ValidationUtils.validateParameterType(parameters));
    }

    @Test
    @DisplayName("Verify the test_fails if passed parameters cannot be converted to integer")
    public void verify_the_test_fails_if_passed_parameters_cannot_be_converted_to_integer(){
        String[] parameters = new String[]{"1","X"};
        assertFalse(ValidationUtils.validateParameterType(parameters));
    }

    @Test
    @DisplayName("Verify the parameters are existing with in the canvas")
    public void verify_the_parameters_are_existing_with_in_the_canvas(){
        String[] paramter1 = new String[]{"1","1","5","3"};
        String[] paramter2 = new String[]{"2","2","4","2"};
        assertTrue(ValidationUtils.validateLRParameterWithInCanvas(canvas,paramter1));
        assertTrue(ValidationUtils.validateLRParameterWithInCanvas(canvas,paramter2));
    }

    @Test
    @DisplayName("Verify the test fails when parameters are not existing with in the canvas")
    public void verify_the_test_fails_when_parameters_are_not_existing_with_in_the_canvas(){
        String[] paramter1 = new String[]{"0","0","6","4"};
        String[] paramter2 = new String[]{"2","2","6","4"};
        assertFalse(ValidationUtils.validateLRParameterWithInCanvas(canvas,paramter1));
        assertFalse(ValidationUtils.validateLRParameterWithInCanvas(canvas,paramter2));
    }
}