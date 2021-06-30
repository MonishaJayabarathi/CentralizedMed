package com.centrailized_medi_application;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;

/* Implementation for com.centrailized_medi_application.Patient */
public class Patient implements Login
{
    private String user_name; // Stores com.centrailized_medi_application.Patient name
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


    /* Connect to database and check against the data*/
    @Override
    public void validate() throws SQLException, IOException, ClassNotFoundException {
        String environment="/Users/ridamjaggi/Desktop/Group5_5308/group5/src/main/java/com/centrailized_medi_application/config_test.properties";
        DB_Connection connect= new DB_Connection(environment,this.user_name,this.password);
        creds=connect.getDetails();
        // Placeholder for JDBC connection
        //1. Check with id --> if exist --> validate passwd
        //2. if id exist and passwrd incorrect prompt error
        //3. if id doesnt exist-->ask to register
        //4. Check if passwrd counter reaches certain threshold to pop security question
        //5. if credentials correct, exist = True

        //Assuming the patient exists in the database
        this.valid_id = creds[0];
        this.valid_psswd = creds[1];

    }

    /* Defining the placeholder for com.centrailized_medi_application.Patient authentication*/
    @Override
    public void authenticate()
    {

        if(this.valid_id && this.valid_psswd) // Exist and valid credentials
        {


            System.out.println("Welcome "+this.user_name); // name to be replaced with the actual name stored in db
        }
        else if(this.valid_id && !this.valid_psswd)
        {
            System.out.println("Check your credentials!");
        }
        else
        {
            System.out.println("Please register to the system!");
        }

    }
}
