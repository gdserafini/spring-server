package com.gdserafini.spring_server.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    @Bean
    public DataSource dataSource(){
        var config = new HikariConfig();

        config.setJdbcUrl(this.url);
        config.setUsername(this.username);
        config.setPassword(this.password);
        config.setDriverClassName(this.driver);
        /*
         * Min and max pool size configuration
         * Can be changed as the application size increase
         */
        config.setPoolName("server-pool");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(1); 
        config.setMaxLifetime(1800000);

        //Heath check configuration
        config.setConnectionTimeout(5000);
        config.setConnectionTestQuery("SELECT 1;");

        return new HikariDataSource(config);
    }

}
