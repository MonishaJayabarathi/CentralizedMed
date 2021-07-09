package com.centrailized_medi_application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorRegistration implements LoginCommand, Registration{

  private static BasicDetails doctorBasicDetails;
  private  String clinicAddress;
  private  String speciality;
  private  int registrationNumber;
  private Scanner sc = new Scanner(System.in);



  public String getClinicAddress() {
    return clinicAddress;
  }
  public void setClinicAddress(String address) {
    this.clinicAddress = address;
  }
  public String getSpeciality() {
    return speciality;
  }
  public void setSpeciality(String spc) {
    this.speciality = spc;
  }
  public int getRegistrationNumber() { return registrationNumber; }
  public void setRegistrationNumber(int num) {
    this.registrationNumber = num ;
  }

  public void run() {
    doctorBasicDetails = new BasicDetails();
    try {
      System.out.println("Enter your First Name:");
      doctorBasicDetails.setFirstName(sc.next());
      System.out.println("Enter your Last Name:");
      doctorBasicDetails.setLastName(sc.next());
      System.out.println("Enter your Clinic's Address:");
      setClinicAddress(sc.next());
      System.out.println("Enter your Speciality:");
      setSpeciality(sc.next());
      System.out.println("Enter your Registration Number");
      setRegistrationNumber(sc.nextInt());
      System.out.println("Enter your E-mail(userId):");
      doctorBasicDetails.setEmailId(sc.next());
      System.out.println("Enter your password");
      doctorBasicDetails.setPassword(sc.next());
      System.out.println("Enter your confirm password");
      doctorBasicDetails.setConfirmPassword(sc.next());
      this.confirmation();
    } catch (Exception e) {
      System.out.println("doctorRegisteration Error " + e);
    }
  }

  public void confirmation () throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Please enter 1 to submit");
    if (sc.nextInt() == 1)
      this.execute();
    else {
      System.out.println("Are you sure you want to cancel action, please enter y/n to confirm");
      if (sc.next() == "y")
        System.out.println("move to main menu");
      else
        this.confirmation();
    }
  }

  public void nextAction() throws SQLException, IOException, ClassNotFoundException {
    // On successful update navigate to main menu
    System.out.println("You have been successfully Registered. Please login to access your dashboard.\n");
    //ac.mainMenu();
  }

  @Override
  public void update() throws IOException, ClassNotFoundException, SQLException {
    // Update details to doctor table
    DB_Connection db=new DB_Connection("src/main/resources/config_test.properties");
    Connection connection=db.createConnection();
    //ridam
    PreparedStatement st=connection.prepareStatement("Insert into login_details(user_name,pass) values(?,?)");
    st.setString(1,doctorBasicDetails.getEmailId());
    st.setString(2,doctorBasicDetails.getPassword());

    boolean rs1=st.execute();
    st=connection.prepareStatement("Select * from login_details where user_name=?");
    st.setString(1,doctorBasicDetails.getEmailId());
    ResultSet rs2=st.executeQuery();
    rs2.next();
    int curr_id=rs2.getInt("idlogin_details");



    PreparedStatement insert_statement=connection.prepareStatement("insert into doctor_info(id,first_name,last_name,clinic_address,speciality,registration_number,email,password) values(?,?,?,?,?,?,?,?);");
    insert_statement.setInt(1,curr_id);
    insert_statement.setString(2,doctorBasicDetails.getFirstName());
    insert_statement.setString(3,doctorBasicDetails.getLastName());
    insert_statement.setString(4,clinicAddress);
    insert_statement.setString(5,speciality);
    insert_statement.setInt(6,registrationNumber);
    insert_statement.setString(7,doctorBasicDetails.getEmailId());
    insert_statement.setString(8,doctorBasicDetails.getPassword());

    boolean result=insert_statement.execute();


  }

  @Override
  public void authenticate() throws SQLException, IOException, ClassNotFoundException {
    // check if the details were updated successfully
    this.nextAction();
  }

  @Override
  public void execute() throws SQLException, IOException, ClassNotFoundException {
    this.update();
    this.authenticate();
  }
}
