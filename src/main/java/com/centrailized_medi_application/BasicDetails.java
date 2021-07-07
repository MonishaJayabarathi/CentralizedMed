package com.centrailized_medi_application;

//This class handles the basic details of an user (Patient+Doctor)

public class BasicDetails {
  private String firstName;
  private String lastName;
  private String emailId;
  private String dateOfBirth;
  private String gender;
  private String address;
  private String contactNo;
  private String password;
  private String confirmPassword;

  public String getFirstName() { return firstName; }

  public void setFirstName(String firstName) { this.firstName = firstName; }

  public String getLastName() { return lastName; }

  public void setLastName(String lastName) { this.lastName = lastName; }

  public String getEmailId() { return emailId; }

  public String getGender() { return gender; }

  public void setGender(String gender) { this.gender = gender; }

  public void setDob(String Dob) { this.dateOfBirth = Dob; }

  public String getDob() { return dateOfBirth; }

  public String getContactNo() { return contactNo; }

  public void setContactNo(String contactNo) { this.contactNo = contactNo; }

  public String getAddress() { return address; }

  public String setAddress(String address) { return this.address = address; }

  public void setEmailId(String emailId) { this.emailId = emailId; }

  public String getPassword() { return password; }

  public void setPassword(String password) { this.password = password; }

  public String getConfirmPassword() { return confirmPassword; }

  public void setConfirmPassword(String password) { this.confirmPassword = password; }

}
