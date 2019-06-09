package com.personal.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTennisTest {

    ByteArrayOutputStream outputStream;
    PrintStream printStream;

    @BeforeEach
    public void newGameSetup() {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
    }

    @Test
    @DisplayName("Given tennis application is available When the tennis application is launched Then a welcome message is displayed")
    public void test_TennisApplicationIsLaunched_ShouldDisplayWelcomeMessage() {

        inputLinesToConsole();
        PlayTennis.launch(printStream);

        assertConsoleLines("Welcome! Lets Play Tennis", 0);
    }

    @Test
    @DisplayName("Given tennis application is available When the tennis application is launched Then after the welcome message it prompts to enter first player name ")
    public void test_TennisApplicationIsLaunched_AfterWelcomeMessage_ShouldPromptForFirstPlayerName() {

        inputLinesToConsole();
        PlayTennis.launch(printStream);

        assertConsoleLines("Please enter Player One name: ", 1);
    }

    @Test
    @DisplayName("Given tennis application is launched When the prompt to enter Player one name is displayed and entered Then the entered player name is set as Player 1 name")
    public void test_TennisApplicationLaunched_AfterPlayer1NamePrompt_ShouldAssignEntryToFirstPlayerName() {

        inputLinesToConsole();
        TennisGame tennisGame = PlayTennis.launch(printStream);

        assertEquals("Rob", tennisGame.getPlayer1().getPlayerName());
    }

    @Test
    @DisplayName("Given tennis application is launched When the player 1 name is entered Then it prompts to enter second player name ")
    public void test_TennisApplicationIsLaunched_AfterPlayer1NameEntered_ShouldPromptForSecondPlayerName() {

        inputLinesToConsole();
        TennisGame tennisGame = PlayTennis.launch(printStream);

        assertConsoleLines("Please enter Player Two name: ", 2);
    }


    private void assertConsoleLines(String content, int lineNumber) {
        String console = new String(outputStream.toByteArray());
        String[] consoleLines = console.split(System.getProperty("line.separator"));
        assertEquals(content, consoleLines[lineNumber]);
    }

    private void inputLinesToConsole() {
        String consoleInput = "Rob" + System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
    }
}
