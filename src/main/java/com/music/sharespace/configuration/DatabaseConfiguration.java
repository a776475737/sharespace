package com.music.sharespace.configuration;

import com.zaxxer.hikari.HikariDataSource;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("file:../props/application.properties")
public class DatabaseConfiguration {

    @Autowired
    private Environment env;

    //@Bean
    //public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(final DataSource dataSource){
    //    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    //    localContainerEntityManagerFactoryBean.setDataSource(dataSource);

    //    return localContainerEntityManagerFactoryBean;
    //}

    @Bean
    public DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("mysql.driver"));
        dataSource.setJdbcUrl(env.getProperty("mysql.jdbcUrl"));
        dataSource.setUsername(env.getProperty("mysql.username"));
        dataSource.setPassword(env.getProperty("mysql.password"));
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        dataSource.setDataSourceProperties(properties);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
