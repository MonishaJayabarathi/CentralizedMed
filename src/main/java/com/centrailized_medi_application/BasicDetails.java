package com.centrailized_medi_application;


import java.util.Scanner;

/**
 * @author Monisha J, Neelay
 * @description: This program gets the basic details of a person trying to register.
 * The class has getter and setter of the required variables holding required data.
 */
public class BasicDetails implements Details {
  private String firstName;
  private String lastName;
  private String emailId;
  private String dateOfBirth;
  private String gender;
  private String address;
  private int latitude;
  private  int longitude;
  private String contactNo;
  private String password;
  private String confirmPassword;
  protected Scanner sc = new Scanner(System.in);

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getEmailId() {
    return emailId;
  }
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public void setDob(String Dob) {
    this.dateOfBirth = Dob;
  }
  public String getDob() {
    return dateOfBirth;
  }
  public String getContactNo() {
    return contactNo;
  }
  public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public int getLatitude() {
    return latitude;
  }
  public void setLatitude(int lat) {
    this.latitude = lat;
  }
  public int getLongitude() {
    return longitude;
  }
  public void setLongitude(int lon) {
    this.longitude = lon;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getConfirmPassword() {
    return confirmPassword;
  }
  public void setConfirmPassword(String password) {
    this.confirmPassword = password;
  }

  @Override
  public void getDetails () {
    System.out.println("Enter your First Name:");
    this.setFirstName(sc.nextLine());
    System.out.println("Enter your Last Name:");
    this.setLastName(sc.nextLine());
    System.out.print("Enter gender: ");
    this.setGender(sc.nextLine());
    System.out.print("Enter date of birth: ");
    this.setDob(sc.nextLine());
    System.out.print("Enter contactNo: ");
    this.setContactNo(sc.nextLine());
    System.out.print("Enter address: ");
    this.setAddress(sc.nextLine());
    System.out.println("Enter your E-mail(userId): ");
    this.setEmailId(sc.nextLine());
    System.out.println("Enter your password: ");
    this.setPassword(sc.nextLine());
    System.out.println("Enter your confirm password: ");
    this.setConfirmPassword(sc.nextLine());
  }
}
