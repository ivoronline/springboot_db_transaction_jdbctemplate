package com.ivoronline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private MyRepository repository;
  @Autowired private DataSource   dataSource;

  //=========================================================================================================
  // INSERT RECORDS
  //=========================================================================================================
  public void insertRecords() throws SQLException {

    //GET DB CONNECTION
    Connection connection = dataSource.getConnection();

    //TRANSACTION
    try {

      //START TRANSACTION
      connection.setAutoCommit(false);

      //EXECUTE SQL STATEMENTS
      for (int i = 1; i <= 2; i++) {
        if(i==2) { throw new Exception("Exception"); }
        repository.insert("Person " + i, 10 * i);
      }

      //COMMIT TRANSACTION
      connection.commit();

    } catch (Exception e) {
      //ROLLBACK TRANSACTION
      connection.rollback();   //throws java.sql.SQLRecoverableException
    }
    finally {
      connection.close();
    }

  }

}
