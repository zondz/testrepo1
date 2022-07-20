package com.nt.rookie.post.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan(basePackages = "com.nt.rookie.post")
public class AppConfig {

  @Bean
  public DataSource h2DataSource() {
    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScripts("tables.sql", "data.sql").build();
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource h2DataSource) {
    return new JdbcTemplate(h2DataSource);
  }
}
