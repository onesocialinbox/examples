package com.example.lambdas;

public class EventData {
	
	private String thingId;
	private String eventName;
	
	
	public EventData(String thingId, String eventName) {
		this.thingId = thingId;
		this.eventName = eventName;
	}
	public String getThingId() {
		return thingId;
	}
	public void setThingId(String thingId) {
		this.thingId = thingId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
}
