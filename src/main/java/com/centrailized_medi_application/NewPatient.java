package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewPatient implements Details, Registration {
    protected boolean hasRegisteredSuccessfully = false;
    MainDashboard init;
    private BasicDetails basicDetails;
    private PatientDetails patientDetails;
    private SecurityQuestions securityQuestions;

    NewPatient(BasicDetails basic, PatientDetails pdetails, SecurityQuestions securityqs, MainDashboard main ) {
        this.basicDetails = basic;
        this.patientDetails = pdetails;
        this.securityQuestions = securityqs;
        this.init = main;
    }

    public boolean getRegistrationStatus() {
        return this.hasRegisteredSuccessfully;
    }

    @Override
    public void getDetails() {
        this.basicDetails.getDetails();
        this.patientDetails.getDetails();
        this.securityQuestions.getDetails();
    }
    @Override
    public void update() throws IOException, ClassNotFoundException, SQLException {
        // Update details to patient table
        DB_Layer layer=new DB_Layer();
        layer.insertNewPatient(basicDetails,patientDetails,securityQuestions);
        this.hasRegisteredSuccessfully = true;

    }

    @Override
    public void action() throws SQLException, IOException, ClassNotFoundException {
        // check if the details were updated successfully
        if(this.hasRegisteredSuccessfully) {
            String firstName = this.basicDetails.getFirstName();
            System.out.println(firstName + " you have registered successfully. You can now login and access your dashboard"); // name to be replaced with the actual name stored in db
            this.init.display_patient_login();
        } else {
            System.out.println("Unable to register. Please try again!");
            System.out.println("Navigating to main menu...");
            this.init.display();
        }
    }
}
