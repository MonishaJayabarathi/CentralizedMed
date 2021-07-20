package com.centrailized_medi_application;/* com.centrailized_medi_application.Patient com.centrailized_medi_application.Login Implementation which implements from com.centrailized_medi_application.LoginCommand Interface*/

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Monisha J
 * @description : This program gets confirmation and initiates authentication of Doctor while logging in.
 * @params : MainDashboard and Login are passed, which are used to handle confirmation and execution.
 */
public class DoctorLogin extends LoginCommand {
  private Login doctorLogin;
  private MainDashboard init;

  private String doctorName;
  private String doctorPassword;

  /**
   * Constructor to initialize members of the class
   *
   * @params : Takes concrete instances of Login and MainDashboard
   */
  public DoctorLogin(Login dLogin, MainDashboard init) {
    this.doctorLogin = dLogin;
    this.init = init;
  }

  /**
   * This method validates and sets the doctor's username.
   * If the username is invalid, user is asked to re-enter a valid one.
   *
   * @params: It takes String doctor_name, which is the entered username.
   */
  public void setDoctorName(String doctor_name) throws SQLException, IOException, ClassNotFoundException {

    if (doctor_name.contains("@") && doctor_name.contains(".com")) {
      this.doctorName = doctor_name;
    } else {
      System.out.println("Expecting Email id");
      System.out.println("Re-enter you details");
      init.display_doctor_login();
    }

  }

  /**
   * This method sets the doctor's password.
   *
   * @params: It takes String doctor_password, which is the entered login password.
   */
  public void setDoctorPassword(String doctor_password) {
    this.doctorPassword = doctor_password;
  }

  /**
   * This method returns the doctor's username.
   *
   * @return String doctorName - Name of the Doctor
   * @params None
   */
  public String getDoctorName() {
    return this.doctorName;
  }

  /**
   * This method returns the doctor's password.
   *
   * @return String doctorPassword - Password of the Doctor
   */
  public String getDoctorPassword() {
    return this.doctorPassword;
  }

  /**
   * This method executes the step by step actions required for logging in as a Doctor
   *
   * @throws SQLException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Override
  public void execute() throws SQLException, IOException, ClassNotFoundException {
    doctorLogin.fetch(this.doctorName, this.doctorPassword);
    doctorLogin.validate();
    doctorLogin.authenticate();
  }

  /**
   * This method gets user confirmation to submit or revert before we proceed to next step.
   * If user selects to login, it redirects to dashboard after validation
   * Else if user wants to cancel login, moves to the main dashboard
   *
   * @throws SQLException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Override
  public void confirmation() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Please enter 1 to submit or any other option to revert");
    Scanner sc = new Scanner(System.in);
    if (sc.nextInt() == 1) {
      System.out.println("Logging in....");
      this.execute();
    } else {
      System.out.println("Are you sure you want to cancel action, please enter y/n to confirm");
      sc = new Scanner(System.in);
      if (sc.nextLine().toLowerCase().equals("y")) {
        System.out.println("Navigating to main menu...");
        this.init.display();

      } else {
        System.out.println("Logging in....");
        this.execute();
      }
    }
  }
}
