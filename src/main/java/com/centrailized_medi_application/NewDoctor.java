package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewDoctor implements Details, Registration {

  protected boolean hasRegisteredSuccessfully = false;
  MainDashboard init;
  private BasicDetails basicDetails;
  private DoctorDetails doctorDetails;
  private SecurityQuestions securityQuestions;

  NewDoctor(BasicDetails bd, DoctorDetails dd, SecurityQuestions sq, MainDashboard main ) {
    this.basicDetails = bd;
    this.doctorDetails = dd;
    this.securityQuestions = sq;
    this.init = main;
  }

  public boolean getRegistrationStatus() {
    return this.hasRegisteredSuccessfully;
  }

  @Override
  public void getDetails() {
    this.basicDetails.getDetails();
    this.doctorDetails.getDetails();
    this.securityQuestions.getDetails();
  }
  @Override
  public void update() throws IOException, ClassNotFoundException, SQLException {
    // Update details to doctor table
    DB_Connection db=new DB_Connection("src/main/resources/config_test.properties");
    Connection connection=db.createConnection();

    PreparedStatement st =connection.prepareStatement("Insert into login_details(user_name,pass) values(?,?)");
    st.setString(1,this.basicDetails.getEmailId());
    st.setString(2,this.basicDetails.getPassword());

    st.execute();
    st = connection.prepareStatement("Select * from login_details where user_name=\"" + this.basicDetails.getEmailId() + "\"");
    ResultSet rs2 = st.executeQuery();
    rs2.next();
    int curr_id = rs2.getInt("idlogin_details");
    System.out.println(curr_id);

    PreparedStatement insert_statement=connection.prepareStatement("insert into " +
        "doctor_info(id,first_name,last_name,clinic_address,speciality,registration_number,email,password) " +
        "values(?,?,?,?,?,?,?,?);");
    insert_statement.setInt(1,curr_id);
    insert_statement.setString(2,this.basicDetails.getFirstName());
    insert_statement.setString(3,this.basicDetails.getLastName());
    insert_statement.setString(4,this.basicDetails.getAddress());
    insert_statement.setString(5,this.doctorDetails.getSpeciality());
    insert_statement.setInt(6,this.doctorDetails.getRegistrationNumber());
    insert_statement.setString(7,this.basicDetails.getEmailId());
    insert_statement.setString(8,this.basicDetails.getPassword());

    insert_statement.execute();
    this.hasRegisteredSuccessfully = true;
  }

  @Override
  public void action() throws SQLException, IOException, ClassNotFoundException {
    // check if the details were updated successfully
    if(this.hasRegisteredSuccessfully) {
      String firstName = this.basicDetails.getFirstName();
      System.out.println(firstName + " you have registered successfully. You can now login and access your dashboard"); // name to be replaced with the actual name stored in db
      this.init.display_doctor_login();
    } else {
      System.out.println("Unable to register. Please try again!");
      System.out.println("Navigating to main menu...");
      this.init.display();
    }
  }
}
