package org.trackmanagement;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConferenceTrackApp {

	private static final String FILE_DELIMIT = ",";

	public static void main(String[] args) {

		List<Conference> conferences = readConferencesFromFile();

		TrackOrganizer trackOrganizer = new TrackOrganizer();
		List<TrackInfo> organizeTracks = trackOrganizer.organizeTracks(conferences);
		//printOutput(organizeTracks);

	}

	private static void printOutput(List<TrackInfo> organizeTracks) {
		for (TrackInfo trackInfo : organizeTracks) {
			System.out.println(trackInfo.getTrackStartTime() + "= " + trackInfo.getConference().getConferenceTitle()
					+ " = " + trackInfo.getConference().getConferenceDuration());
		}

	}

	private static List<Conference> readConferencesFromFile() {

		List<Conference> conferences = new ArrayList<Conference>();

		try {
			List<String> lines = Files.readAllLines(new File("src/main/resources/input2.txt").toPath(),
					Charset.defaultCharset());

			for (String line : lines) {
				String[] tracksAndMinutes = line.split(FILE_DELIMIT);
				int trackDuration = 0;
				if ("lightning".equalsIgnoreCase(tracksAndMinutes[1])) {
					trackDuration = 5;
				} else {
					trackDuration = Integer.parseInt(tracksAndMinutes[1]);
				}
				conferences.add(new Conference(tracksAndMinutes[0], trackDuration));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return conferences;
	}

}
