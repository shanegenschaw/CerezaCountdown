package com.shanegenschaw.cervezacountdown;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

public class CountdownFactory {
	
    private static final DateTime mexico = DateTime.parse("2013-10-24T13:50:00.000-05:00");
	
	public static Duration getDuration() {
		return new Duration(DateTime.now(), mexico);
	}
	
	public static Countdown durationToCountdown(final Duration d) {
        Duration left = d;
        final Days days = left.toStandardDays();
        left = left.minus(days.toStandardDuration());
        final Hours hours = left.toStandardHours();
        left = left.minus(hours.toStandardDuration());
        final Minutes minutes = left.toStandardMinutes();
        left = left.minus(minutes.toStandardDuration());
        final Seconds seconds = left.toStandardSeconds();
		final Countdown countdown = new Countdown(days.getDays(), hours.getHours(), minutes.getMinutes(), seconds.getSeconds());
		return countdown;
	}
	
}
