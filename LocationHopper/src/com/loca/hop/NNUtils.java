package com.loca.hop;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NNUtils {

	public static Place getNearest(String source, List<Place> destinationOPlaces) throws IOException, JSONException{
		Place destinationPlace = new Place();
		Map<String,Integer> destinationsMap = new HashMap<>();
		List<String> destinations = destinationOPlaces.stream().map(places -> places.getPlaceName()).collect(Collectors.toList());
		GoogleMapsReositoryControl googleMapsReositoryControl = new GoogleMapsReositoryControl();
		googleMapsReositoryControl.setOrigins(source);
		googleMapsReositoryControl.setDestinations(String.join("|", destinations));
		
		JSONArray elements = googleMapsReositoryControl.distancematrix();
		for(int i=0; i<elements.length(); i++) {
	    	JSONObject element =elements.getJSONObject(i);
		    JSONObject distance= element.getJSONObject("distance");
		    
		    if(i<elements.length()) {
		    	Integer dist = (Integer) distance.get("value");
		    	String dest = destinations.get(i);
		    	
		    	destinationsMap.put( dest, dist);
		    }
	    }
		
		Map<String, Integer> result = destinationsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		if(null != result && !result.isEmpty()) {
			destinationPlace.setDistance(result.entrySet().stream().findFirst().get().getValue());
			destinationPlace.setPlaceName(result.entrySet().stream().findFirst().get().getKey());
		}
		
		return destinationPlace;
	}
	
	public static Place getNearestPlace(String source, List<String> destinationOPlaces) throws IOException, JSONException{
		Place destinationPlace = new Place();
		Map<String,Integer> destinationsMap = new HashMap<>();
		//List<String> destinations = destinationOPlaces.stream().map(places -> places.getPlaceName()).collect(Collectors.toList());
		GoogleMapsReositoryControl googleMapsReositoryControl = new GoogleMapsReositoryControl();
		googleMapsReositoryControl.setOrigins(source);
		googleMapsReositoryControl.setDestinations(String.join("|", destinationOPlaces));
		
		JSONArray elements = googleMapsReositoryControl.distancematrix();
		for(int i=0; i<elements.length(); i++) {
	    	JSONObject element =elements.getJSONObject(i);
		    JSONObject distance= element.getJSONObject("distance");
		    
		    if(i<elements.length()) {
		    	Integer dist = (Integer) distance.get("value");
		    	String dest = destinationOPlaces.get(i);
		    	
		    	destinationsMap.put( dest, dist);
		    }
	    }
		
		Map<String, Integer> result = destinationsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		if(null != result && !result.isEmpty()) {
			destinationPlace.setDistance(result.entrySet().stream().findFirst().get().getValue());
			destinationPlace.setPlaceName(result.entrySet().stream().findFirst().get().getKey());
		}
		
		return destinationPlace;
	}
	
	public static List<Place> getAllNearest(String source, List<String> destinations) throws IOException, JSONException{
		List<Place> nearestPlaces = new LinkedList<>();
		
		Map<String,Integer> destinationsMap = new HashMap<>();
		
		GoogleMapsReositoryControl googleMapsReositoryControl = new GoogleMapsReositoryControl();
		googleMapsReositoryControl.setOrigins(source);
		googleMapsReositoryControl.setDestinations(String.join("|", destinations));
		
		JSONArray elements = googleMapsReositoryControl.distancematrix();
		for(int i=0; i<elements.length(); i++) {
	    	JSONObject element =elements.getJSONObject(i);
		    JSONObject distance= element.getJSONObject("distance");
		    
		    if(i<elements.length()) {
		    	Integer dist = (Integer) distance.get("value");
		    	String dest = destinations.get(i);
		    	
		    	destinationsMap.put( dest, dist);
		    }
	    }
		
		Map<String, Integer> result = destinationsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		if(null != result && !result.isEmpty()) {
			result.forEach((key, value) -> {
				Place destinationPlace = new Place();
				destinationPlace.setDistance(value);
				destinationPlace.setPlaceName(key);
				nearestPlaces.add(destinationPlace);
			});
		}
		
		return nearestPlaces;
	}
	
	
}
