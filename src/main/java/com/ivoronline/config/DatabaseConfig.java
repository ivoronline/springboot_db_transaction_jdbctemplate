package com.ivoronline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com")
public class DatabaseConfig {

  //PROPERTIES
  @Autowired DataSource dataSource;

  //=========================================================================================================
  // DATA SOURCE
  //=========================================================================================================
  //@Bean
  //public DataSource dataSource() {
  //    return new DriverManagerDataSource("jdbc:oracle:thin:@localhost:1522/orcl", "TEST", "LETMEIN");
  //}

  //=========================================================================================================
  // SINGLE CONNECTION DATA SOURCE
  //=========================================================================================================
  @Bean
  public DataSource dataSource() {
    SingleConnectionDataSource  dataSource = new SingleConnectionDataSource();
                                dataSource.setUrl     ("jdbc:oracle:thin:@localhost:1522/orcl");
                                dataSource.setUsername("TEST");
                                dataSource.setPassword("LETMEIN");
    return dataSource;
  }

  //=========================================================================================================
  // JDBC TEMPLATE
  //=========================================================================================================
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(this.dataSource);
  }

}
