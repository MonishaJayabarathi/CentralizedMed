package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/*
 * @author Monisha J
 * @description : This program performs the actual authentication of Doctor Login.
 * @params : MainDashboard and DoctorDashboard are passed, which are used to handle
 * changes after a login failure or success respectively.
 */
public class Doctor implements Login {
  private String userName;
  private String password;
  private boolean isValidUsername = false;
  private boolean isValidPassword = false;
  private boolean isUserValidated = false;
  private boolean[] creds = new boolean[2];


  public String getUsername() {
    return this.userName;
  }

  public String getPassword() {
    return this.password;
  }

  public boolean getUsernameStatus() {
    return this.isValidUsername;
  }

  public boolean getPasswordStatus() {
    return this.isValidPassword;
  }

  public boolean getValidationStatus() {
    return this.isUserValidated;
  }

  MainDashboard init;
  DoctorDashboard dd;

  public Doctor(MainDashboard init, DoctorDashboard doctorPage) {
    this.init = init;
    this.dd = doctorPage;
  }

  @Override
  public void fetch(String name, String password) {
    this.userName = name;
    this.password = password;
  }

  @Override
  public void validate() throws SQLException, IOException, ClassNotFoundException {
    String environment = "src/main/resources/config_test.properties";
    DB_Connection connect = new DB_Connection(environment, this.userName, this.password);
    creds = connect.getDetails();
    this.isValidUsername = creds[0];
    this.isValidPassword = creds[1];
  }

  @Override
  public void authenticate() throws SQLException, IOException, ClassNotFoundException {

    isUserValidated = true;
    if (this.isValidUsername && this.isValidPassword)
    {
      System.out.println("Welcome " + this.userName);
      this.dd.display();
    } else if (this.isValidUsername && !this.isValidPassword) {
      System.out.println("Check your credentials!");
      this.init.display_doctor_login();
    } else {
      System.out.println("Please register to the system!");
      System.out.println("Navigating to main menu...");
      this.init.display();
    }

  }
}
