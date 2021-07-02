package com.centrailized_medi_application;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorRegistration implements LoginCommand, Registration{

  private static BasicDetails doctorBasicDetails;
  private  String clinicAddress;
  private  String speciality;
  private  int registrationNumber;
  private Scanner sc = new Scanner(System.in);
  Action ac = new Action();


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
      doctorBasicDetails.setLastName(sc.next());
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
    ac.mainMenu();
  }

  @Override
  public void update() {
    // Update details to doctor table
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
