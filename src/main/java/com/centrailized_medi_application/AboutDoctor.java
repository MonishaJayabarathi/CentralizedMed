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
    System.out.println("Loading About...\n");
    DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
    Connection c = one.createConnection();

    String sqlStmt = "SELECT * FROM doctor_info where emailId =?";

    PreparedStatement prepStmt = c.prepareStatement(sqlStmt);
    prepStmt.toString();
    prepStmt.setString(1, this.doctorUsername);
    this.currentDoctorDetails = prepStmt.executeQuery();
  }

  //display user details
  @Override
  public void displayDetails() throws SQLException {
    while (this.currentDoctorDetails.next()) {
      System.out.println("**************************** About You **************************");
      System.out.println("Username(E-mail): " + this.currentDoctorDetails.getString("emailId"));
      System.out.println("Id: " + this.currentDoctorDetails.getString("id"));
      System.out.println("Firstname: " + this.currentDoctorDetails.getString("firstname"));
      System.out.println("Lastname: " + this.currentDoctorDetails.getString("lastname"));
      System.out.println("Gender: " + this.currentDoctorDetails.getString("gender"));
      System.out.println("Date of birth: " + this.currentDoctorDetails.getString("dateOfBirth"));
      System.out.println("Registration Number: " + this.currentDoctorDetails.getString("registrationNumber"));
      System.out.println("Specilaity: " + this.currentDoctorDetails.getString("speciality"));
      System.out.println("Address: " + this.currentDoctorDetails.getString("address"));
      System.out.println("Contact: " + this.currentDoctorDetails.getString("contactNo"));
      System.out.println("*****************************************************************");
    }
  }

  //handles navigation to dashboard
  @Override
  public void back  () throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Press 1 to move to your Dashboard");
    Scanner sc = new Scanner(System.in);
    int option = sc.nextInt();
    if (option == 1) {
      System.out.println("Returning to your Dashboard...");
      WelcomePage init = new WelcomePage();
      this.init.display();
    } else {
      System.out.println("Please provide a valid entry");
      this.back();
    }
  }
}