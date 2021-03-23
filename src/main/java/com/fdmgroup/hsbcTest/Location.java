package com.fdmgroup.hsbcTest;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "dt", "wind", "rain", "clouds", "weather" })
public class Location {

	private int id;
	private String name;
	private Map<String, Double> coords;
	private Map<String, Double> cityInfo;

	@JsonCreator()
	public Location(@JsonProperty("id") int id, @JsonProperty("name") String name,
			@JsonProperty("coord") Map<String, Double> coords, @JsonProperty("main") Map<String, Double> cityInfo) {
		super();
		this.id = id;
		this.name = name;
		this.coords = coords;
		this.cityInfo = cityInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Double> getCoords() {
		return coords;
	}

	public void setCoords(Map<String, Double> coords) {
		this.coords = coords;
	}

	public Map<String, Double> getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(Map<String, Double> cityInfo) {
		this.cityInfo = cityInfo;
	}

}
