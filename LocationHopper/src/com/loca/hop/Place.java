package com.loca.hop;

public class Place {

	private String placeName;
	private Integer distance;

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Place [placeName=" + placeName + ", distance=" + distance + "]";
	}

}
