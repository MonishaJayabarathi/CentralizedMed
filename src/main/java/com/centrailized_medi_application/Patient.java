package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/* Implementation for com.centrailized_medi_application.Patient */
public class Patient extends Login {
    private String userName; // Stores Patient name
    private String password; // Stores patient passwd
    private boolean validId = false; // Sets true when patient is registered
    private boolean validPsswd = false; // Sets true when patient is registered
    private boolean authenticatePhase = false;
    private boolean[] credentials = new boolean[2];
    private MainDashboard dashboard;
    private PatientDashboard patientDashboard;
    private DbConnection connect;
    private ILoginAuthorisation loginAuthorisation;
    private static int localRetry=0;


    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.userName;
    }

    public boolean get_id_status() {
        return this.validId;
    }

    public boolean get_pass_status() {
        return this.validPsswd;
    }

    public boolean get_auth_status() {
        return this.authenticatePhase;
    }


    public Patient(MainDashboard dashboard, PatientDashboard patient_menu, DbConnection connection, ILoginAuthorisation loginauth) {
        this.dashboard = dashboard;
        this.patientDashboard = patient_menu;
        this.connect = connection;
        this.loginAuthorisation = loginauth;
    }

    /* Fetching patient credentials*/
    @Override
    public void fetch(String userName, String psswd) {
        this.userName = userName;
        this.password = psswd;
    }



    /* Connect to database and check against the data*/
    @Override
    public void validate() throws SQLException, IOException, ClassNotFoundException {
        credentials = connect.getDetails();
        this.validId = credentials[0];
        this.validPsswd = credentials[1];
    }

    /* Defining the placeholder for com.centrailized_medi_application.Patient authentication*/
    @Override
    public void authenticate() throws SQLException, IOException, ClassNotFoundException {

        authenticatePhase = true;
        if (this.validId && this.validPsswd) // Exist and valid credentials
        {
            System.out.println("Welcome " + this.userName); // name to be replaced with the actual name stored in db
            this.patientDashboard.display();
        } else if (this.validId && !this.validPsswd) {
            //call authentication mechanism
            System.out.println("Check your credentials!");
            localRetry++;
            this.loginAuthorisation.set_Retry(localRetry);
            if(localRetry!=3) {
                this.dashboard.display_patient_login();
            }else if(localRetry==3){
                this.loginAuthorisation.getSecurityQuestion(userName);
            }
        } else {
            System.out.println("Please register to the system!");
            System.out.println("Navigating to main menu...");
            dashboard.display();
        }

    }
}
