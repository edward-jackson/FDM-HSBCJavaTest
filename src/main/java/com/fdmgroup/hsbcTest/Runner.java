package com.fdmgroup.hsbcTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Runner {

	public static Location[] readLocationsFromJson(URL url) {

		ObjectMapper mapper = new ObjectMapper();

		Location[] locations;
		
		try {
			JsonNode jsonNode = mapper.readValue(url, JsonNode.class);
			JsonNode locationNode = jsonNode.get("list");
			locations = mapper.treeToValue(locationNode, Location[].class);
			return locations;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<String> getLocationsBeginningWithT(List<Location> locations) {
		List<String> locationsStartingWithT = new ArrayList<String>();
		for (Location location : locations) {
			String locationName = location.getName();
			char[] nameChars = locationName.toCharArray();
			if (nameChars[0] == 84 || nameChars[0] == 116) {
				locationsStartingWithT.add(locationName);
			}
		}
		return locationsStartingWithT;
	}

	public static void writeLine(String line, String file) {

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		String filename = "C:\\Users\\Ed\\eclipse-workspace\\FDM-HSBCJavaTest\\names_log.txt";

		try {
			URL url = new URL(
					"https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22");
			Location[] locations = readLocationsFromJson(url);
			List<Location> locationList = new ArrayList<Location>(Arrays.asList(locations));
			List<String> namesBeginningWithT = getLocationsBeginningWithT(locationList);
			
			for (String name : namesBeginningWithT) {
				writeLine(name, filename);
			}
			
			Integer numberOfNames = namesBeginningWithT.size();
			writeLine(numberOfNames.toString(), filename);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
