package com.personal.kata;

import com.personal.kata.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    TennisGame tennisGame;

    @BeforeEach
    public void newGameSetup() {
        tennisGame = new TennisGame();
    }

    @Test
    @DisplayName("Given a tennis game When tennis game starts Then the two players scores are at zero each")
    public void test_NewGameState_ShouldHaveTwoPlayerScores_AtZeroEach() {

        assertEquals(0, tennisGame.getPlayer1().getPlayerScore());
        assertEquals(0, tennisGame.getPlayer2().getPlayerScore());
    }

    @Test
    @DisplayName("Given a tennis game When tennis game starts Then there should be two players named Player 1 and Player 2")
    public void test_NewGameState_ShouldHaveTwoPlayerNames_Player1_Player2() {

        assertEquals("Player 1", tennisGame.getPlayer1().getPlayerName());
        assertEquals("Player 2", tennisGame.getPlayer2().getPlayerName());
    }

    @Test
    @DisplayName("Given a tennis game started When Player1 scores a point Then the score of Player1 should increase by one point")
    public void test_GameInProgress_Player1Scores_ShouldIncreaseScoreOfPlayer1() {

        scoreWinsByPlayer(tennisGame.getPlayer1(), 1);

        assertPointsScoredByPlayers(1, 0);
    }

    @Test
    @DisplayName("Given a tennis game started When Player1 scores two points Then the score of Player1 should increase by two points")
    public void test_GameInProgress_Player1ScoresTwoPoints_ShouldIncreaseScoreOfPlayer1ByTwoPoints() {

        scoreWinsByPlayer(tennisGame.getPlayer1(), 2);

        assertPointsScoredByPlayers(2, 0);
    }

    @Test
    @DisplayName("Given a tennis game When tennis game starts Then the game score is Love-All")
    public void test_NewGameState_ShouldHaveGameScore_LoveAll() {

        assertEquals("Love-All", tennisGame.getGameScore());
    }

    @Test
    @DisplayName("Given a tennis game started When Player1 scores a point Then the game score is Fifteen-Love")
    public void test_GameInProgress_Player1ScoresOnce_ShouldHaveGameScore_FifteenLove() {

        scoreWinsByPlayer(tennisGame.getPlayer1(), 1);

        assertEquals("Fifteen-Love", tennisGame.getGameScore());
    }

    @Test
    @DisplayName("Given a tennis game started When Player 1 scores a point and Player 2 scores a point Then the game score is Fifteen-All")
    public void test_GameInProgress_Player1ScoresOnce_Player2ScoresOnce_ShouldHaveGameScore_FifteenAll() {

        scoreWinsByPlayer(tennisGame.getPlayer1(), 1);
        scoreWinsByPlayer(tennisGame.getPlayer2(), 1);

        assertEquals("Fifteen-All", tennisGame.getGameScore());
    }

    private void scoreWinsByPlayer(Player player, int totalWins) {
        for (int ball = 1; ball <= totalWins; ball++) {
            player.scorePoint();
        }
    }

    private void assertPointsScoredByPlayers(int player1Score, int player2Score) {
        assertEquals(player1Score, tennisGame.getPlayer1().getPlayerScore());
        assertEquals(player2Score, tennisGame.getPlayer2().getPlayerScore());
    }

}
