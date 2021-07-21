package com.centrailized_medi_application;

/*Importing Modules*/

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddPatient {
  private boolean patientExist = false;
  private boolean[] credentials = new boolean[2];
  private boolean registered = false;
  private String patientUserName = null;
  private String doctorUserName = null;
  DbConnection dbAccess;

  public AddPatient(DbConnection connection, String doc_name) {
    dbAccess = connection;
    doctorUserName = doc_name;
  }

  // Verifies weather person exists in system
  public boolean verify_patient(String patient_name) throws SQLException, IOException, ClassNotFoundException {
    patientUserName = patient_name;
    credentials = dbAccess.getDetails();

    //Checking only against username ( index 0 is for username )
    if (credentials[0] != false) {
      this.patientExist = true;
      return patientExist;
    } else {
      return patientExist;
    }
  }

  public boolean link_patient(String patient_name) throws SQLException, IOException, ClassNotFoundException {
    DateTimeFormatter consultation_date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime current_time = LocalDateTime.now();
    if (this.verify_patient(patient_name)) {
      DB_Layer layer = new DB_Layer();
      layer.insertConsultations(doctorUserName, patientUserName, consultation_date, current_time);
      System.out.println("Added Successfully!");
      registered = true;
      return registered;
    } else {
      System.out.println("Error Patient is not registered into the system!");
      return registered;
    }
  }
}
