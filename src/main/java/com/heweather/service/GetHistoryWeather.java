package com.heweather.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.heweather.dao.api.WeatherRepositoryImp;
import com.heweather.dao.entity.CityHistoryWeather;
import com.heweather.utils.HeweatherAPI;
import com.heweather.utils.Sign;

public class GetHistoryWeather {
	
	public static List<CityHistoryWeather> getHistoryWeatherList(String ip){
		WeatherRepositoryImp weatherRepository=new WeatherRepositoryImp();
		JSONObject json=HeweatherAPI.getWeather(ip, Sign.weather);		
		//取出json中now类
		JSONObject basic=json.getJSONObject("basic");
		String cid=(String) basic.get("cid");
		return weatherRepository.getHistoryWeather(cid);
	}

}
