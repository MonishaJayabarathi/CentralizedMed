package com.centrailized_medi_application;/* com.centrailized_medi_application.Patient com.centrailized_medi_application.Login Implementation which implements from com.centrailized_medi_application.LoginCommand Interface*/

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Monisha J
 * @description : This program gets confirmation and initiates authentication of Doctor while logging in.
 * @params : MainDashboard and Login are passed, which are used to handle confirmation and execution.
 */
public class DoctorLogin implements LoginCommand
{
  Login doctorLogin;
  MainDashboard init;

  private String doctorName;
  private String doctorPassword;

  public DoctorLogin(Login dLogin, MainDashboard init)
  {
    this.doctorLogin = dLogin;
    this.init = init;
  }

  public void setDoctorName(String doctor_name) throws SQLException, IOException, ClassNotFoundException {

    if(doctor_name.contains("@") && doctor_name.contains(".com"))
    {
      this.doctorName = doctor_name;
    }
    else
    {
      System.out.println("Expecting Email id");
      System.out.println("Re-enter you details");
      init.display_doctor_login();
    }

  }

  public void setDoctorPassword(String doctor_password) {
    this.doctorPassword = doctor_password;
  }
  public String getDoctorName()
  {
    return this.doctorName;
  }
  public String getDoctorPassword() {
    return this.doctorPassword;
  }

  //initiates authentication
  @Override
  public void execute() throws SQLException, IOException, ClassNotFoundException
  {
    doctorLogin.fetch(this.doctorName,this.doctorPassword);
    doctorLogin.validate();
    doctorLogin.authenticate();
  }

  //gets user confirmation before we proceed to next step
  @Override
  public void confirmation() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Please enter 1 to submit or any other option to revert");
    Scanner sc = new Scanner(System.in);
    if (sc.nextInt() == 1)
    {
      System.out.println("Logging in....");
      this.execute();
    }
    else
    {
      System.out.println("Are you sure you want to cancel action, please enter y/n to confirm");
      sc = new Scanner(System.in);
      if (sc.nextLine().equals("y"))
      {
        System.out.println("Navigating to main menu...");
        this.init.display();

      }
      else
      {
        System.out.println("Logging in....");
        this.execute();
      }
    }
  }
}
