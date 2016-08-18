package com.assignment.bowlinggame;

import org.junit.Assert;
import org.junit.Test;

import com.assignment.bowlinggame.BowlingGame;

public class BowlingGameTest {

	@Test
	public void itShouldReturnScoreForHittingPinsWithoutSpareOrStrike() {
		String gameStats = "12345123451234512345";
		BowlingGame bowlingGame = new BowlingGame(gameStats);
		bowlingGame.createFrames();
		int actualScore = bowlingGame.getScore();
		Assert.assertEquals(actualScore, 60);
	}

	@Test
	public void itShouldReturnScoreForHittingPinsWithSpare() {
		String gameStats = "5/5/5/5/5/5/5/5/5/5/5";
		BowlingGame bowlingGame = new BowlingGame(gameStats);
		bowlingGame.createFrames();
		int actualScore = bowlingGame.getScore();
		Assert.assertEquals(actualScore, 150);
	}

	@Test
	public void itShouldReturnScoreForHittingPinsWithStrike() {
		String gameStats = "XXXXXXXXXXXX";
		BowlingGame bowlingGame = new BowlingGame(gameStats);
		bowlingGame.createFrames();
		int actualScore = bowlingGame.getScore();
		Assert.assertEquals(actualScore, 300);
	}

	@Test
	public void itShouldReturnScoreForHittingPinsWithNullTurn() {
		String gameStats = "9-9-9-9-9-9-9-9-9-9-";
		BowlingGame bowlingGame = new BowlingGame(gameStats);
		bowlingGame.createFrames();
		int actualScore = bowlingGame.getScore();
		Assert.assertEquals(actualScore, 90);
	}
}
