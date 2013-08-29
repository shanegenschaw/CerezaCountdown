package com.shanegenschaw.cervesacountdown;

import org.joda.time.Duration;
import org.junit.Test;

import com.shanegenschaw.cervezacountdown.Countdown;
import com.shanegenschaw.cervezacountdown.CountdownFactory;

public class CervesaCountdownTest {

	@Test
	public void testCalculateDuration() {
		CountdownFactory t = new CountdownFactory();
		Duration d = CountdownFactory.getDuration();
		Countdown cd = CountdownFactory.durationToCountdown(d);
		System.out.println("Duration: " + cd.toText());
		
	}

}
