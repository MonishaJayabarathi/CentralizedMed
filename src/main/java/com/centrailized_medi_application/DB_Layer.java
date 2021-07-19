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


  public boolean[] getCredStatus(String u_name,String u_pass) throws SQLException, IOException, ClassNotFoundException {
String name;
boolean res_id = false;
boolean res_pass = false;
boolean[] cred_validity=new boolean[2];
String pass;
DB_Connection db=new DB_Connection(environment);
Connection connection=db.createConnection();
    PreparedStatement p1 = connection.prepareStatement("select * from CSCI5308_5_TEST.login_details where user_name=?");
    p1.setString(1, u_name);
    ResultSet login_name = p1.executeQuery();
    // and pass=?
    // p1.setString(2, u_pass);
    while (login_name.next())
    {
      name=login_name.getString("user_name");
      //System.out.println(b.getString("user_name"));
      if(name.equals((u_name)))
      {
        res_id = true;
      }
      PreparedStatement check_for_doc=connection.prepareStatement("select * from doctor_info where emailid=?");
      check_for_doc.setString(1,u_name);
      ResultSet res_check_for_doc=check_for_doc.executeQuery();
      if(res_check_for_doc.next()==true)
      {
        res_id=true;
        if(res_check_for_doc.getString("password").equals(u_pass))
        {
          res_pass=true;
        }
        else
        {
          res_pass=false;
        }
        cred_validity[0]=res_id;
        cred_validity[1]=res_pass;
        return cred_validity;
      }




      PreparedStatement p2 = connection.prepareStatement("select * from CSCI5308_5_TEST.login_details where user_name=? and pass=?");
      p2.setString(1, u_name);
      p2.setString(2, u_pass);
      ResultSet login_pass  = p2.executeQuery();
      while (login_pass.next()) {

        pass = login_pass.getString("pass");
        if (pass.equals(u_pass)) {
          res_pass = true;
        }
      }
      cred_validity[0]=res_id;
      cred_validity[1]=res_pass;
    }
    return cred_validity;
  }

}
