package com.canvas.constants;

/**
 * <h1>CommandParameterLengthConstant</h1>
 * Provides the values for the number of the parameters
 * which is required to execute any command like B, C, L, Q,and R
 */
public enum CommandParameterLengthConstant {
    CREATE_CANVAS(2),
    FILL_BUCKET(3),
    LINE(4),
    RECTANGLE(4),
    QUIT(0);

    private int value;

    CommandParameterLengthConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
