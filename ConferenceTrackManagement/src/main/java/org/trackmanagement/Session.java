package org.trackmanagement;

import java.time.LocalTime;

public class Session {
	
	private LocalTime startTime;
	private LocalTime endTime;
	
	private LocalTime maxiumumCutOffTime;
	
	public Session(LocalTime startTime, LocalTime endTime, LocalTime maxiumumCutOffTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxiumumCutOffTime= maxiumumCutOffTime;
		
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
	public LocalTime getMaxiumumCutOffTime() {
		return maxiumumCutOffTime;
	}
	public void setMaxiumumCutOffTime(LocalTime maxiumumCutOffTime) {
		this.maxiumumCutOffTime = maxiumumCutOffTime;
	}
	

}
