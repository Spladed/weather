//package com.heweather;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.heweather.utils.HeweatherAPI;
//import com.heweather.utils.Sign;
//
//@SpringBootTest
//public class APITest {
//	
//	@Test
//	public void test() {
//		String location="175.18.84.147";
//		JSONObject object=HeweatherAPI.getWeather(location, Sign.air);
//		System.out.println(object.toJSONString());
//
//	}
//	
//	@Test
//	public void tt() {
//		
//	}
//
//}
