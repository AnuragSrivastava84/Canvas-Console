package com.canvas.commands;

import com.canvas.ICommand;
import com.canvas.constants.CommandParameterLengthConstant;
import com.canvas.model.Canvas;
import com.canvas.shape.IShape;
import com.canvas.shape.impl.Rectangle;
import com.canvas.util.CanvasUtil;
import com.canvas.util.ValidationUtils;

/**
 * <h1>Command R</h1>
 * Implementation class for {@link ICommand} interface
 * It provides the implementation of the methods which are executed
 * while executing the command R
 *
 * <h2>Methods</h2>
 * {@link #execute(Canvas, String...)}, {@link #validateCommand(Canvas, String...)}
 */
public class CommandR implements ICommand {

    /**
     * Method will be called when command R will be called
     * it is used to draw the rectangle with in the canvas
     * @param canvas
     * @param parameters required four parameters to be passed before executing the command R
     *                   all the parameters should be integer
     * @return {@link Canvas} object
     */
    @Override
    public Canvas execute(Canvas canvas, String... parameters) {
        if(validateCommand(canvas, parameters)) {
            IShape shape = new Rectangle();
            shape.setCanvasCoordinate(canvas, parameters);
            CanvasUtil.drawCanvas(canvas);
        }
        return canvas;
    }


    /**
     * Method will be called before executing the command R
     * It will validate the {@link Canvas} and parameters which are passed
     * @param canvas
     * @param parameters
     * @return true if all the conditions are passed, false if all or any of the condition failed
     */
    @Override
    public boolean validateCommand(Canvas canvas, String... parameters) {
        if(
                ValidationUtils.validateCanvasExist(canvas)
                && ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.RECTANGLE.getValue(), parameters)
                && ValidationUtils.validateParameterType(parameters)
                && ValidationUtils.validateLRParameterWithInCanvas(canvas, parameters)
                && validateParameterRange(parameters)
        ){
            return true;
        }
        return false;
    }


    /**
     * Method is used to validate whether the parameter passed are valid
     * to draw the rectangle or not
     * @param parameters
     * @return true if the parameters are valid to draw the rectangle otherwise false
     */
    private boolean validateParameterRange(String... parameters){
        int x1 = Integer.valueOf(parameters[0]);
        int y1 = Integer.valueOf(parameters[1]);
        int x2 = Integer.valueOf(parameters[2]);
        int y2 = Integer.valueOf(parameters[3]);

        if(x1 < x2 && y1 < y2){
            return true;
        }
        System.out.println("Invalid Parameters : Can't Draw The Shape");
        return false;
    }

}
