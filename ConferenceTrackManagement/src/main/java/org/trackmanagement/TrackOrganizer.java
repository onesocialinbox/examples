package org.trackmanagement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TrackOrganizer {
	
	public Map<String, List<Conference>> organizeTracks(List<Conference> conferences) {
		
		/*LocalTime morningStartTime = LocalTime.of(9, 0);
		LocalTime morningEndTime = LocalTime.of(12, 0);
		LocalTime eveningStartTime = LocalTime.of(13, 0);
		LocalTime eveningEndTime = LocalTime.of(16, 0);
		*/
		LocalTime trackEndTime = LocalTime.of(17, 0);
		
		List<TrackInfo> trackInfoList = new ArrayList<TrackInfo>();
		
		List<Session> allSessions = TrackConfiguration.getAllSessions();
		
		
		while(!allSlotsBooked(conferences)) {
			for (Session session : allSessions) {
				LocalTime currentTrackTime = session.getStartTime();
				LocalTime currentCutOffTime = session.getEndTime();
				
				for (Conference conference : conferences) {
					LocalTime time = currentTrackTime.plusMinutes(conference.getConferenceDuration());
					//long timeDiff = Duration.between(currentTrackTime, currentCutOffTime).toMinutes();
					if(currentTrackTime.compareTo(currentCutOffTime) < 0 ) {
						if(time.compareTo(currentCutOffTime) <=0) {
							TrackInfo trackInfo = new TrackInfo(currentTrackTime, conference);
							trackInfoList.add(trackInfo);
							conference.setFoundSlot(true);
							currentTrackTime = time;
						} else {
							
						}
					} else  {
						//currentCutOffTime = 
					}
				}	
			}
			
			
		}
		
		while(!allSlotsBooked(conferences)) {
			
		}
		
		
		
		
		return null;
	}

	private boolean allSlotsBooked(List<Conference> conferences) {
		boolean allMatch = conferences.stream().allMatch(conference -> conference.isFoundSlot());
		System.out.println("all match" + allMatch);
		return false;
	}

}
