package com.example.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class GroupingByExample {

	private static final Long hotterThreshold = new Long(3);
	private static final Long colderThreshold = new Long(3);

	private static final String[] list = {"hotter", "colder"}; 
	
	public static void main(String[] args) {
		
		List<EventData> allEvents = initializeData();
		
		
		Map<String, Map<String,Long>> eventsByThings = allEvents
			    .stream()
			    .collect(
			        Collectors.groupingBy(EventData::getThingId, Collectors.groupingBy(EventData::getEventName, Collectors.counting())));
			        		
		
		printAllEvents(allEvents);
		
		System.out.println("===========================================================");
		//printResults1(eventsByThings);
		readConfig(eventsByThings);
	}

	private static void printAllEvents(List<EventData> allEvents) {
		for(EventData event : allEvents)
			System.out.println("ThingId:  " + event.getThingId() + "  ====" + " EventName:" + event.getEventName());
	}

	private static void printResults1(Map<String, Map<String, Long>> eventsByThings) {
		
		for (Entry<String, Map<String, Long>> entry : eventsByThings.entrySet()) {
			String thingId = entry.getKey();
			//System.out.println("Key::" + thingId);
			Map<String, Long> countMap = entry.getValue();
			
			Long hotterCount = (countMap.get("hotter") != null) ? countMap.get("hotter") : new Long(0) ;
			Long colderCount = (countMap.get("colder") != null) ? countMap.get("colder") : new Long(0) ;
			
			//Logic 2
			analyzeAndTriggerEvent(thingId, hotterCount, colderCount);
			
		}
		
	}

	private static void analyzeAndTriggerEvent(String fanId, Long hotterCount, Long colderCount) {
		if(hotterCount > colderCount && (hotterCount -colderCount)  >= hotterThreshold ) {
			triggerEvent(fanId, "hotter");
		}
		if(colderCount > hotterCount && (colderCount-hotterCount) >= colderThreshold ) {
			triggerEvent(fanId, "colder");
		}
	}
	
	private static void readConfig(Map<String, Map<String, Long>> eventsByThings) {
		String config = "1&2:1,3&4:2,5&6:3,7:4,8:5,9&10:6";
		String[] pairSplit = StringUtils.split(config, ",");
		
		for(String pair : pairSplit){
			String[] xdkFanSplit = StringUtils.split(pair, ":");
			String fansCombo = xdkFanSplit[0];
			String[] xdkThingIds = StringUtils.split(fansCombo, "&");
			Long hotterCount = new Long(0);
			Long colderCount = new Long(0);
			for(String xdkId: xdkThingIds){
				Map<String, Long> countMap = eventsByThings.get(xdkId);
				if(countMap !=null) {
					hotterCount = hotterCount + ((countMap.get("hotter") != null) ? countMap.get("hotter") : new Long(0)) ;
					colderCount = colderCount + ((countMap.get("colder") != null) ? countMap.get("colder") : new Long(0)) ;
				}
			}
			analyzeAndTriggerEvent(xdkFanSplit[1], hotterCount, colderCount);
		}
		
		
	}

	private static void triggerEvent(String thingId, String message) {
		System.out.println("ThingId::"+ thingId +  " Message::" + message);
	}

	private static void printResults(Map<String, List<String>> eventsBySdk) {
			
		for (Entry<String, List<String>> entry : eventsBySdk.entrySet()) {
			System.out.println("Key::" + entry.getKey());
			System.out.println("Value::"+ entry.getValue());
		}
	}

	private static List<EventData> initializeData() {
		List<EventData> events = new ArrayList<EventData>();
		
		int randomNumber = getRandomNumber(30, 1);
		for(int i = 0; i< randomNumber; i++) {
			EventData event = createRandomEvent();
			events.add(event);
			
		}
		return events;
	}

	private static EventData createRandomEvent() {
		
		Random r= new Random();

		int thingId = getRandomNumber(5, 1);
		
		String eventName = list[r.nextInt(list.length)];
		
		return new EventData(Integer.toString(thingId), eventName);
		
		
	}

	private static int getRandomNumber(int max, int min) {
		Random random= new Random();
		int thingId = random.nextInt(max - min + 1) + min;
		return thingId;
	}
}
