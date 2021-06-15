package com.centrailized_medi_application;

/* Implementation for com.centrailized_medi_application.Patient */
public class Patient implements Login
{
    private String user_name; // Stores com.centrailized_medi_application.Patient name
    private String password; // Stores patient passwd
    private boolean valid_id = false; // Sets true when patient is registered
    private boolean valid_psswd = false; // Sets true when patient is registered

    /* Fetching patient credentials*/
    @Override
    public void fetch(String u_name, String psswd)
    {
        this.user_name = u_name;
        this.password = psswd;

    }


    /* Connect to database and check against the data*/
    @Override
    public void validate()
    {
        // Placeholder for JDBC connection
        //1. Check with id --> if exist --> validate passwd
        //2. if id exist and passwrd incorrect prompt error
        //3. if id doesnt exist-->ask to register
        //4. Check if passwrd counter reaches certain threshold to pop security question
        //5. if credentials correct, exist = True

        //Assuming the patient exists in the database
        this.valid_id = true;
        this.valid_psswd = true;

    }

    /* Defining the placeholder for com.centrailized_medi_application.Patient authentication*/
    @Override
    public void authenticate()
    {

        if(this.valid_id && this.valid_psswd) // Exist and valid credentials
        {
            System.out.println("Welcome Patient_name"); // name to be replaced with the actual name stored in db
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
