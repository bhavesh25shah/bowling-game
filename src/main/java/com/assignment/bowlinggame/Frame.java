package com.assignment.bowlinggame;

public class Frame {
	private String turn1;
	private String turn2;
	private boolean isStrike;
	private boolean isSpare;

	public Frame(String turn1, String turn2) {
		this.turn1 = turn1;
		this.turn2 = turn2;
	}

	public int getScore() {
		return calculateScore();
	}

	private int calculateScore() {
		int score = 0;
		if (turn1 != null && turn1.equals("X")) {
			score = 10;
		} else if (turn2 != null && turn2.equals("/")) {
			score = Integer.parseInt(turn1);
		} else {
			int temp = turn1 == null ? 0 : turn1.equals("-") ? 0 : Integer.parseInt(turn1);
			temp += turn2 == null ? 0 : turn2.equals("-") ? 0 : Integer.parseInt(turn2);
			score = temp;
		}
		return score;
	}

	public void setStrikeOrSpareHit(String turn) {
		if (turn.equals("X")) {
			isStrike = true;
		} else if (turn.equals("/")) {
			isSpare = true;
		}
	}

	public boolean isStrike() {
		return isStrike;
	}

	public boolean isSpare() {
		return isSpare;
	}
}
