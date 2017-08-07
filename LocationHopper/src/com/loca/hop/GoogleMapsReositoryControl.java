package com.loca.hop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class GoogleMapsReositoryControl {

	private String origins;
	private String destinations;

	public String getOrigins() {
		return origins;
	}

	public void setOrigins(String origins) {
		this.origins = origins;
	}

	public String getDestinations() {
		return destinations;
	}

	public void setDestinations(String destinations) {
		this.destinations = destinations;
	}

	public JSONArray distancematrix() throws IOException, JSONException {

		String encodedUrl = null;
		String uri = "origins="+origins+"&destinations="+destinations;
		encodedUrl = uri.replace(" ", "%20");
		
		URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?"+encodedUrl);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		String line, outputString = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = reader.readLine()) != null) {
			outputString += line;
		}
		//System.out.println(outputString);
		
		JSONObject jsonObject = new org.json.JSONObject(outputString);
	    // routesArray contains ALL routes
	    JSONArray rows = jsonObject.getJSONArray("rows");  

	    rows.length();
	    JSONObject elements = rows.getJSONObject(0);
	    
	    JSONArray ele = elements.getJSONArray("elements");
	    
		return ele;
	}
}
