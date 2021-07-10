package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class AddPatient implements  Login{

  private boolean patient_exist = false;

  @Override
  public void fetch(String u_name, String Psswd) {

  }

  @Override
  public void validate() throws SQLException, IOException, ClassNotFoundException {

  }

  @Override
  public void authenticate() throws SQLException, IOException, ClassNotFoundException {

  }


  public boolean verify_patient(String patient_name)
  {
    return patient_exist;
  }
}
