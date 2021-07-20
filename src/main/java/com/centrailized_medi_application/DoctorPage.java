package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Monisha J, Ridampreet Singh, Neelay Goswami
 * @description: This program extends DoctorDashboard.
 * Holds abstract methods to define actual routing classes of tabs.
 * @params: int doctor_id : passed after successful login
 */
public class DoctorPage extends DoctorDashboard{

  protected String doctorUsername; //gives id of logged in doctor
  private String environment = "src/main/resources/config_test.properties";
  DoctorPage(String username) {
    this.doctorUsername = username;
  }

  // navigates to About Tab
  @Override
  public void display_about_doctor() throws SQLException, IOException, ClassNotFoundException {
    AboutDoctor abtDr = new AboutDoctor(this.doctorUsername, this); //testing commit
    AboutDoctorPage abtDrPage = new AboutDoctorPage(abtDr);
    abtDrPage.display();
  }

  // navigates to Add Patients Tab
  @Override
  public void display_add_patients() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Enter a Patient Name to register");
    Scanner sc = new Scanner(System.in);
    String patient_name = sc.next();
    AddPatient newEntry = new AddPatient(new DB_Connection(environment,patient_name,null),this.doctorUsername);
    newEntry.link_patient(patient_name);
    this.display();
  }

  // navigates to Patients Tab
  @Override
  public void display_patients() {

  }

//gets the list of patients registered who have opted "YES" for donations.
  @Override
  public void display_donors() throws SQLException, IOException, ClassNotFoundException {
    DB_Layer layer=new DB_Layer();
    ResultSet exec_get_donors=layer.fetchDonors();
    while(exec_get_donors.next())
    {
      System.out.println(exec_get_donors.getInt("Id")+"\t"+exec_get_donors.getString("firstname")+"\t"+exec_get_donors.getString("lastname")+"\t"+exec_get_donors.getString("bloodGroup"));
    }
    DoctorDashboard redirect_home=new DoctorPage(this.doctorUsername);
    redirect_home.display();
  }

  @Override
  public void display_patiient_family_history() throws SQLException, IOException, ClassNotFoundException {
    FamilyInfo fi = new FamilyInfo();
    fi.getFamilyInfo();
    DoctorDashboard redirect_home=new DoctorPage(this.doctorUsername);
    redirect_home.display();

  }
//Logs out the currently signed in user out of the portal
  @Override
  public void Logout() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("User has been successfuly logged out !");
    WelcomePage back_to_menu=new WelcomePage();
    back_to_menu.display();
//        return "User has been successfuly logged out !";
  }


}
