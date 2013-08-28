package com.shanegenschaw.cervezacountdown;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Minutes;

public class CervesaCountdown {
	
	public int calculateDaysLeft() {
		DateTime now = DateTime.now().withTimeAtStartOfDay();
		DateTime mexico = DateTime.parse("2013-10-24");
		Days days = Days.daysBetween(now, mexico);
		return days.getDays();
	}
	
	public String calculateDuration() {
		DateTime now = DateTime.now();
		DateTime mexico = DateTime.parse("2013-10-24T06:50:00.000-05:00");
		Duration d = new Duration(now, mexico);
		
		Days days = d.toStandardDays();
		d = d.minus(days.toStandardDuration());
		Hours hours = d.toStandardHours();
		d = d.minus(hours.toStandardDuration());
		Minutes minutes = d.toStandardMinutes();
		DHM dhm = new DHM(days.getDays(), hours.getHours(), minutes.getMinutes());
		return dhm.toText();
	}

}
