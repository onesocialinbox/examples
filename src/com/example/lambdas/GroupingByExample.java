package com.example.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class GroupingByExample {

	private static final Long hotterThreshold = new Long(1);
	private static final Long colderThreshold = new Long(1);

	public static void main(String[] args) {
		
		List<EventData> allEvents = initializeData();
		
	/*	Map<String, List<String>> eventsBySdk =
			    allEvents
			        .stream()
			        .collect(
			            Collectors.groupingBy(
			            		EventData::getEventName,                      
			                Collectors.mapping(
			                		EventData::getThingId,
			                    Collectors.toList())));*/
		
		//printResults(eventsBySdk);
		
		Map<String, Map<String,Long>> eventsByThings = allEvents
			    .stream()
			    .collect(
			        Collectors.groupingBy(EventData::getThingId, Collectors.groupingBy(EventData::getEventName, Collectors.counting())));
			        		
			        				
		printResults1(eventsByThings);
		
		
		
		
		
	}

	private static void printResults1(Map<String, Map<String, Long>> eventsByThings) {
		
		for (Entry<String, Map<String, Long>> entry : eventsByThings.entrySet()) {
			String thingId = entry.getKey();
			//System.out.println("Key::" + thingId);
			Map<String, Long> countMap = entry.getValue();
			
			Long hotterCount = (countMap.get("hotter") != null) ? countMap.get("hotter") : new Long(0) ;
			Long colderCount = (countMap.get("colder") != null) ? countMap.get("colder") : new Long(0) ;
			
			//Logic 2
			if(hotterCount > colderCount && (hotterCount -colderCount)  >= hotterThreshold ) {
				triggerEvent(thingId, "colder");
			}
			if(colderCount > hotterCount && (colderCount-hotterCount) >= colderThreshold ) {
				triggerEvent(thingId, "hotter");
			}
			
			
			//Logic 1
			
			/*if(hotterCount != null) {
				Long colderCount = countMap.get("colder");
				if( colderCount !=null && colderCount > hotterCount) {
					triggerEvent(thingId, "colder");
				} else {
					triggerEvent(thingId, "hotter");
				}
				
			} else {
				triggerEvent(thingId, "colder");
				
			}*/
			
			
			/*for (Entry<String, Long> countEntry : countMap.entrySet()) {
				System.out.println("Count Key::" + countEntry.getKey());
				System.out.println("Count Value::"+ countEntry.getValue());
			}*/
			
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
		events.add(new EventData("1", "hotter"));
		events.add(new EventData("1", "colder"));
		events.add(new EventData("1", "colder"));
		events.add(new EventData("2", "hotter"));
		events.add(new EventData("2", "hotter"));
		events.add(new EventData("2", "colder"));
		events.add(new EventData("2", "colder"));
		events.add(new EventData("3", "hotter"));
		events.add(new EventData("3", "hotter"));
		events.add(new EventData("4", "colder"));
		events.add(new EventData("4", "hotter"));
		events.add(new EventData("4", "colder"));
		events.add(new EventData("5", "hotter"));
		
		return events;
	}
}
