package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/* Implementation for com.centrailized_medi_application.Patient */
public class Patient extends Login {
    private String user_name; // Stores Patient name
    private String password; // Stores patient passwd
    private boolean validId = false; // Sets true when patient is registered
    private boolean validPsswd = false; // Sets true when patient is registered
    private boolean authenticatePhase = false;
    private boolean[] creds = new boolean[2];
    private MainDashboard init;
    private PatientDashboard pd;
    private DbConnection connect;
    private ILoginAuthorisation la;
    private static int localRetry=0;


    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.user_name;
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


    public Patient(MainDashboard init, PatientDashboard patient_menu, DbConnection connection, ILoginAuthorisation loginauth) {
        this.init = init;
        this.pd = patient_menu;
        this.connect = connection;
        this.la = loginauth;
    }

    /* Fetching patient credentials*/
    @Override
    public void fetch(String u_name, String psswd) {
        this.user_name = u_name;
        this.password = psswd;
    }

    /* Connect to database and check against the data*/
    @Override
    public void validate() throws SQLException, IOException, ClassNotFoundException {
        creds = connect.getDetails();
        this.validId = creds[0];
        this.validPsswd = creds[1];
    }

    /* Defining the placeholder for com.centrailized_medi_application.Patient authentication*/
    @Override
    public void authenticate() throws SQLException, IOException, ClassNotFoundException {

        authenticatePhase = true;
        if (this.validId && this.validPsswd) // Exist and valid credentials
        {
            System.out.println("Welcome " + this.user_name); // name to be replaced with the actual name stored in db
            this.pd.display();
        } else if (this.validId && !this.validPsswd) {
            //call authentication mechanism
            System.out.println("Check your credentials!");
            localRetry++;
            this.la.set_Retry(localRetry);
            if(localRetry!=3) {
                this.init.display_patient_login();
            }else if(localRetry==3){
                this.la.getSecurityQuestion(user_name);
            }
        } else {
            System.out.println("Please register to the system!");
            System.out.println("Navigating to main menu...");
            init.display();
        }

    }
}
