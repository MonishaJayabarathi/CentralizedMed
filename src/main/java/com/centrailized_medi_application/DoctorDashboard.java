package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Monisha J and Ridampreet Singh
 * @description: This program receives input for navigation
 * inside a Doctor Dashboard and routes the pages accordingly
 */

public abstract class DoctorDashboard extends Dashboard {

  //abstract methods that define tab navigations
  public abstract void display_about_doctor() throws SQLException, IOException, ClassNotFoundException;

  public abstract void display_add_patients() throws SQLException, IOException, ClassNotFoundException;


  public abstract void display_donors() throws SQLException, IOException, ClassNotFoundException;
  public abstract void display_patients() throws SQLException, IOException, ClassNotFoundException;
  public abstract void display_patiient_family_history() throws SQLException, IOException, ClassNotFoundException;
  public abstract void Logout() throws SQLException, IOException, ClassNotFoundException;
  protected boolean flag = false; //
  protected boolean logout=false;

  /* Method the displays the available tabs and corresponding key
   * Reads integer option from console and reroutes accordingly
   */
  @Override
  public void display() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("-----------Dashboard-------------");
    System.out.println("1.About");
    System.out.println("2.Add Patients");
    System.out.println("3.Patients");
    System.out.println("4.Donors");
    System.out.println("5.Patient Family History");
    System.out.println("6.Logout");
    System.out.println("----------------------------------");
    System.out.println(" Enter from above options to proceed:");

    while (!flag) {
      Scanner sc = new Scanner(System.in);
      int option = sc.nextInt();
      if (option == 1) {
        this.display_about_doctor();  // navigates to display About Doctor Tab.
        flag = true;
      } else if (option == 2) {
        this.display_add_patients();
        flag = true;
      } else if (option == 3) {
        flag = true;
      } else if(option==4) {
        this.display_donors();
        flag=true;
      }else if(option==5) {
        this.display_patiient_family_history();
        flag=true;
      }
      else if(option==6) {
        this.Logout();
        logout=true;
        flag=true;
      }
      else {
        System.out.println("Enter the correct options to proceed");
      }
    }
  }
}
