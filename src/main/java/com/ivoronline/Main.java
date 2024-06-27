package com.ivoronline;

import com.ivoronline.config.DatabaseConfig;
import com.ivoronline.service.MyService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {

      ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
                                     context.registerShutdownHook();

      MyService personService = context.getBean("myService", MyService.class);
                personService.insertRecords();

      context.close();

  }

}