package com.loca.hop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {

	public static void main(String[] args) throws IOException {
		
		FileReader fileReader = new FileReader();
		fileReader.getPlacesToHop("C://Users//deepa//Desktop//LocaHopperData//LocaData.txt");
		
		URL url = new URL(
				"https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC|Seattle&destinations=San+Francisco|Victoria+BC");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		String line, outputString = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = reader.readLine()) != null) {
			outputString += line;
		}
		System.out.println(outputString);
		
		
	}
}
