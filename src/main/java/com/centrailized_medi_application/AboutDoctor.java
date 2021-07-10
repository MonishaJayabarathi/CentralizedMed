package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/*
 * @author Monisha J
 * @description: This program implements About Interface.
 * To load and display details of a doctor.
 * Overrides the methods defining structure of execution.
 * @params: int doctor_id : gets id of the doctor who logged in.
 */

public class AboutDoctor implements About {

  private int doctorId; //holds the give doctor id.

  AboutDoctor(int doctor_id) {
    this.doctorId = doctor_id;
  }

  @Override
  public void loadDetails() throws SQLException, IOException, ClassNotFoundException {
    //get details from DB
    System.out.println("Loading About...");
  }

  @Override
  public void displayDetails() throws SQLException, IOException, ClassNotFoundException {
    //display details
    System.out.println("Doctor Details");
  }
}
