package com.heweather.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 天气数据API：https://free-api.heweather.net/s6/weather/{weather-type}?{parameters}
 * 获取北京实况天气
 * https://api.heweather.net/s6/weather/now?location=beijing&key=xxx
 * 空气质量数据 API：https://free-api.heweather.net/s6/air/{air-type}?{parameters}
 * 获取北京空气质量实况天气：
 * https://api.heweather.net/s6/air/now?location=beijing&key=xxx
 */
public class HeweatherAPI {
	private final static String KEY="1da3a9bcbfc94d1182042ff18a22abf5";
	
	/**
	 * @description 天气查询接口
	 * @param location 位置，内容可以为IP、城市名称、城市id等
	 * @param sign 查询的类型，weather表示天气，air表示空气质量
	 */
	public static JSONObject getWeather(String location,Sign sign) {
		String param = "key="+KEY+"&location="+location;
	    StringBuilder sb = new StringBuilder();
	    InputStream is = null;
	    BufferedReader br = null;
	    PrintWriter out = null;
	    try {
	        //接口地址
	        String url = "https://free-api.heweather.net/s6/"+sign+"/now";
	        URL uri = new URL(url);
	        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setReadTimeout(5000);
	        connection.setConnectTimeout(10000);
	        connection.setRequestProperty("accept", "*/*");
	        //发送参数
	        connection.setDoOutput(true);
	        out = new PrintWriter(connection.getOutputStream());
	        out.print(param);
	        out.flush();
	        //接收结果
	        is = connection.getInputStream();
	        br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String line;
	        //缓冲逐行读取
	        while ( ( line = br.readLine() ) != null ) {
	            sb.append(line);
	        }
	    } catch ( Exception ignored ) {
	    	System.out.println("failed");
	    } finally {
	        //关闭流
	        try {
	            if(is!=null){
	                is.close();
	            }
	            if(br!=null){
	                br.close();
	            }
	            if (out!=null){
	                out.close();
	            }
	        } catch ( Exception ignored ) {}
	    }
	    
		return handleJson(sb.toString());
	}
	
	public static JSONArray getHourly(String location) {
		String param = "key="+KEY+"&location="+location;
	    StringBuilder sb = new StringBuilder();
	    InputStream is = null;
	    BufferedReader br = null;
	    PrintWriter out = null;
	    try {
	        //接口地址
	        String url = "https://free-api.heweather.net/s6/weather/hourly";
	        URL uri = new URL(url);
	        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setReadTimeout(5000);
	        connection.setConnectTimeout(10000);
	        connection.setRequestProperty("accept", "*/*");
	        //发送参数
	        connection.setDoOutput(true);
	        out = new PrintWriter(connection.getOutputStream());
	        out.print(param);
	        out.flush();
	        //接收结果
	        is = connection.getInputStream();
	        br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String line;
	        //缓冲逐行读取
	        while ( ( line = br.readLine() ) != null ) {
	            sb.append(line);
	        }
	    } catch ( Exception ignored ) {
	    	System.out.println("failed");
	    } finally {
	        //关闭流
	        try {
	            if(is!=null){
	                is.close();
	            }
	            if(br!=null){
	                br.close();
	            }
	            if (out!=null){
	                out.close();
	            }
	        } catch ( Exception ignored ) {}
	    }
	    return handleHourlyJson(sb.toString());
	}
	
	/**
	 * @description 将String类型的json字符串转化为json对象
	 * @param jsonString 获取的String类型的json字符串
	 * @return 转化完成的json对象
	 */
	private static JSONObject handleJson(String jsonString) {
		//将字符串转换为json对象
		JSONObject weatherJSON=JSONObject.parseObject(jsonString);
		JSONArray array=weatherJSON.getJSONArray("HeWeather6");
		JSONObject json=array.getJSONObject(0);
		return json;
	}
	
	private static JSONArray handleHourlyJson(String jsonString) {
		JSONObject weatherJSON=JSONObject.parseObject(jsonString);
		JSONArray array=weatherJSON.getJSONArray("HeWeather6");
		JSONObject json=array.getJSONObject(0);
		JSONArray hourly=json.getJSONArray("hourly");
		return hourly;
	}

}
