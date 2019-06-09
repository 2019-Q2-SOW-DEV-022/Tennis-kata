package com.personal.kata;

import java.io.PrintStream;

public class PlayTennis {

    private static final String WELCOME_MESSAGE = "Welcome! Lets Play Tennis";
    private static final String PROMPT_FOR_PLAYER1_NAME = "Please enter Player One name: ";

    private PlayTennis() {
    }

    public static void launch(PrintStream out) {
        out.println(WELCOME_MESSAGE);
        out.println(PROMPT_FOR_PLAYER1_NAME);
    }
}
