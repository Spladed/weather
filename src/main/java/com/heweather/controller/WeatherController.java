package com.heweather.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heweather.dao.api.WeatherRepositoryImp;
import com.heweather.dao.entity.AirCondition;
import com.heweather.dao.entity.CityHistoryWeather;
import com.heweather.dao.entity.WeatherCondition;
import com.heweather.service.GetCondition;
import com.heweather.service.GetHistoryWeather;
import com.heweather.utils.GetIP;
import com.heweather.utils.Sign;


@Controller
@RequestMapping("/weather")
public class WeatherController {

	@GetMapping
	public String showWeather(Model model,HttpServletRequest request) {
		String ip=GetIP.getIpInfo(request);
		WeatherCondition wc=(WeatherCondition) GetCondition.getCondition(ip, Sign.weather);
		AirCondition ac=(AirCondition) GetCondition.getCondition(ip, Sign.air);
		List<CityHistoryWeather> list=GetHistoryWeather.getHistoryWeatherList(ip);
		
		model.addAttribute("weather", wc);
		model.addAttribute("air", ac);
		model.addAttribute("history",list);
		return "weather";
	}
	
//	@GetMapping
//	public String showWeather(Model model) {
//		String ip="175.18.84.147";
//		WeatherCondition wc=(WeatherCondition) GetCondition.getCondition(ip, Sign.weather);
//		AirCondition ac=(AirCondition) GetCondition.getCondition(ip, Sign.air);
//		List<CityHistoryWeather> chw=GetHistoryWeather.getHistoryWeatherList(ip);
//		
//		
//		model.addAttribute("weather", wc);
//		model.addAttribute("air", ac);
//		model.addAttribute("history", chw);
//		return "weather";
//	}
}
