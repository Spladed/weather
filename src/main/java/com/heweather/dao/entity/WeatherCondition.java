package com.heweather.dao.entity;

public class WeatherCondition {
	private String location;	//城市
	private String admin_area;	//省
	private String fl;			//体感温度
	private String tmp;			//温度（摄氏度）
	private String cond_code;	//天气状况码
	private String cond_txt;	//天气描述（阴、晴、多云等）
	private String wind_deg;	//风向360角度
	private String wind_dir;	//风向（西北、东北等描述）
	private String wind_sc;		//风力
	private String wind_spd;	//风速
	private String hum;			//相对湿度
	private String pcpn;		//降水量
	private String pres;		//大气压强
	private String vis;			//能见度
	private String cloud;		//云量
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAdmin_area() {
		return admin_area;
	}
	public void setAdmin_area(String admin_area) {
		this.admin_area = admin_area;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getTmp() {
		return tmp;
	}
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	public String getCond_code() {
		return cond_code;
	}
	public void setCond_code(String cond_code) {
		this.cond_code = cond_code;
	}
	public String getCond_txt() {
		return cond_txt;
	}
	public void setCond_txt(String cond_txt) {
		this.cond_txt = cond_txt;
	}
	public String getWind_deg() {
		return wind_deg;
	}
	public void setWind_deg(String wind_deg) {
		this.wind_deg = wind_deg;
	}
	public String getWind_dir() {
		return wind_dir;
	}
	public void setWind_dir(String wind_dir) {
		this.wind_dir = wind_dir;
	}
	public String getWind_sc() {
		return wind_sc;
	}
	public void setWind_sc(String wind_sc) {
		this.wind_sc = wind_sc;
	}
	public String getWind_spd() {
		return wind_spd;
	}
	public void setWind_spd(String wind_spd) {
		this.wind_spd = wind_spd;
	}
	public String getHum() {
		return hum;
	}
	public void setHum(String hum) {
		this.hum = hum;
	}
	public String getPcpn() {
		return pcpn;
	}
	public void setPcpn(String pcpn) {
		this.pcpn = pcpn;
	}
	public String getPres() {
		return pres;
	}
	public void setPres(String pres) {
		this.pres = pres;
	}
	public String getVis() {
		return vis;
	}
	public void setVis(String vis) {
		this.vis = vis;
	}
	public String getCloud() {
		return cloud;
	}
	public void setCloud(String cloud) {
		this.cloud = cloud;
	}
	
	
	@Override
	public String toString() {
		return "WeatherCondition [location=" + location + ", admin_area=" + admin_area + ", fl=" + fl + ", tmp=" + tmp
				+ ", cond_code=" + cond_code + ", cond_txt=" + cond_txt + ", wind_deg=" + wind_deg + ", wind_dir="
				+ wind_dir + ", wind_sc=" + wind_sc + ", wind_spd=" + wind_spd + ", hum=" + hum + ", pcpn=" + pcpn
				+ ", pres=" + pres + ", vis=" + vis + ", cloud=" + cloud + "]";
	}

}
