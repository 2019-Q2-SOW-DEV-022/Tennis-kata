package com.personal.kata;

import com.personal.kata.model.Player;

import java.util.stream.Stream;

public class TennisGame {
    private Player player1;
    private Player player2;
    private String gameScore;
    private static final String HYPHEN = "-";
    private static final String SAME_GAME_SCORE = "All";

    public TennisGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        gameScore = Score.LOVE + HYPHEN + SAME_GAME_SCORE;
    }

    private String getScore(int point) {
        return Stream.of(Score.values()).filter(scoreValue -> scoreValue.point == point).findFirst().map(score -> score.pointValue).orElse("");
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getGameScore() {
        if (hasScoresEqual()) {
            gameScore = getScore(player1.getPlayerScore()) + HYPHEN + SAME_GAME_SCORE;
        } else {
            gameScore = getScore(player1.getPlayerScore()) + HYPHEN + getScore(player2.getPlayerScore());
        }
        return gameScore;
    }

    private boolean hasScoresEqual() {
        return player1.getPlayerScore() == player2.getPlayerScore();
    }

    private enum Score {
        LOVE(0, "Love"),
        FIFTEEN(1, "Fifteen");

        private final int point;
        private final String pointValue;

        Score(int point, String pointValue) {
            this.point = point;
            this.pointValue = pointValue;
        }
    }
}
