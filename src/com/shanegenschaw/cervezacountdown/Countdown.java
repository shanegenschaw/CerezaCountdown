package com.shanegenschaw.cervezacountdown;

public class Countdown {
	
	private final int days;
	private final int hours;
	private final int minutes;
	private final int seconds;
	
	public Countdown(final int days, final int hours, final int minutes, final int seconds) {
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public int getDays() {
		return days;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public String toText() {
		return "" + days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds";
	}

}
