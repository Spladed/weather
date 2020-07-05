package com.heweather.utils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.heweather.dao.api.WeatherRepository;
import com.heweather.dao.api.WeatherRepositoryImp;
import com.heweather.dao.entity.City;
import com.heweather.dao.entity.CityHistoryWeather;

public class CollectWeatherData {
	
	/**
	 * @description 定时任务，每隔一小时查询一次天气并存进数据库中
	 */
	@Scheduled(cron = "0 0 14 * * ?")
	public void collect() {
		WeatherRepositoryImp weatherRepository=new WeatherRepositoryImp();
		try {
			List<City> list=weatherRepository.getCityIDList();
			for(City city:list) {
				JSONObject json=HeweatherAPI.getWeather(city.getCity_ID(), Sign.weather);		
				//取出json中now类和basic类
				JSONObject now=json.getJSONObject("now");
				JSONObject basic=json.getJSONObject("basic");
				//构造CityHistoryWeather对象，存储此时的温度、湿度和时间
				CityHistoryWeather chw=new CityHistoryWeather((String)now.get("tmp"),(String)now.get("hum"),new Timestamp(System.currentTimeMillis()));
				//向表中插入数据
				String cid=(String) basic.get("cid");
				weatherRepository.updateNewData(cid, chw);
				//查询表是否有大于7行数据。若是则删除第一行数据（即最早记录的数据）
				if(weatherRepository.getTableRows(cid)>7) {
					weatherRepository.deleteFirstRow(cid);
				}
				//添加时间延迟，防止被API禁用
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
