package com.canon.base.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/11 10:41
 * @Description:
 */
@Configuration
public class DruidConfig {

    // 解决 spring.datasource.filters=stat,wall,log4j 无法正常注册
    @Bean
    @Primary // 在同样的DataSource中，首先使用被标注的DataSource
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        // 使用工厂构建druidDataSource对象
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * init jdbcTemplate
     * @return
     */
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }


    //配置Druid的监控
    //1. 配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean =  new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<String,String>();

        initParams.put("loginUsername","admin");//账号
        initParams.put("loginPassword","12345");//密码
        initParams.put("allow","");//默认允许所有
        // initParams.put("deny","192.168.123.22");//不允许的黑名单ip

        bean.setInitParameters(initParams);
        return bean;
    }

    // 2. 配置一个监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<String,String>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
