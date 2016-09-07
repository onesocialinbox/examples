package org.trackmanagement;

import java.util.List;

public class TrackDetail {
	
	private String trackTitle;
	private List<TrackInfo> trackInfoList;
	
	public String getTrackTitle() {
		return trackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
	public List<TrackInfo> getTrackInfoList() {
		return trackInfoList;
	}
	public void setTrackInfoList(List<TrackInfo> trackInfoList) {
		this.trackInfoList = trackInfoList;
	}
	
	

}
