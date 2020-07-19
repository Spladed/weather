package com.heweather.dao.entity;

import java.sql.Timestamp;

public class WeatherHourlyCondition {
	private String tmp;			//温度
	private String hum;			//湿度
	private String record_date;			//数据记录时间
	
	public WeatherHourlyCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WeatherHourlyCondition(String tmp,String hum,String record_date) {
		super();
		this.record_date=record_date;
		this.hum=hum;
		this.tmp=tmp;
	}
	
	public String getTmp() {
		return tmp;
	}
	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	public String getHum() {
		return hum;
	}
	public void setHum(String hum) {
		this.hum = hum;
	}
	
	public String getStringDate() {
		return record_date.toString().split(" ")[1];
	}
}
