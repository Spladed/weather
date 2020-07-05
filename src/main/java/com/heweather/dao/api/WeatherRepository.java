package com.heweather.dao.api;

import java.util.List;

import com.heweather.dao.entity.City;
import com.heweather.dao.entity.CityHistoryWeather;

public interface WeatherRepository {
	
	public List<City> getCityIDList();
	
	public void updateNewData(String cityID,CityHistoryWeather chw);
	
	public int getTableRows(String cityID);
	
	public void deleteFirstRow(String cityID);
	
	public List<CityHistoryWeather> getHistoryWeather(String cityID);

}
