package org.trackmanagement;

public class Conference {
	
	private String conferenceTitle;
	private int conferenceDuration;
	private boolean foundSlot = false;
	
	public Conference(String conferenceTitle, int conferenceDuration) {
		this.conferenceTitle = conferenceTitle;
		this.conferenceDuration = conferenceDuration;
	}
	public String getConferenceTitle() {
		return conferenceTitle;
	}
	public void setConferenceTitle(String conferenceTitle) {
		this.conferenceTitle = conferenceTitle;
	}
	public int getConferenceDuration() {
		return conferenceDuration;
	}
	public void setConferenceDuration(int conferenceDuration) {
		this.conferenceDuration = conferenceDuration;
	}
	public boolean isFoundSlot() {
		return foundSlot;
	}
	public void setFoundSlot(boolean foundSlot) {
		this.foundSlot = foundSlot;
	}
	

}
