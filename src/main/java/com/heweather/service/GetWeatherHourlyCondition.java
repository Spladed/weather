package com.heweather.service;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.dao.entity.WeatherHourlyCondition;
import com.heweather.utils.HeweatherAPI;

public class GetWeatherHourlyCondition {
	
	public List<WeatherHourlyCondition> getWeatherHourlyCondition(String ip){
		List<WeatherHourlyCondition> list=new LinkedList<WeatherHourlyCondition>();		
		JSONArray jsonArray=HeweatherAPI.getHourly(ip);
		for(int i=0;i<7;i++) {
			WeatherHourlyCondition weatherHourlyCondition=new WeatherHourlyCondition();
			JSONObject object=(JSONObject) jsonArray.get(i);
			weatherHourlyCondition.setHum(object.getString("hum"));
			weatherHourlyCondition.setTmp(object.getString("tmp"));
			weatherHourlyCondition.setRecord_date(object.getString("time"));
			list.add(weatherHourlyCondition);
		}
		
		return list;
	}
}
