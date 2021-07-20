package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Aditya Jain
 * @description: PatientDashboard is an abstract class. It overrides display() of class Dashboard.
 * The class declares the abstract methods which will be displayed when a Patient sign-in.
 * Based on input, the user is taken to specific page based on the options presented.
 * The methods displayAbout(), displayConsultations(), displayPrescriptions()
 * displaySuggestions(), displayLogout() are defined in the concrete class PatientPage
 */
public abstract class PatientDashboard extends Dashboard {
  public abstract void displayAbout() throws SQLException, IOException, ClassNotFoundException;

  public abstract void displayConsultations() throws SQLException, IOException, ClassNotFoundException;

  public abstract void displayPrescriptions() throws SQLException, IOException, ClassNotFoundException;

  public abstract void displaySuggestions() throws SQLException, IOException, ClassNotFoundException;

  public abstract void displayLogout() throws SQLException, IOException, ClassNotFoundException;

  protected boolean flag = false;
  protected boolean logout = false;
  protected Scanner sc = new Scanner(System.in);

  @Override
  public void display() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("-----------Dashboard-------------");
    System.out.println("1.About");
    System.out.println("2.Consultations");
    System.out.println("3.Prescriptions");
    System.out.println("4.Suggestions");
    System.out.println("5.Logout");
    System.out.println("----------------------------------");
    System.out.println(" Enter from above options to proceed:");

    while (flag != true) {
      int option = sc.nextInt();
      if (option == 1) {
        this.displayAbout();          // Responsible for loading up Patient's details
        flag = true;
      } else if (option == 2) {
        this.displayConsultations();  // Responsible for loading up Patient's consultations
        flag = true;
      } else if (option == 3) {
        this.displayPrescriptions();  // Responsible for loading up Patient's Prescriptions
        flag = true;
      } else if (option == 4) {
        flag = true;
        this.displaySuggestions();    // Responsible for loading up Patient's Suggestions
      } else if (option == 5) {
        this.displayLogout();         // Responsible for logging out
        logout = true;
        flag = true;
      } else {
        System.out.println("Enter the correct options to proceed");
      }
    }
  }
}