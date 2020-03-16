package com.canvas;


import com.canvas.constants.CommandType;
import com.canvas.factory.CommandFactory;
import com.canvas.model.Canvas;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Canvas Main Class </h1>
 * CanvasMainClass is the main class which will be called
 * when canvas app executes
 * */
public class CanvasMainClass
{
    public static void main( String[] args )
    {
        ICommand command;
        Canvas canvas = null;
        printInstruction();
        while (true){
            System.out.print("canvas>");
            Scanner scanner = new Scanner(System.in);
            String[] commandStringArray = scanner.nextLine().trim().split(" ");
            String commandType = commandStringArray[0];
            String[] parameters = Arrays.copyOfRange(commandStringArray,1,commandStringArray.length);
            if(!StringUtils.isEmpty(commandType)){
                switch (commandType.toUpperCase()){
                    case "B":
                        command = CommandFactory.getCommand(CommandType.B);
                        canvas = command.execute(canvas, parameters);
                        break;
                    case "C" :
                        command = CommandFactory.getCommand(CommandType.C);
                        canvas = command.execute(canvas, parameters);
                        break;
                    case "L" :
                        command = CommandFactory.getCommand(CommandType.L);
                        canvas = command.execute(canvas, parameters);
                        break;
                    case "R" :
                        command = CommandFactory.getCommand(CommandType.R);
                        canvas = command.execute(canvas, parameters);
                        break;
                    case "Q" :
                        command = CommandFactory.getCommand(CommandType.Q);
                        boolean status = command.validateCommand(canvas,parameters);
                        if(status){
                            command.execute(canvas, parameters);
                            scanner.close();
                            return;
                        }
                        break;
                    default:
                        CommandFactory.getCommand(CommandType.X);
                        break;
                }
            }
        }
    }

    /**
     * This method prints only the details of the canvas app
     * like the instruction for the commands and so on
     */
    public static void printInstruction(){
        System.out.println("*****************************************************************************************************************************************");
        System.out.println("********************************************************   CANVAS-CONSOLE   *************************************************************");
        System.out.println("*****************************************************************************************************************************************");
        System.out.println("Simple console version of a drawing program");
        System.out.println("Which allows to create canvas and drawing on the canvas");
        System.out.println("The set of commands which can be executed by the program are listed below:");
        System.out.println("\t C w h : Create the canvas of width w and height");
        System.out.println("\t L x1 y1 x2 y2 : Create a new line from (x1,y1) to (x2,y2) using character x");
        System.out.println("\t R x1 y1 x2 y2 : Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2) using character x");
        System.out.println("\t B x y c : fill the entire area connected to (x,y) with the character c");
        System.out.println("\t Q : Quite the program");
        System.out.println("******************************************************************************************************************************************");
    }
}
