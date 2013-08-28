package com.shanegenschaw.cervesacountdown;

import static org.junit.Assert.fail;

import org.joda.time.DateTime;
import org.junit.Test;

import com.shanegenschaw.cervezacountdown.CervesaCountdown;

public class CervesaCountdownTest {

	@Test
	public void testCalculateDaysLeft() {
		CervesaCountdown t = new CervesaCountdown();
		int days = t.calculateDaysLeft();
		System.out.println("Days: " + days);
		DateTime now = DateTime.now();
		DateTime mexico = now.plusDays(days);
		System.out.println("Date: " + mexico);
		
	}

	@Test
	public void testCalculateDuration() {
		CervesaCountdown t = new CervesaCountdown();
		System.out.println("Duration: " + t.calculateDuration());
		
	}

}
