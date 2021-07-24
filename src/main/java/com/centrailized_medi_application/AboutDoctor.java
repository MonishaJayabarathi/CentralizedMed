package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
  private PreparedStatement prepStmt;
  DB_Layer layer;
  AboutDoctor(String doctor_id, DoctorDashboard dd) throws SQLException, IOException, ClassNotFoundException {
    this.doctorUsername = doctor_id;
    this.init = dd;
    //this.layer=DB_Layer.singleConnection();
  }

  //fetch user details from DB
  @Override
  public void fetchDetails() throws SQLException, IOException, ClassNotFoundException {
    this.layer=DB_Layer.singleConnection();
    System.out.println("Loading About...\n");
    List<Object> resultState =layer.getUserDetails(doctorUsername,"Doctor");//call to the DB layer.

    this.currentDoctorDetails = (ResultSet) resultState.get(0);
    this.prepStmt = (PreparedStatement) resultState.get(1);

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

    currentDoctorDetails.close();
    prepStmt.close();
    layer.close();
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