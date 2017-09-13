package com.loca.hop.test;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.json.JSONException;

import com.loca.hop.FileReader;
import com.loca.hop.NNUtils;
import com.loca.hop.Place;

public class TestGoogleMapsReositoryControl {

	private static int NO_OF_PLACES_PER_DAY = 4;
	
	public static void main(String[] args) throws IOException, JSONException, InterruptedException {
		
		FileReader fileReader = new FileReader();
		List<String> allPlacesToHop = fileReader.getPlacesToHop("C://Users//deepa//Desktop//LocaHopperData//LocaData.txt");
		String origin = allPlacesToHop.remove(0);
		String currentPivot = origin;
		int count = 0;
		int desion = allPlacesToHop.size()/3;
		System.out.println(desion);
		Double totalDistance = 0.00;
		while(!allPlacesToHop.isEmpty()) {
			
			if(count % desion ==0) {
				currentPivot = origin;
			}
			count++;
			Place nearestToOrigin = NNUtils.getNearestPlace(currentPivot, allPlacesToHop);
			Thread.sleep(2500);
			DecimalFormat df = new DecimalFormat("0.00"); // Set your desired format here.
			String d = df.format(nearestToOrigin.getDistance()/1000.0);
			System.out.println("From : "+currentPivot +"; To : "+nearestToOrigin.getPlaceName()+"; Distance : "+ d +" km");
			totalDistance = totalDistance + Double.parseDouble(d);
			currentPivot = nearestToOrigin.getPlaceName();
			allPlacesToHop.remove(currentPivot);
			
		}
		
		System.out.println("totalDistance = "+totalDistance);
		
		
		/*List<List<Place>> choppedPlaces = GeneralUtils.chopped(nearestToOrigin, NO_OF_PLACES_PER_DAY);
		
		
		for(List<Place> placesList : choppedPlaces) {
			for(Place place : placesList) {
				Place nearestPlace = NNUtils.getNearest(currentPivot, placesList);
				System.out.println("origin="+currentPivot +" to "+ "" + nearestPlace);
				currentPivot = nearestPlace.getPlaceName();
				placesList.remove(currentPivot);
			}
		}*/
		//choppedPlaces.forEach(System.out::println);
	}
}
