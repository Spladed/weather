package com.heweather.dao.entity;

public class AirCondition {
	private String location;	//城市
	private String admin_area;	//省
	private String aqi;			//空气污染指数
	private String main;		//主要污染物
	private String qlty;		//空气质量（优、良、轻度污染、中度污染、重度污染、严重污染）
	private String pm10;		//pm10
	private String pm25;		//pm25
	private String no2;			//二氧化氮
	private String so2;			//二氧化硫
	private String co;			//一氧化碳
	private String o3;			//臭氧
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAdminArea() {
		return admin_area;
	}
	public void setAdminArea(String admin_area) {
		this.admin_area = admin_area;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getQlty() {
		return qlty;
	}
	public void setQlty(String qlty) {
		this.qlty = qlty;
	}
	public String getPm10() {
		return pm10;
	}
	public void setPm10(String pm10) {
		this.pm10 = pm10;
	}
	public String getPm25() {
		return pm25;
	}
	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	public String getNo2() {
		return no2;
	}
	public void setNo2(String no2) {
		this.no2 = no2;
	}
	public String getSo2() {
		return so2;
	}
	public void setSo2(String so2) {
		this.so2 = so2;
	}
	public String getCo() {
		return co;
	}
	public void setCo(String co) {
		this.co = co;
	}
	public String getO3() {
		return o3;
	}
	public void setO3(String o3) {
		this.o3 = o3;
	}
	@Override
	public String toString() {
		return "AirCondition [location=" + location + ", admin_area=" + admin_area + ", aqi=" + aqi + ", main=" + main
				+ ", qlty=" + qlty + ", pm10=" + pm10 + ", pm25=" + pm25 + ", no2=" + no2 + ", so2=" + so2 + ", co="
				+ co + ", o3=" + o3 + "]";
	}
	
}
