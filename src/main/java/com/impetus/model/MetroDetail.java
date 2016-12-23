package com.impetus.model;

public class MetroDetail {

	private String source;
	private String destination;
	private double fare;
	private String instance;
	private Boolean inCache;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public Boolean isInCache() {
		return inCache;
	}

	public void setInCache(Boolean inCache) {
		this.inCache = inCache;
	}

}
