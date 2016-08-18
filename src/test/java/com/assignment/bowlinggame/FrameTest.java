package com.assignment.bowlinggame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameTest {

	Frame frame;

	@Before
	public void init() {
		frame = new Frame("8", "/");
		frame.setStrikeOrSpareHit("/");
	}

	@Test
	public void testGetScore() {
		int actualScore = frame.getScore();
		Assert.assertEquals(8, actualScore);
	}

	@Test
	public void testIsStrike() {
		Assert.assertEquals(true, frame.isSpare());
	}

	@Test
	public void testIsSpare() {
		Assert.assertEquals(false, frame.isStrike());
	}

}
