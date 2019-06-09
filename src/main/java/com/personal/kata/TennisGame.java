package com.personal.kata;

import com.personal.kata.model.Player;

public class TennisGame {
    private Player player1;
    private Player player2;
    private String gameScore;
    private static final String HYPHEN = "-";
    private static final String SAME_GAME_SCORE = "All";
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";

    public TennisGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        gameScore = LOVE + HYPHEN + SAME_GAME_SCORE;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getGameScore() {
        String player1GameScore = LOVE;
        String player2GameScore = LOVE;

        if (player1.getPlayerScore() == 1) {
            player1GameScore = FIFTEEN;
        }

        if (player2.getPlayerScore() == 1) {
            player2GameScore = FIFTEEN;
        }

        gameScore = player1GameScore + HYPHEN + player2GameScore;

        if (player1.getPlayerScore() == player2.getPlayerScore()) {
            if (player1.getPlayerScore() == 0) {
                gameScore = player1GameScore + HYPHEN + SAME_GAME_SCORE;
            } else if (player1.getPlayerScore() == 1) {
                gameScore = player2GameScore + HYPHEN + SAME_GAME_SCORE;
            }
        }
        return gameScore;
    }
}
