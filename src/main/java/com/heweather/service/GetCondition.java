package com.heweather.service;

import org.springframework.stereotype.Service;

import com.heweather.utils.Sign;

public class GetCondition {

	/**
	 * @description 根据sign分别调用服务
	 * @param ip 客户端IP
	 * @param sign 用于识别调用的是天气服务还是空气质量服务
	 * @return sign对应的查询类型对象
	 */
	public static Object getCondition(String ip,Sign sign) {
		Object o=null;
		if(sign==Sign.air) 
			return o=(new GetAirConditionService()).getAirCondition(ip);
		else if(sign==Sign.weather)
			return o=(new GetWeatherConditionService()).getWeatherCondition(ip);
		return o;
	}
}
