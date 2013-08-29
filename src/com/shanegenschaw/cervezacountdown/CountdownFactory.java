package com.shanegenschaw.cervezacountdown;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

public class CountdownFactory {
	
	private static final DateTime mexico = DateTime.parse("2013-10-24T06:50:00.000-05:00");
	
	public static Duration getDuration() {
		return new Duration(DateTime.now(), mexico);
	}
	
	public static Countdown durationToCountdown(Duration d) {
		Days days = d.toStandardDays();
		d = d.minus(days.toStandardDuration());
		Hours hours = d.toStandardHours();
		d = d.minus(hours.toStandardDuration());
		Minutes minutes = d.toStandardMinutes();
		d = d.minus(minutes.toStandardDuration());
		Seconds seconds = d.toStandardSeconds();
		Countdown countdown = new Countdown(days.getDays(), hours.getHours(), minutes.getMinutes(), seconds.getSeconds());
		return countdown;
	}
	
}
