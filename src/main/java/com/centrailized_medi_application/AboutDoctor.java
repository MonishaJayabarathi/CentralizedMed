package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Monisha J
 * @description: This program implements About Interface.
 * To fetch and display details of a doctor.
 * Overrides the methods defining structure of execution.
 * @params: int doctor_id : gets username of the doctor who logged in.
 * DoctorDashboard dd : this triggers return to users dashboard.
 */
public class AboutDoctor implements About {

  DoctorDashboard init;
  private String doctorUsername; //holds the give doctor username.
  private ResultSet currentDoctorDetails; // holds the db results fetched

  AboutDoctor(String doctor_id, DoctorDashboard dd) {
    this.doctorUsername = doctor_id;
    this.init = dd;
  }

  //fetch user details from DB
  @Override
  public void fetchDetails() throws SQLException, IOException, ClassNotFoundException {
    //get details from DB
    System.out.println("Loading About...");
  }

  @Override
  public void displayDetails() throws SQLException, IOException, ClassNotFoundException {
    //display details
    System.out.println("Doctor Details");
  }

  @Override
  public void back() throws SQLException, IOException, ClassNotFoundException {
    //navigation to doctor dashboard
  }
}