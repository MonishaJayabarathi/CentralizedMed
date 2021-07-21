package com.centrailized_medi_application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddPatient {

  private boolean patient_exist = false;
  private String p_name = null;
  private boolean[] creds = new boolean[2];
  DbConnection db_access;
  private String docter_user_name = null;
  private boolean registered = false;

  public AddPatient(DbConnection connection, String doc_name) {
    db_access = connection;
    docter_user_name = doc_name;
  }

  // Verifies weather person exists in system
  public boolean verify_patient(String patient_name) throws SQLException {
    p_name = patient_name;
    creds = db_access.getDetails();

    //Checking only against username ( index 0 is for username )
    if (creds[0] != false)
    {
      this.patient_exist = true;
      return patient_exist;
    } else {
      return patient_exist;
    }
  }

  public boolean link_patient(String patient_name) throws SQLException {
    DateTimeFormatter consultation_date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime current_time = LocalDateTime.now();
    if (this.verify_patient(patient_name)) {
      Connection local = db_access.createConnection();
      PreparedStatement prep_statement = local.prepareStatement("INSERT INTO `consultations`(doctor_username,patient_username,consultation_date_and_time) VALUES (?, ?, ?)");
      prep_statement.setString(1, docter_user_name);
      prep_statement.setString(2, p_name);
      prep_statement.setString(3, (consultation_date.format(current_time)));
      prep_statement.executeUpdate();
      System.out.println("Added Successfully!");
      registered = true;
      return registered;
    }
    else
    {
      System.out.println("Error Patient is not registered into the system!");
      return registered;
    }
  }
}
