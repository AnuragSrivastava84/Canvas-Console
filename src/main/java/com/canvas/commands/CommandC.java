package com.canvas.commands;

import com.canvas.ICommand;
import com.canvas.constants.CommandParameterLengthConstant;
import com.canvas.model.Canvas;
import com.canvas.util.CanvasUtil;
import com.canvas.util.ValidationUtils;

/**
 * <h1>Command C</h1>
 * Implementation class for {@link ICommand} interface
 * It provides the implementation of the methods which are executed
 * while executing the command C
 *
 * <h2>Methods</h2>
 * {@link #execute(Canvas, String...)}, {@link #validateCommand(Canvas, String...)}
 */
public class CommandC implements ICommand {

    /**
     * Method will be called when command C will be called
     * it is used to create the canvas
     * @param canvas
     * @param parameters required two parameters to be passed before executing the command C
     *                   all the parameters should be integer
     * @return {@link Canvas} object
     */
    @Override
    public Canvas execute(Canvas canvas, String... parameters) {
        if(validateCommand(canvas, parameters)) {
            canvas = new Canvas(Integer.valueOf(parameters[0]), Integer.valueOf(parameters[1]));
            CanvasUtil.setCanvasCoordinateArray(canvas);
            CanvasUtil.drawCanvas(canvas);
        }
        return canvas;
    }

    /**
     * Method will be called before executing the command C
     * It will validate the {@link Canvas} and parameters which are passed
     * @param canvas
     * @param parameters
     * @return true if all the conditions are passed, false if all or any of the condition failed
     */
    @Override
    public boolean validateCommand(Canvas canvas, String... parameters) {
        if(
                ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.CREATE_CANVAS.getValue(),parameters)
                && ValidationUtils.validateParameterType(parameters)
        ){
            return true;
        }
        return false;
    }
}
