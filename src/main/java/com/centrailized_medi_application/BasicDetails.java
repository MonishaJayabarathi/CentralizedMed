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
  private Validation validate = new Validation();
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

  public int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }
  @Override
  public void getDetails () {
    String temp;
    System.out.println("Enter your First Name:");
    this.setFirstName(sc.nextLine());
    System.out.println("Enter your Last Name:");
    this.setLastName(sc.nextLine());
    System.out.println("Enter gender: ");
    temp = sc.nextLine();
    while (!validate.validateGender(temp))
    {
      System.out.println("Re-Enter gender: ");
      temp = sc.nextLine();
    }
    this.setGender(temp);


    System.out.println("Enter date of birth: ");
    temp = sc.nextLine();
    while (!validate.validateDob(temp))
    {
      System.out.println("Re-Enter date of birth: ");
      temp = sc.nextLine();
    }
    this.setDob(temp);

    System.out.println("Enter contactNo: ");
    temp = sc.nextLine();
    while (!validate.validateContactNo(temp))
    {
      System.out.println("Re-Enter contactNo: ");
      temp = sc.nextLine();
    }
    this.setContactNo(temp);

    System.out.println("Enter address: ");
    this.setAddress(sc.nextLine());
    System.out.println("Enter your E-mail(userId): ");
    temp = sc.nextLine();
    while (!validate.validateEmail(temp))
    {
      System.out.println("Re-Enter E-mail: ");
      temp = sc.nextLine();
    }
    this.setEmailId(temp);

    String confPass="";
    while(!temp.equals(confPass))
    {
      System.out.println("Enter your password: ");
      temp = sc.nextLine();
      while (!validate.validatePassword(temp))
      {
        System.out.println("Re-Enter password: ");
        temp = sc.nextLine();
      }

      System.out.println("Enter your confirm password: ");
      confPass = sc.nextLine();
      while (!validate.validatePassword(confPass))
      {
        System.out.println("Re-Enter confirm password: ");
        confPass = sc.nextLine();
      }
    }
    this.setPassword(confPass);

//    this.setConfirmPassword(sc.nextLine());
    this.setLatitude(getRandomNumber(0,200));
    this.setLongitude(getRandomNumber(0,200));
  }
}
