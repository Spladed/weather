package com.heweather.dao.entity;

import java.sql.Timestamp;

public class CityHistoryWeather {
	
	private String tmp;			//温度
	private String hum;			//湿度
	private java.sql.Timestamp record_date;			//数据记录时间
	
	public CityHistoryWeather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CityHistoryWeather(String tmp,String hum,Timestamp record_date) {
		super();
		this.record_date=record_date;
		this.hum=hum;
		this.tmp=tmp;
	}
	
	public String getTmp() {
		return tmp;
	}
	public java.sql.Timestamp getRecord_date() {
		return record_date;
	}

	public void setRecord_date(java.sql.Timestamp record_date) {
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
		return record_date.toString().split(" ")[0];
	}

}
