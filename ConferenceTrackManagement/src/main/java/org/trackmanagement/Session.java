package org.trackmanagement;

import java.time.LocalTime;

public class Session {
	
	private LocalTime startTime = LocalTime.of(9, 0);
	private LocalTime endTime = LocalTime.of(12, 0);
	
	public Session(LocalTime startTime, LocalTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

}
