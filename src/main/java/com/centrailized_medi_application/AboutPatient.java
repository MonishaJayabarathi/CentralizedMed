package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class AboutPatient implements About{
    //Static private String tempemail;
    PatientDashboard init;
    private  Connection c;
    //This variable stores Patient username
    private String user_name;

    // This stores results fetched from Database
    private ResultSet currentPatientDetails;

    AboutPatient(String patient_id, PatientDashboard pd) {
        this.user_name = patient_id;
        this.init = pd;

    }

    //Fetch Patient Information from the Database
    @Override
    public void fetchDetails() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Loading About...\n");
        String configFile="src/main/resources/config_test.properties";
//        DbConnection test = new DB_Connection("src/main/resources/config_test.properties");
        c = DB_Connection.getDB_Connection_Instance(configFile);

        String sqlStmt = "SELECT * FROM patient_info where emailId =?";

        PreparedStatement prepStmt = c.prepareStatement(sqlStmt);
        prepStmt.toString();
        prepStmt.setString(1, this.user_name);
        this.currentPatientDetails = prepStmt.executeQuery();

    }
    //Display Patient Details
    @Override
    public void displayDetails() throws SQLException {
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
            System.out.println("DonorCardNo: " + this.currentPatientDetails.getString("insuranceNo"));
            System.out.println("FamilyMemberCode: " + this.currentPatientDetails.getString("familyMemberCode"));
            System.out.println("Volunteer: " + this.currentPatientDetails.getString("volunteer"));
            System.out.println("*****************************************************************");
        }
    }

    //Navigation to patients dashboard
    @Override
    public void back  () throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Press 1 to move to your Dashboard");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option == 1) {
            c.close();
            System.out.println("Returning to your Dashboard...");
            PatientPage init = new PatientPage(user_name);
            this.init.display();
        } else {
            System.out.println("Please provide a valid entry");
            this.back();
        }
    }
}
