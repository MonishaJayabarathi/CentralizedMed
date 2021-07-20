package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Monisha J
 * @description : This program performs the actual authentication of Doctor Login.
 * @params : MainDashboard and DoctorDashboard are passed, which are used to handle
 * changes after a login failure or success respectively.
 */
public class Doctor extends Login {
  private String userName;
  private String password;
  private boolean isValidUsername = false;
  private boolean isValidPassword = false;
  private boolean isUserValidated = false;
  private boolean[] creds = new boolean[2];
  private MainDashboard init;
  private DoctorDashboard dd;
  private ILoginAuthorisation loginAuthorisation; // Password interface
  private static int localRetry = 0;          // Security Question counter

  /**
   * Constructor initializes the Dashboard members declared
   *
   * @param init       - It holds the MainDashboard instance
   * @param doctorPage - It holds the DoctorDashboard instance
   */
  public Doctor(MainDashboard init, DoctorDashboard doctorPage, ILoginAuthorisation localAuthorisation) {
    this.init = init;
    this.dd = doctorPage;
    this.loginAuthorisation = localAuthorisation;
  }

  /**
   * This method returns the doctor username entered.
   *
   * @return String username
   */
  public String getUsername() {
    return this.userName;
  }

  /**
   * This method returns the doctor password entered.
   *
   * @return String password
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * This method returns the boolean stating the validity of the username entered
   *
   * @return boolean isValidUsername
   */
  public boolean getUsernameStatus() {
    return this.isValidUsername;
  }

  /**
   * This method returns the boolean stating the validity of the password entered
   *
   * @return boolean isValidPassword
   */
  public boolean getPasswordStatus() {
    return this.isValidPassword;
  }

  /**
   * This method returns the boolean if the user credentials were validated.
   *
   * @return boolean isUserValidated
   */
  public boolean getValidationStatus() {
    return this.isUserValidated;
  }

  /**
   * This method receives and initialises the login credentials
   *
   * @param name     - It holds the username
   * @param password - It holds the user password
   */
  @Override
  public void fetch(String name, String password) {
    this.userName = name;
    this.password = password;
  }

  /**
   * This method validates the user credentials shared.
   *
   * @throws SQLException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Override
  public void validate() throws SQLException, IOException, ClassNotFoundException {
    String environment = "src/main/resources/config_test.properties";
    DB_Connection connect = new DB_Connection(environment, this.userName, this.password);
    creds = connect.getDetails();
    this.isValidUsername = creds[0];
    this.isValidPassword = creds[1];
  }

  /**
   * This checks the authentication of the user.
   * If it is valid, navigates to user dashboard
   * Else if password entered is wrong, it gives maximum 3 trials and asks the user to reset the password
   * Else(username doesn't exits) asks the user to register first
   *
   * @throws SQLException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Override
  public void authenticate() throws SQLException, IOException, ClassNotFoundException {

    isUserValidated = true;
    if (this.isValidUsername && this.isValidPassword) {
      System.out.println("Welcome " + this.userName);
      this.dd.display();
    } else if (this.isValidUsername && !this.isValidPassword) {
      System.out.println("Check your credentials!");
      localRetry++;
      this.loginAuthorisation.set_Retry(localRetry);
      if (localRetry != 3) {
        this.init.display_doctor_login();
      } else if (localRetry == 3) {
        this.loginAuthorisation.getSecurityQuestion(userName);
      }

    } else {
      System.out.println("Please register to the system!");
      System.out.println("Navigating to main menu...");
      this.init.display();
    }

  }
}
