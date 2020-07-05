package com.heweather.dao.entity;

public class City {
	
	private String City_ID;		//城市ID
	
	public City() {
		super();
	}
	public City(String city_ID) {
		super();
		City_ID = city_ID;
	}
	public String getCity_ID() {
		return City_ID;
	}
	public void setCity_ID(String city_ID) {
		City_ID = city_ID;
	}
}
