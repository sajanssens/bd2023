package com.example.timer;

import java.util.Calendar;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class AutomaticTimer {

	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
	public void printTime() {
		System.out.println("AutomaticTimer current time: " + Calendar.getInstance().getTime());
	}
}
