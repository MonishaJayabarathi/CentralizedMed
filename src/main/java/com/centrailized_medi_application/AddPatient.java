package com.centrailized_medi_application;


import java.sql.SQLException;

public class AddPatient {

  private boolean patient_exist = false;
  private String p_name = null;
  private boolean[] creds = new boolean[2];
  DbConnection db_access;

  public AddPatient(DbConnection connection) {
    db_access = connection;
  }

  // Verifies weather person exists in system
  public boolean verify_patient(String patient_name) throws SQLException {
    p_name = patient_name;
    creds = db_access.getDetails();

    //Checking only against username ( index 0 is for username )
    if (creds[0] != false) {
      return !patient_exist;
    } else {
      return patient_exist;
    }
  }

  public String link_patient(String user_name)
  {
    return null;
  }
}
