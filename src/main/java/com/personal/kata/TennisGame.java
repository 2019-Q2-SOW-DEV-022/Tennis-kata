package com.personal.kata;

import com.personal.kata.model.Player;

import java.util.stream.Stream;

public class TennisGame {
    private static final String DEUCE_GAME_SCORE = "Deuce";
    private static final int ONE_POINT = 1;
    private static final String GAME_SCORE_ADVANTAGE = " Advantage";
    private static final String GAME_SCORE_WINS = " Wins";
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
            if (isPointEqualToForty()) {
                gameScore = DEUCE_GAME_SCORE;
            } else {
                gameScore = getScore(player1.getPlayerScore()) + HYPHEN + SAME_GAME_SCORE;
            }
        } else if (isAnyPlayerCanWin()) {
            gameScore = isAnyPlayerLeadByOnePoint() ? getTopPlayerName() + GAME_SCORE_ADVANTAGE : getTopPlayerName() + GAME_SCORE_WINS;
        } else {
            gameScore = getScore(player1.getPlayerScore()) + HYPHEN + getScore(player2.getPlayerScore());
        }
        return gameScore;
    }

    private boolean hasScoresEqual() {
        return player1.getPlayerScore() == player2.getPlayerScore();
    }

    private boolean isAnyPlayerCanWin() {
        return player1.getPlayerScore() > Score.FORTY.point || player2.getPlayerScore() > Score.FORTY.point;
    }

    private boolean isPointEqualToForty() {
        return player1.getPlayerScore() == Score.FORTY.point;
    }

    private String getTopPlayerName() {
        return player1.getPlayerScore() > player2.getPlayerScore() ? player1.getPlayerName() : player2.getPlayerName();
    }

    private boolean isAnyPlayerLeadByOnePoint() {
        return ONE_POINT == Math.abs(player1.getPlayerScore() - player2.getPlayerScore());
    }

    private enum Score {
        LOVE(0, "Love"),
        FIFTEEN(1, "Fifteen"),
        THIRTY(2, "Thirty"),
        FORTY(3, "Forty");

        private final int point;
        private final String pointValue;

        Score(int point, String pointValue) {
            this.point = point;
            this.pointValue = pointValue;
        }
    }
}
