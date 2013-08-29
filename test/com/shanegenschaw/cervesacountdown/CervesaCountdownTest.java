package com.shanegenschaw.cervesacountdown;

import org.junit.Test;

import com.shanegenschaw.cervezacountdown.CountdownFactory;

public class CervesaCountdownTest {

	@Test
	public void testCalculateDuration() {
		CountdownFactory t = new CountdownFactory();
		System.out.println("Duration: " + t.calculateDuration());
		
	}

}
