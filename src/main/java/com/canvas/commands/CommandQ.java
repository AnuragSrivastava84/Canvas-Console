package com.canvas.commands;

import com.canvas.ICommand;
import com.canvas.constants.CommandParameterLengthConstant;
import com.canvas.model.Canvas;
import com.canvas.util.ValidationUtils;

/**
 * <h1>Command Q</h1>
 * Implementation class for {@link ICommand} interface
 * It provides the implementation of the methods which are executed
 * while executing the command Q
 *
 * <h2>Methods</h2>
 * {@link #execute(Canvas, String...)}, {@link #validateCommand(Canvas, String...)}
 */
public class CommandQ implements ICommand {

    /**
     * Method will be called when command Q will be called
     * it is used to quit the canvas application
     * @param canvas
     * @param parameters required no parameter which is required to
     *                   execute the command Q
     * @return null
     */
    @Override
    public Canvas execute(Canvas canvas, String... parameters) {
        System.out.println("Exiting Canvas...");
        System.out.println("Thank You For Using...");
        return null;
    }


    /**
     * Method will be called before executing the command Q
     * It will validate the {@link Canvas} and parameters which are passed
     * @param canvas
     * @param parameters
     * @return true if all the conditions are passed, false if all or any of the condition failed
     */
    @Override
    public boolean validateCommand(Canvas canvas, String... parameters) {
        if(ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.QUIT.getValue(), parameters)){
            return true;
        }
        return false;
    }
}
