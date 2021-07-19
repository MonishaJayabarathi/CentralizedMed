package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Layer {

  public ResultSet getUserDetails(String username,String user_type) throws ClassNotFoundException, IOException, SQLException {

    String sqlStmt;
    if(user_type.equals("Doctor")){ sqlStmt = "SELECT * FROM doctor_info where emailId =?;";}
    else{ sqlStmt = "SELECT * FROM patient_info where emailId =?;";}

    ResultSet currentDoctorDetails;
    DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
    Connection c = one.createConnection();



    PreparedStatement prepStmt = c.prepareStatement(sqlStmt);
    prepStmt.toString();

    prepStmt.setString(1, username);

    currentDoctorDetails = prepStmt.executeQuery();

    return currentDoctorDetails;
  }


}
