package com.heweather.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.heweather.dao.entity.AirCondition;
import com.heweather.dao.entity.WeatherCondition;
import com.heweather.dao.entity.WeatherHourlyCondition;
import com.heweather.service.GetCondition;
import com.heweather.service.GetWeatherHourlyCondition;
import com.heweather.utils.GetIP;
import com.heweather.utils.Sign;


@Controller
@RequestMapping("/weather")
public class WeatherController {

	@GetMapping
	public String showWeather(Model model,HttpServletRequest request) {
		GetWeatherHourlyCondition getWeatherHourlyCondition=new GetWeatherHourlyCondition();
		String ip=GetIP.getIpInfo(request);
		WeatherCondition wc=(WeatherCondition) GetCondition.getCondition(ip, Sign.weather);
		AirCondition ac=(AirCondition) GetCondition.getCondition(ip, Sign.air);
		List<WeatherHourlyCondition> list=getWeatherHourlyCondition.getWeatherHourlyCondition(ip);
		
		model.addAttribute("weather", wc);
		model.addAttribute("air", ac);
		model.addAttribute("history",list);
		return "weather";
	}
}
