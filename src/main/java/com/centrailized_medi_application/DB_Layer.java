package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DB_Layer {
String environment="src/main/resources/config_test.properties";
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

  public void insertConsultations(String docter_user_name, String p_name, DateTimeFormatter consultation_date, LocalDateTime current_time) throws SQLException, IOException, ClassNotFoundException {
      DB_Connection db_access=new DB_Connection(environment);
      Connection local = db_access.createConnection();
      PreparedStatement prep_statement = local.prepareStatement("INSERT INTO `consultations`(doctor_username,patient_username,consultation_date_and_time) VALUES (?, ?, ?)");
      prep_statement.setString(1, docter_user_name);
      prep_statement.setString(2, p_name);
      prep_statement.setString(3, (consultation_date.format(current_time)));
      prep_statement.executeUpdate();

  }


}
