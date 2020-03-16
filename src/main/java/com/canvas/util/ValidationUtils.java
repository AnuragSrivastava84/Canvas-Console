package com.canvas.util;

import com.canvas.model.Canvas;

/**
 * <h1>ValidationUtils class</h1>
 * Provides the utility methods which are commonly required
 * for validating the canvas and parameters before executing
 * the commands
 *
 * <h2>Methods</h2>
 * {@link #validateCanvasExist(Canvas)}
 * {@link #validateLRParameterWithInCanvas(Canvas, String...)}
 * {@link #validateNumberOfParameter(int, String...)}
 * {@link #validateParameterType(String...)}
 */
public class ValidationUtils {

    /**
     * Validates the number of parameters before executing the command
     * @param expectedParameterLength
     * @param parameters
     * @return true if parameter length is same as expected, otherwise false
     */
    public static boolean validateNumberOfParameter(int expectedParameterLength, String... parameters) {
        if(parameters.length == expectedParameterLength){
            return true;
        }
        System.out.println("Invalid Number Of Parameters");
        return false;
    }

    /**
     * Validate the type of the parameters
     * It checks whether parameter can be converted into an integer or not
     * @param parameters
     * @return true if parameters can be converted into the integer, otherwise false
     */
    public static boolean validateParameterType(String... parameters) {
        try{
            for(String parameter : parameters){
                Integer.valueOf(parameter);
            }
            return true;
        }catch (NumberFormatException e){
            System.out.println("Invalid Parameter Type");
            return false;
        }
    }

    /**
     * Validates the parameters only for command L and R
     * To check whether the parameter lies with in the canvas or not
     * @param canvas
     * @param parameters
     * @return true if parameter lies with in canvas, otherwise false
     */
    public static boolean validateLRParameterWithInCanvas(Canvas canvas, String... parameters) {

        int width1 = Integer.valueOf(parameters[0]);
        int width2 = Integer.valueOf(parameters[2]);

        int height1 = Integer.valueOf(parameters[1]);
        int height2 = Integer.valueOf(parameters[3]);


        String[][] canvasCoordinateArray = canvas.getCanvasCoordinateArray();
        if(
                height1 >= 1
                && height1 <= canvasCoordinateArray.length-2
                && height2 >=1
                && height2 <= canvasCoordinateArray.length-2
                && width1 >=1
                && width1 <= canvasCoordinateArray[0].length-2
                && width2 >=1
                && width2 <= canvasCoordinateArray[0].length-2
        ){
            return true;
        }
        System.out.println("Parameters Are Outside The Canvas Width Or Height Range");
        return false;
    }


    /**
     * Checks whether canvas is exiting or not
     * @param canvas
     * @return true if canvas exists, otherwise false
     */
    public static boolean validateCanvasExist(Canvas canvas){
        if(null != canvas){
            return true;
        }
        System.out.println("Canvas Does Not Exist");
        return false;
    }


}
