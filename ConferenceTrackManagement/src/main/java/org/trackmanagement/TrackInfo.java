package org.trackmanagement;

import java.time.LocalTime;

public class TrackInfo {

	private LocalTime trackStartTime;
	private Conference conference;
	
	public TrackInfo(LocalTime trackStartTime, Conference conference) {
		this.trackStartTime = trackStartTime;
		this.conference = conference;
	}
	public LocalTime getTrackStartTime() {
		return trackStartTime;
	}
	public void setTrackStartTime(LocalTime trackStartTime) {
		this.trackStartTime = trackStartTime;
	}
	public Conference getConference() {
		return conference;
	}
	public void setConference(Conference conference) {
		this.conference = conference;
	}
	
	
}
