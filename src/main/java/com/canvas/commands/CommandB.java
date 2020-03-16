package com.canvas.commands;

import com.canvas.ICommand;
import com.canvas.constants.CommandParameterLengthConstant;
import com.canvas.model.Canvas;
import com.canvas.shape.IShape;
import com.canvas.shape.impl.Bucket;
import com.canvas.util.CanvasUtil;
import com.canvas.util.ValidationUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * <h1>Command B</h1>
 * Implementation class for {@link ICommand} interface
 * It provides the implementation of the methods which are executed
 * while executing the command B
 *
 * <h2>Methods</h2>
 * {@link #execute(Canvas, String...)}, {@link #validateCommand(Canvas, String...)}
 */
public class CommandB implements ICommand {

    /**
     * Method will be called when command B will be called
     * it is used to fill the canvas with third parameter
     * @param canvas
     * @param parameters required three parameters to be passed before executing the command B
     *                   first two should be integer, the third argument can be string or character
     *                   which is used to fill the canvas
     * @return {@link Canvas} object
     */
    @Override
    public Canvas execute(Canvas canvas, String... parameters) {
        if(validateCommand(canvas,parameters)) {
            IShape shape = new Bucket();
            shape.setCanvasCoordinate(canvas, parameters);
            CanvasUtil.drawCanvas(canvas);
        }
        return canvas;
    }

    /**
     * Method will be called before executing the command B
     * It will validate the {@link Canvas} and parameters which are passed
     * @param canvas
     * @param parameters
     * @return true if all the conditions are passed, false if all or any of the condition failed
     */
    @Override
    public boolean validateCommand(Canvas canvas, String... parameters) {
        if(ValidationUtils.validateCanvasExist(canvas)
                && ValidationUtils.validateNumberOfParameter(CommandParameterLengthConstant.FILL_BUCKET.getValue(), parameters)
                && ValidationUtils.validateParameterType(ArrayUtils.remove(parameters,parameters.length-1))
                && validateParameterWithInCanvas(canvas, parameters)){
            return true;
        }
        return false;
    }

    /**
     * Method is used to validate whether the parameter passed are with in the canvas or not
     * @param canvas
     * @param parameters
     * @return true if the parameters are with in the canvas otherwise false
     */
    private boolean validateParameterWithInCanvas(Canvas canvas, String... parameters){
        int width = Integer.valueOf(parameters[0]);
        int height = Integer.valueOf(parameters[1]);

        String[][] canvasCoordinates = canvas.getCanvasCoordinateArray();
        if(
                width >= 1
                && width <= canvasCoordinates[0].length-2
                && height >= 1
                && height <= canvasCoordinates.length-2
        ){
            return true;
        }
        System.out.println("Parameters Are Outside The Canvas Width Or Height Range");
        return false;
    }
}
