package com.personal.kata;

import java.io.PrintStream;
import java.util.Scanner;

public class PlayTennis {

    private static final String WELCOME_MESSAGE = "Welcome! Lets Play Tennis";
    private static final String PROMPT_FOR_PLAYER1_NAME = "Please enter Player One name: ";
    private static final String PROMPT_FOR_PLAYER2_NAME = "Please enter Player Two name: ";

    private PlayTennis() {
    }

    public static TennisGame launch(PrintStream out) {
        out.println(WELCOME_MESSAGE);
        out.println(PROMPT_FOR_PLAYER1_NAME);
        Scanner inputFromConsole = new Scanner(System.in);
        String player1Name = inputFromConsole.nextLine();
        out.println(PROMPT_FOR_PLAYER2_NAME);
        String player2Name = inputFromConsole.nextLine();
        TennisGame tennisGame = new TennisGame(player1Name, player2Name);
        return tennisGame;
    }
}
