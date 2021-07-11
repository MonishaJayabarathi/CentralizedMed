package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * @author Monisha J
 * @description : This program initiates registration of Doctor.
 * @params : MainDashboard which are used to handle changes after a confirmation.
 * New Doctor instance used to perform functionalty.
 */
public class DoctorRegistration implements LoginCommand {

  NewDoctor doctor;
  MainDashboard init;

  public DoctorRegistration(NewDoctor doc, MainDashboard init)
  {
    this.doctor = doc;
    this.init = init;
  }

  public void start() throws SQLException, IOException, ClassNotFoundException {
    this.doctor.getDetails();
    this.confirmation();
  }

  @Override
  public void execute() throws SQLException, IOException, ClassNotFoundException {
    this.doctor.update();
    this.doctor.action();
  }

  @Override
  public void confirmation() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Please enter 1 to register or any other option to revert");
    Scanner sc = new Scanner(System.in);
    if (sc.nextInt() == 1)
    {
      this.execute();
    }
    else
    {
      System.out.println("Are you sure you want to cancel registration, please enter y/n to confirm");
      sc = new Scanner(System.in);
      if (sc.nextLine().equals("y"))
      {
        System.out.println("Navigating to main menu...");
        this.init.display();
      }
      else
      {
        System.out.println("Registration in progress....");
        this.execute();
      }
    }
  }
}
