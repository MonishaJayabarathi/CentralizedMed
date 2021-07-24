package com.centrailized_medi_application;

/*Importing Modules*/

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Aditya Jain & Ridampreet Singh
 * @description: This class implements the the feature of linking a patient with doctor's name.
 * Whenever a Patient visits the doctor, the doctor will add a patient (through his portal), which will record the
 * date and time of the consultation. The will later help the patient to rate the doctor as per their
 * experience.
 */

public class AddPatient {
  private boolean patientExist = false;
  private boolean[] credentials = new boolean[2];
  private boolean registered = false;
  private String patientUserName = null;
  private String doctorUserName;
  DbConnection dbAccess;
  DB_Layer layer = DB_Layer.singleConnection();

  /**
   * Constructor with DbConnection and String as input parameters
   *
   * @Param connection as DbConnection Interface
   * @Param docName as doctor's username
   */
  public AddPatient(DbConnection connection, String docName) throws SQLException, IOException, ClassNotFoundException {
    dbAccess = connection;
    doctorUserName = docName;
    dbAccess.close();
  }

  /**
   * This method checks whether a Patient is registered to the system or not.
   * Because only registered patient can be linked under doctor's profile.
   *
   * @return boolean
   * @Param patientName
   */
  boolean patientPresence(String patientName) throws SQLException, IOException, ClassNotFoundException {
    patientUserName = patientName;
    credentials = layer.getCredStatus(patientUserName,null);

    if (credentials[0] != false) {
      this.patientExist = true;
      return patientExist;
    } else {
      return patientExist;
    }
  }

  /**
   * This method checks whether a Patient is registered to the system or not.
   * Because only registered patient can be linked under doctor's profile.
   *
   * @return boolean
   * @Param patientName
   */
  public boolean link_patient(String patient_name) throws SQLException, IOException, ClassNotFoundException {
    DateTimeFormatter consultation_date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime current_time = LocalDateTime.now();
    if (this.patientPresence(patient_name)) {
      layer.insertConsultations(doctorUserName, patientUserName, consultation_date, current_time);
      System.out.println("Added Successfully!");
      registered = true;
      //layer.close();
      return registered;
    } else {
      System.out.println("Error Patient is not registered into the system!");
      return registered;
    }
  }
}
