package com.personal.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        PlayTennis.launch(printStream);

        String console = new String(outputStream.toByteArray());
        String[] consoleLines = console.split(System.getProperty("line.separator"));
        assertEquals("Welcome! Lets Play Tennis", consoleLines[0]);
    }
}
