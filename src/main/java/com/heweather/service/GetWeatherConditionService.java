package com.heweather.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.heweather.dao.entity.WeatherCondition;
import com.heweather.utils.HeweatherAPI;
import com.heweather.utils.Sign;

public class GetWeatherConditionService {
	private WeatherCondition wc;
	
	/**
	 * @description 用来获取IP地址所对应的城市的天气情况
	 * @param ip 客户端的IP地址
	 * @return WeatherCondition类型的对象，保存了客户端所在城市的天气情况
	 */
	public WeatherCondition getWeatherCondition(String ip) {
		//获取天气的json字符串
		JSONObject json=HeweatherAPI.getWeather(ip, Sign.weather);
		
		//取出json中now类
		JSONObject now=json.getJSONObject("now");
		//取出json中basic类
		JSONObject basic=json.getJSONObject("basic");
		
		//将basic中的位置信息加入到now中
		now.put("location", basic.get("location"));
		now.put("admin_area", basic.get("admin_area"));
		
		//生成WeatherCondition对象
		wc=JSONObject.parseObject(now.toJSONString(), WeatherCondition.class);
		return wc;
	}
}
