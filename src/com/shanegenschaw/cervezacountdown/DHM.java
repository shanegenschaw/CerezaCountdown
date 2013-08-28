package com.shanegenschaw.cervezacountdown;

public class DHM {
	
	private final int days;
	private final int hours;
	private final int minutes;
	
	public DHM(final int days, final int hours, final int minutes) {
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public String toText() {
		return "" + days + " days, " + hours + " hours, " + minutes + " minutes";
	}

}
