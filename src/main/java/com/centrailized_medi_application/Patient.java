package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/* Implementation for com.centrailized_medi_application.Patient */
public class Patient implements Login
{
    private String user_name; // Stores Patient name
    private String password; // Stores patient passwd
    private boolean valid_id = false; // Sets true when patient is registered
    private boolean valid_psswd = false; // Sets true when patient is registered
    private boolean authenticate_phase = false;
    private boolean[] creds=new boolean[2];

    MainMenu init;
    PatientDashboard pd;
    public Patient(MainMenu main_menu, PatientDashboard patient_menu)
    {
        this.init = main_menu;
        this.pd = patient_menu;
    }

    public String getPassword() {
        return this.password;
    }
    public String getUsername() {
        return this.user_name;
    }

    public boolean get_id_status(){return this.valid_id;}
    public boolean get_pass_status(){return this.valid_psswd;}
    public boolean get_auth_status(){return this.authenticate_phase;}



    /* Fetching patient credentials*/
    @Override
    public void fetch(String u_name, String psswd)
    {
        this.user_name = u_name;
        this.password = psswd;
    }

    /* Connect to database and check against the data*/
    @Override
    public void validate() throws SQLException, IOException, ClassNotFoundException {
        String environment ="src/main/resources/config_test.properties";
        DB_Connection connect= new DB_Connection(environment,this.user_name,this.password);
        creds=connect.getDetails();
        this.valid_id = creds[0];
        this.valid_psswd = creds[1];
    }

    /* Defining the placeholder for com.centrailized_medi_application.Patient authentication*/
    @Override
    public void authenticate() throws SQLException, IOException, ClassNotFoundException {

        authenticate_phase = true;
        if(this.valid_id && this.valid_psswd) // Exist and valid credentials
        {
            System.out.println("Welcome "+this.user_name); // name to be replaced with the actual name stored in db
            this.pd.display();
        }
        else if(this.valid_id && !this.valid_psswd)
        {
            System.out.println("Check your credentials!");
            this.init.display_patient_login();
        }
        else
        {
            System.out.println("Please register to the system!");
            System.out.println("Navigating to main menu...");
            init.display();
        }

    }
}
