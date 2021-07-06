package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorLogin implements Login, LoginCommand
{
  private String doctor_user_name; // Stores com.centrailized_medi_application.Doctor name
  private String doctor_password; // Stores doctor passwd
  private boolean valid_id = false; // Sets true when doctor is registered
  private boolean valid_psswd = false; // Sets true when doctor is registered
  private boolean[] creds=new boolean[2];
  private Scanner sc = new Scanner(System.in);

  public String getDoctorUsername() {
    return doctor_user_name;
  }
  public void setDoctorUsername(String username) {
    this.doctor_user_name = username;
  }
  public String getDoctorPassword() {
    return doctor_password;
  }
  public void setDoctorPassword(String password) {
    this.doctor_password = password;
  }

  public void run() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Enter your username:");
    setDoctorUsername(sc.next());
    System.out.println("Enter your password:");
    setDoctorPassword(sc.next());
    this.confirmation();
  }

  public void confirmation () throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Please enter 1 to submit");
    if (sc.nextInt() == 1)
      this.execute();
    else {
      System.out.println("Are you sure you want to cancel action, please enter y/n to confirm");
      if (sc.next() == "y")
        System.out.println("move to main menu");
      else
        this.execute();
    }
  }
  /* Fetching patient credentials*/
  @Override
  public void fetch(String u_name, String psswd)
  {
    this.doctor_user_name = u_name;
    this.doctor_password = psswd;
  }

  /* Connect to database and check against the data*/
  @Override
  public void validate() throws SQLException, IOException, ClassNotFoundException
  {
    String environment="/Users/Admin/Documents/group5/src/main/java/com/centrailized_medi_application/config_test.properties";
    DB_Connection connect= new DB_Connection(environment,this.doctor_user_name,this.doctor_password);
    creds=connect.getDetails();

    //Assuming the patient exists in the database
    this.valid_id = creds[0];
    this.valid_psswd = creds[1];
  }

  /* Defining the placeholder for com.centrailized_medi_application.Patient authentication*/
  @Override
  public void authenticate()  {

    if(this.valid_id && this.valid_psswd) // Exist and valid credentials
    {
      System.out.println("Welcome Doctor Dashboard"); // name to be replaced with the actual name stored in db
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

  @Override
  public void execute() throws SQLException, IOException, ClassNotFoundException {
    this.validate();
    this.authenticate();
  }
}
