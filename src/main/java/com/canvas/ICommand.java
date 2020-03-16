package com.canvas;

import com.canvas.model.Canvas;

/**
 * Command interface describes the operations performed by the command
 * <h2></>Implementation classes</h2>
 * {@link com.canvas.commands.CommandB},{@link com.canvas.commands.CommandC},
 * {@link com.canvas.commands.CommandL}, {@link com.canvas.commands.CommandQ},
 * {@link com.canvas.commands.CommandR}
 *
 * <h2>Methods</h2>
 * {@link #execute(Canvas, String...)}, {@link #validateCommand(Canvas, String...)}
 *
 */
public interface ICommand {

    /**
     * Perform the operation which required to return the desired output
     * while executing the commands
     * @param canvas
     * @param parameters
     * @return the {@link Canvas} class object after executing the command
     */
    Canvas execute(Canvas canvas, String... parameters);

    /**
     * Validate the canvas and parameters which are required before executing the command
     * @param canvas
     * @param parameters
     * @return true if all the conditions are passed or false if all or any of the condition is failed
     */
    boolean validateCommand(Canvas canvas, String... parameters);
}
