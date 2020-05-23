package com.canon.base.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.canon.base.util.BaseHttpMessageConverters;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import javax.sql.DataSource;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 13:39
 * @Description:
 */
@Configuration
public class CommonConfig {

    /**
     * JSON
     * @return
     */
    //@Bean
//    public HttpMessageConverters httpMessageConverter() {
//        BaseHttpMessageConverters baseHttpMessageConverters = new BaseHttpMessageConverters();
//        HttpMessageConverter<?> converter = baseHttpMessageConverters;
//        return new HttpMessageConverters(converter);
//    }
}
