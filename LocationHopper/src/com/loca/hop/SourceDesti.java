package com.loca.hop;

public class SourceDesti {

	private String source;
	private String sourceFull;
	private String destination;
	private String destinationFull;
	private Integer distance;
	private int time;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSourceFull() {
		return sourceFull;
	}
	public void setSourceFull(String sourceFull) {
		this.sourceFull = sourceFull;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDestinationFull() {
		return destinationFull;
	}
	public void setDestinationFull(String destinationFull) {
		this.destinationFull = destinationFull;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distance;
		result = prime * result + time;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceDesti other = (SourceDesti) obj;
		if (distance != other.distance)
			return false;
		if (time != other.time)
			return false;
		return true;
	}
	public int compareTo(Integer anotherDistance) {
		return distance.compareTo(anotherDistance);
	}
	
	
}
