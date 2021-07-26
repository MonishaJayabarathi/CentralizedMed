package com.centrailized_medi_application;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class AboutPatient implements About {

  //Static private String tempemail;
  PatientDashboard init;
  private Connection c;
  //This variable stores Patient username
  private String user_name;

  // This stores results fetched from Database
  private ResultSet currentPatientDetails;
  private PreparedStatement prepStmt;
  private DB_Layer layer;

  AboutPatient(String patient_id, PatientDashboard pd) {
    this.user_name = patient_id;
    this.init = pd;
    //layer=DB_Layer.singleConnection();

  }

  //Fetch Patient Information from the Database
  @Override
  public void fetchDetails() {
    try {
      layer = DB_Layer.singleConnection();
      System.out.println("Loading About...\n");
      List<Object> resultState = layer.getUserDetails(user_name, "Patient");//call db layer.
      this.currentPatientDetails = (ResultSet) resultState.get(0);
      this.prepStmt = (PreparedStatement) resultState.get(1);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  //Display Patient Details
  @Override
  public void displayDetails() {

    try {
      while (this.currentPatientDetails.next()) {
        System.out.println("**************************** About You **************************");
        System.out.println("Requested Patient Info:");
        System.out.println("Firstname: " + this.currentPatientDetails.getString("firstname"));
        System.out.println("Lastname: " + this.currentPatientDetails.getString("lastname"));
        System.out.println("Date of birth: " + this.currentPatientDetails.getString("dateofbirth"));
        System.out.println("Gender: " + this.currentPatientDetails.getString("gender"));
        System.out.println("EmailId: " + this.currentPatientDetails.getString("emailId"));
        System.out.println("Address: " + this.currentPatientDetails.getString("address"));
        System.out.println("BloodGroup: " + this.currentPatientDetails.getString("bloodGroup"));
        System.out.println("Allergy: " + this.currentPatientDetails.getString("allergy"));
        System.out.println("ChronicDisease: " + this.currentPatientDetails.getString("chronicDisease"));
        System.out.println("InsuranceNo: " + this.currentPatientDetails.getString("insuranceNo"));
        System.out.println("DonorCardNo: " + this.currentPatientDetails.getString("donorCardNo"));
        System.out.println("FamilyMemberCode: " + this.currentPatientDetails.getString("familyMemberCode"));
        System.out.println("Volunteer: " + this.currentPatientDetails.getString("volunteer"));
        System.out.println("*****************************************************************");
      }

      currentPatientDetails.close();
      prepStmt.close();
      layer.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  //Navigation to patients dashboard
  @Override
  public void back() {
    try {
      System.out.println("Press 1 to move to your Dashboard");
      Scanner sc = new Scanner(System.in);
      int option = sc.nextInt();
      if (option == 1) {
        //layer.close();;
        System.out.println("Returning to your Dashboard...");
        PatientPage init = new PatientPage(user_name);
        this.init.display();
      } else {
        System.out.println("Please provide a valid entry");
        this.back();
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
