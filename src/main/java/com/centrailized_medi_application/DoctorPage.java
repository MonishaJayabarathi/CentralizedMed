package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/*
 * @author Monisha J
 * @description: This program extends DoctorDashboard.
 * Holds abstract methods to define actual routing classes of tabs.
 * @params: int doctor_id : passed after successful login
 */
public class DoctorPage extends DoctorDashboard{

  private int doctor_id; //gives id of logged in doctor

  // navigates to About Tab
  @Override
  public void display_about_doctor() throws SQLException, IOException, ClassNotFoundException {

  }

  // navigates to Add Patients Tab
  @Override
  public void display_add_patients() {

  }

  // navigates to Patients Tab
  @Override
  public void display_patients() {

  }
}
