package com.centrailized_medi_application;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

//This class return all the family member details whose patient email id passed
//Author:Neelay Goswami
public class FamilyInfo {
  private ResultSet currentPatientDetails;
  private ResultSet familyDetails;
  private Connection c;
  private String familyCode = "";


  public String getFamilyInfo(String ...email)  throws SQLException, IOException, ClassNotFoundException
  {
    String patientEmail="";
    if(email.length == 0) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter Patient Email :");
      patientEmail = sc.nextLine();
      //System.out.println(patientEmail);
    }else
    {
      patientEmail = email[0];
    }

    DB_Layer layer=new DB_Layer();
    this.currentPatientDetails = layer.displayPatientInfo(patientEmail);
    displayCurrentPatient();


    this.familyDetails = layer.displayFamilyinfo(familyCode,patientEmail);
    displayMembers();

    layer.close();
    return familyCode;
  }

  public void displayCurrentPatient() throws SQLException, IOException, ClassNotFoundException {
    if (this.currentPatientDetails.next()) {
      System.out.println("**************************** Patient Family Information **************************");
      familyCode = this.currentPatientDetails.getString("familyMemberCode");
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
      System.out.println("DonorCardNo: " + this.currentPatientDetails.getString("insuranceNo"));
      System.out.println("Volunteer: " + this.currentPatientDetails.getString("volunteer"));
      System.out.println("*****************************************************************");
    }
  }

  public void displayMembers() throws SQLException, IOException, ClassNotFoundException
  {

    int count = 1;
    while (this.familyDetails.next()) {
      System.out.println("**************************** Member "+count+" **************************");
      System.out.println("Firstname: " + this.familyDetails.getString("firstname"));
      System.out.println("Lastname: " + this.familyDetails.getString("lastname"));
      System.out.println("Date of birth: " + this.familyDetails.getString("dateofbirth"));
      System.out.println("Gender: " + this.familyDetails.getString("gender"));
      System.out.println("EmailId: " + this.familyDetails.getString("emailId"));
      System.out.println("Address: " + this.familyDetails.getString("address"));
      System.out.println("BloodGroup: " + this.familyDetails.getString("bloodGroup"));
      System.out.println("Allergy: " + this.familyDetails.getString("allergy"));
      System.out.println("ChronicDisease: " + this.familyDetails.getString("chronicDisease"));
      System.out.println("InsuranceNo: " + this.familyDetails.getString("insuranceNo"));
      System.out.println("DonorCardNo: " + this.familyDetails.getString("insuranceNo"));
      System.out.println("FamilyMemberCode: " + this.familyDetails.getString("familyMemberCode"));
      System.out.println("Volunteer: " + this.familyDetails.getString("volunteer"));
      System.out.println("*****************************************************************");
      count++;
    }
  }



}
