package com.assignment.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private String gameStats;
	private final int NUMBER_OF_FRAMES = 10;
	private List<Frame> frames;

	public BowlingGame(String gameStats) {
		this.gameStats = gameStats;
		this.frames = new ArrayList<Frame>();
	}

	public List<Frame> createFrames() {
		int index = 0;
		char[] stats = gameStats.toCharArray();
		int i = index;
		while (i < stats.length) {
			if (stats.length - i == 1) {
				frames.add(createFrame(String.valueOf(stats[i]), null));
				i++;
			} else if (stats[i] == 'X') {
				frames.add(createFrame("X", null));
				i++;
			} else if (stats[i] == '/') {
				frames.add(createFrame(String.valueOf(stats[i]), "/"));
				i += 2;
			} else {
				frames.add(createFrame(String.valueOf(stats[i]), String.valueOf(stats[i + 1])));
				i += 2;
			}
		}
		return frames;
	}

	private Frame createFrame(String turn1, String turn2) {
		Frame frame = new Frame(turn1, turn2);
		if ((turn1 != null && turn1.equals("X"))) {
			frame.setStrikeOrSpareHit(turn1);
		}
		if (turn2 != null && turn2.equals("/")) {
			frame.setStrikeOrSpareHit(turn2);
		}
		return frame;
	}

	public int getScore() {
		int score = 0;
		int cnt = 0;
		for (Frame eachFrame : frames) {
			if (cnt < NUMBER_OF_FRAMES) {
				if (eachFrame.isStrike()) {
					score += 10 + frames.get(cnt + 1).getScore() + frames.get(cnt + 2).getScore();
				} else if (eachFrame.isSpare()) {
					score += 10 + frames.get(cnt + 1).getScore();
				} else {
					score += eachFrame.getScore();
				}
				cnt++;
			}
		}
		return score;
	}

}
