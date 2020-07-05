package com.heweather.dao.api;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.heweather.Config.ApplicationConfig;
import com.heweather.dao.entity.City;
import com.heweather.dao.entity.CityHistoryWeather;

/**
 * @author Splade
 * @description 数据库处理器。主要功能：获取城市ID列表\向数据表中插入数据\获取表中数据的行数\删除数据表中的第一行数据\获取数据表中的所有数据
 */

public class WeatherRepositoryImp implements WeatherRepository{
	
	public WeatherRepositoryImp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<City> getCityIDList(){
		ApplicationConfig applicationConfig=new ApplicationConfig();
	    DataSource dataSource = applicationConfig.getDataSource();
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from city";
		List<City> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(City.class));
		return list;
	}
	
	@Override
	public void updateNewData(String cityID,CityHistoryWeather chw) {
		ApplicationConfig applicationConfig=new ApplicationConfig();
	    DataSource dataSource = applicationConfig.getDataSource();
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="insert into "+cityID.toLowerCase()+" (tmp,hum,record_date) values ("+chw.getTmp()+","+chw.getHum()+","+chw.getRecord_date()+")";
		jdbcTemplate.update(sql);
	}

	@Override
	public int getTableRows(String cityID) {
		ApplicationConfig applicationConfig=new ApplicationConfig();
	    DataSource dataSource = applicationConfig.getDataSource();
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT COUNT(*) FROM "+cityID.toLowerCase();
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}

	@Override
	public void deleteFirstRow(String cityID) {
		ApplicationConfig applicationConfig=new ApplicationConfig();
	    DataSource dataSource = applicationConfig.getDataSource();
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from "+cityID.toLowerCase()+" limit 1";
		jdbcTemplate.update(sql);
	}

	@Override
	public List<CityHistoryWeather> getHistoryWeather(String cityID) {
		ApplicationConfig applicationConfig=new ApplicationConfig();
	    DataSource dataSource = applicationConfig.getDataSource();
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from "+cityID.toLowerCase();
		List<CityHistoryWeather> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(CityHistoryWeather.class));
		return list;
	}

}
