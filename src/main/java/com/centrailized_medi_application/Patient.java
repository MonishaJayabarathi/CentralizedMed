package com.centrailized_medi_application;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;

/* Implementation for com.centrailized_medi_application.Patient */
public class Patient implements Login
{
    private String user_name; // Stores Patient name
    private String password; // Stores patient passwd
    private boolean valid_id = false; // Sets true when patient is registered
    private boolean valid_psswd = false; // Sets true when patient is registered
    private boolean[] creds=new boolean[2];
    /* Fetching patient credentials*/
    @Override
    public void fetch(String u_name, String psswd)
    {
        this.user_name = u_name;
        this.password = psswd;

    }

    public String getPassword() {
        return password;
    }

    /* Connect to database and check against the data*/
    @Override
    public void validate() throws SQLException, IOException, ClassNotFoundException {
        String environment="src/main/resources/config_test.properties";
        DB_Connection connect= new DB_Connection(environment,this.user_name,this.password);
        creds=connect.getDetails();
        this.valid_id = creds[0];
        this.valid_psswd = creds[1];


    }

    /* Defining the placeholder for com.centrailized_medi_application.Patient authentication*/
    @Override
    public void authenticate() throws SQLException, IOException, ClassNotFoundException {

        if(this.valid_id && this.valid_psswd) // Exist and valid credentials
        {
            System.out.println("Welcome "+this.user_name); // name to be replaced with the actual name stored in db
        }
        else if(this.valid_id && !this.valid_psswd)
        {
            //call authentication mechanism
            System.out.println("Check your credentials!");

        }
        else
        {
            System.out.println("Please register to the system!");
            MainMenu init = new MainMenu();
            init.display();
        }

    }
}
