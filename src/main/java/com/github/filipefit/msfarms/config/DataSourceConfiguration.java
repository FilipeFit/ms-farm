package com.github.filipefit.msfarms.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration extends HikariConfig {

    @Bean
    @FlywayDataSource
    public DataSource dataSource(Environment environment){
        this.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        this.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        this.setUsername(environment.getProperty("spring.datasource.username"));
        this.setPassword(environment.getProperty("spring.datasource.password"));
        return new HikariDataSource(this);
    }
}
