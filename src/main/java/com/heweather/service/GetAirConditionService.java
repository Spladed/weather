package com.heweather.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.heweather.dao.entity.AirCondition;
import com.heweather.utils.HeweatherAPI;
import com.heweather.utils.Sign;

public class GetAirConditionService {
	private AirCondition ac;
	
	/**
	 * @description 获取IP地址所在城市的空气质量
	 * @param ip 客户端的IP地址
	 * @return 客户端所在地区的空气质量
	 */
	public AirCondition getAirCondition(String ip) {
		JSONObject json=HeweatherAPI.getWeather(ip, Sign.air);
		
		//取出json中air_now_city类
		JSONObject air_now_city=json.getJSONObject("air_now_city");
		//取出json中basic类
		JSONObject basic=json.getJSONObject("basic");
		
		//将basic中的位置信息加入到air_now_city中
		air_now_city.put("location", basic.get("location"));
		air_now_city.put("admin_area", basic.get("admin_area"));
		
		//生成AirCondition对象
		ac=JSONObject.parseObject(air_now_city.toJSONString(), AirCondition.class);
		return ac;
	}
}
