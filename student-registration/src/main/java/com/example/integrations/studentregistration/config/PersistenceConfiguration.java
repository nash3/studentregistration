package com.example.integrations.studentregistration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    public static final String LOCAL_JDBC_TEMPLATE = "localJdbcTemplate";

    @Bean()
    @SuppressWarnings("ContextJavaBeanUnresolvedMethodsInspection")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = LOCAL_JDBC_TEMPLATE)
    public NamedParameterJdbcTemplate jdbcTemplate()
    {
        return new NamedParameterJdbcTemplate(dataSource());
    }
}
