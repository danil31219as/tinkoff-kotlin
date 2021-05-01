package com.example.demo.configuration


import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource
import org.springframework.jdbc.datasource.DriverManagerDataSource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment


@Configuration
class SpringConfig() {
    @Bean
    fun dataSource(): DataSource {
        val dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url("jdbc:sqlite:actions.db");
        return dataSourceBuilder.build();
    }
}

