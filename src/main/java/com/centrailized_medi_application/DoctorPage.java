package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @author Monisha J
 * @description: This program extends DoctorDashboard.
 * Holds abstract methods to define actual routing classes of tabs.
 * @params: int doctor_id : passed after successful login
 */
public class DoctorPage extends DoctorDashboard{

  private int doctor_id; //gives id of logged in doctor
  private String environment="src/main/resources/config_test.properties";

  // navigates to About Tab
  @Override
  public void display_about_doctor() throws SQLException, IOException, ClassNotFoundException {
    AboutDoctor abtDr = new AboutDoctor(1); //testing commit
    AboutDoctorPage abtDrPage = new AboutDoctorPage(abtDr);
    abtDrPage.display();
  }

  // navigates to Add Patients Tab
  @Override
  public void display_add_patients() {

  }

  // navigates to Patients Tab
  @Override
  public void display_patients() {

  }

  @Override
  public void display_donors() throws SQLException, IOException, ClassNotFoundException {
    DB_Connection db=new DB_Connection(environment);
    Connection connect=db.createConnection();
    PreparedStatement get_donors=connect.prepareStatement("Select * from userinfo where volunteer=? ");
    get_donors.setString(1,"yes");
    ResultSet exec_get_donors=get_donors.executeQuery();
    while(exec_get_donors.next())
    {
      System.out.println(exec_get_donors.getInt("Id")+"\t"+exec_get_donors.getString("firstname")+"\t"+exec_get_donors.getString("lastname")+"\t"+exec_get_donors.getString("bloodGroup"));
    }
    DoctorDashboard redirect_home=new DoctorPage();
    redirect_home.display();
  }

  @Override
  public void Logout() throws SQLException, IOException, ClassNotFoundException {
    System.out.println("User has been successfuly logged out !");
    WelcomePage back_to_menu=new WelcomePage();
    back_to_menu.display();
//        return "User has been successfuly logged out !";
  }


}
