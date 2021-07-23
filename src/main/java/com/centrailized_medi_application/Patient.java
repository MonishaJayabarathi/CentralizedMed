package com.centrailized_medi_application;

/*Importing Modules*/

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aditya Jain & RidamPreet Jaggi
 * @description: This class implements the methods from abstract class Login.
 * fetch() - It sets username and password of a Patient
 * validate() - It checks the stored username and password against the database
 * authenticate() - It then directs to the respective pages i.e. Back to Main-Menu, Login Page or Patient Page
 * All the functions are encapsulated under execute() in PatientLogin
 */
public class Patient extends Login {

  private String userName; // Stores Patient emailId as username
  private String password; // Stores patient password
  private boolean validId = false; // Sets true when patient is registered
  private boolean validPsswd = false; // Sets true when patient is registered
  private boolean authenticatePhase = false;  // Sets true then user is in authenticate Phase
  private boolean[] credentials = new boolean[2]; // Sets the respective index based on credibility of username & password
  private MainDashboard dashboard;    // Main dashboard interface
  private PatientDashboard patientDashboard;  // Patient Dashboard interface
  private DbConnection connect;               // Database interface
  private ILoginAuthorisation loginAuthorisation; // Password interface
  private static int localRetry = 0;          // Security Question counter

  /**
   * Constructor with PatientDashboard,MainDashboard,DbConnection,ILoginAuthorisation as input parameters
   *
   * @Param dashboard as MainDashboard Interface
   * @Param patientMenu as PatientDashboard Interface
   * @Param connection as DbConnection Interface
   * @Param localAuthorisation as ILoginAuthorisation Interface
   */
  public Patient(MainDashboard dashboard, PatientDashboard patientMenu, DbConnection connection, ILoginAuthorisation localAuthorisation) {
    this.dashboard = dashboard;
    this.patientDashboard = patientMenu;
    this.connect = connection;
    this.loginAuthorisation = localAuthorisation;
  }

  /**
   * This method returns the Patient Password.
   *
   * @return String
   * @Param None
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * This method returns the Patient Username.
   *
   * @return String
   * @Param None
   */
  public String getUsername() {
    return this.userName;
  }

  /**
   * This method returns the status of Patient's Username i.e. whether it is valid or not
   *
   * @return boolean
   * @Param None
   */
  public boolean getUsernameStatus() {
    return this.validId;
  }

  /**
   * This method returns the status of Patient's Password i.e. whether it is valid or not
   *
   * @return boolean
   * @Param None
   */
  public boolean getPassStatus() {
    return this.validPsswd;
  }

  /**
   * This method returns true if the Patient is in authentication Phase
   *
   * @return boolean
   * @Param None
   */
  public boolean getAuthStatus() {
    return this.authenticatePhase;
  }

  /**
   * This method sets the Patient Username (emailId) and Password
   *
   * @return void
   * @Param String userName - Patient's Username
   * @Param String psswd - Patient's Password
   */
  @Override
  protected void fetch(String userName, String psswd) {
    this.userName = userName;
    this.password = psswd;
  }

  /**
   * This method sets the flags (True/False) validId and validPsswd based on the input.
   * The details are checked against the database
   *
   * @return void
   * @Param void
   */
  @Override
  protected void validate() throws SQLException, IOException, ClassNotFoundException {
    credentials = connect.getDetails();
    this.validId = credentials[0];
    this.validPsswd = credentials[1];

  }

  /**
   * This method drives the Page to trigger based on the flags validId and validPsswd.
   * If username & password is valid, the program is directed towards Patient Dashboard
   * If username is valid & password isnt valid, the program is directed to Login Page
   * at the same time, counter for security question is checked so as to trigger security question
   * when login tries exceeds 3, then the patient is asked to enter Security Answer and to set a new Password
   * If both username & password both are incorrect, the program is directed towards MainMenu Dashboard
   *
   * @return void
   * @Param void
   */
  @Override
  protected void authenticate() throws SQLException, IOException, ClassNotFoundException {

    authenticatePhase = true;
    if (this.validId && this.validPsswd) // Valid Credentials
    {
      System.out.println("Welcome " + this.userName);
      this.patientDashboard.display();
    } else if (this.validId && !this.validPsswd) {  // Valid Username, Invalid Password
      System.out.println("Check your credentials!");
      localRetry++;
      this.loginAuthorisation.set_Retry(localRetry);
      if (localRetry != 3) {
        this.dashboard.displayPatientLogin();
      } else if (localRetry == 3) {
        this.loginAuthorisation.getSecurityQuestion(userName);
      }
    } else {                                          // Patient is not registered to the system
      System.out.println("Please register to the system!");
      System.out.println("Navigating to main menu...");
      dashboard.display();
    }
  }
}
