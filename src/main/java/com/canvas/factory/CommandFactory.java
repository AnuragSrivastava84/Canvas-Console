package com.canvas.factory;

import com.canvas.ICommand;
import com.canvas.commands.*;
import com.canvas.constants.CommandType;

/**
 * <h1>Command Factory</h1>
 * Command factory class is used to provide
 * the instance of the commands which is required
 * to execute the respective commands like B, C, L, Q, R and so on.
 */
public class CommandFactory {

    public static ICommand getCommand(CommandType commandType){
        switch (commandType){
            case B:
                return new CommandB();
            case C:
                return new CommandC();
            case L:
                return new CommandL();
            case Q:
                return new CommandQ();
            case R:
                return new CommandR();
            default:
               System.out.println("Executing Wrong Command");
               return null;
        }
    }
}
