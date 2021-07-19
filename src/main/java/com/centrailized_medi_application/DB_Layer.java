package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Layer {

  public ResultSet getDcotorDetails(String doctorUsername) throws ClassNotFoundException, IOException, SQLException {

    ResultSet currentDoctorDetails;
    DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
    Connection c = one.createConnection();

    String sqlStmt = "SELECT * FROM doctor_info where emailId =?";

    PreparedStatement prepStmt = c.prepareStatement(sqlStmt);
    prepStmt.toString();
    prepStmt.setString(1, doctorUsername);
    currentDoctorDetails = prepStmt.executeQuery();

    return currentDoctorDetails;
  }


}
