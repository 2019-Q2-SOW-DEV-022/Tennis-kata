package com.personal.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTennisTest {

    private static final String NEW_LINE = System.getProperty("line.separator");
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

    @Test
    @DisplayName("Given tennis application is launched When the prompt to enter Player two name is displayed and entered Then the entered player name is set as Player 2 name")
    public void test_TennisApplicationLaunched_AfterPlayer2NamePrompt_ShouldAssignEntryToSecondPlayerName() {

        inputLinesToConsole();
        TennisGame tennisGame = PlayTennis.launch(printStream);

        assertEquals("Bob", tennisGame.getPlayer2().getPlayerName());
    }

    @Test
    @DisplayName("Given tennis application is launched When the player names are entered Then the Game Starts message is displayed")
    public void test_TennisApplicationLaunched_AfterPlayer2NameEntered_ShouldDisplayGameStartsMessage() {

        inputLinesToConsole();
        TennisGame tennisGame = PlayTennis.launch(printStream);

        assertConsoleLines("Game Starts Now!!", 3);
    }

    @Test
    @DisplayName("Given tennis application is launched When the Game Starts message is displayed Then the Playing instructions is displayed")
    public void test_TennisApplicationLaunched_AfterPlayingInstructions_ShouldDisplayPlayingInstructions() {

        inputLinesToConsole();
        TennisGame tennisGame = PlayTennis.launch(printStream);

        assertConsoleLines("Please enter who won this Ball, Press [1]: Rob / [2]: Bob Or Press [C] to stop playing", 4);
    }

    @Test
    @DisplayName("Given tennis application is launched When the Playing instructions are displayed and C is pressed Then the game terminates with Game over message")
    public void test_TennisApplicationLaunched_AfterPlayingInstructions_KeyToCancelIsPressed_ShouldTerminateGame() {
        String consoleInput = "Rob" + NEW_LINE + "Bob" + NEW_LINE + "C";

        inputThisLineToConsole(consoleInput);
        TennisGame tennisGame = PlayTennis.launch(printStream);

        assertConsoleLines("Game Over !!", 5);
    }

    private void assertConsoleLines(String content, int lineNumber) {
        String console = new String(outputStream.toByteArray());
        String[] consoleLines = console.split(NEW_LINE);
        assertEquals(content, consoleLines[lineNumber]);
    }

    private void inputLinesToConsole() {
        String consoleInput = "Rob" + NEW_LINE + "Bob" + NEW_LINE + "C";
        inputThisLineToConsole(consoleInput);
    }

    private void inputThisLineToConsole(String consoleInput) {
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
    }
}
