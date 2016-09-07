package org.trackmanagement;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TrackConfiguration {
	
	public static List<Session> getAllSessions() {
		Session morning = new Session(LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(12, 0));
		Session afterNoon = new Session(LocalTime.of(13, 0), LocalTime.of(16, 0), LocalTime.of(17, 0));
		
		List<Session> allSessions = new ArrayList<Session>();
		allSessions.add(morning);
		allSessions.add(afterNoon);
		return allSessions;
		
	}
}
