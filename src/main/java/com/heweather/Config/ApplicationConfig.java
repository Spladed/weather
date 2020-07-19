package com.heweather.Config;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSource;

public class ApplicationConfig {

    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/weather?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("niunian052170");
        return dataSource;
    }
    
}