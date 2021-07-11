package com.centrailized_medi_application;
import java.util.Scanner;

public class DoctorDetails implements Details{

  private  String speciality;
  private  int registrationNumber;
  protected Scanner sc = new Scanner(System.in);

  public String getSpeciality() {
    return speciality;
  }
  public void setSpeciality(String spc) {
    this.speciality = spc;
  }
  public int getRegistrationNumber() {
    return registrationNumber;
  }
  public void setRegistrationNumber(int num) {
    this.registrationNumber = num ;
  }

  @Override
  public void getDetails() {
    try {
      System.out.println("Enter your Speciality:");
      setSpeciality(sc.next());
      System.out.println("Enter your Registration Number");
      setRegistrationNumber(sc.nextInt());
    } catch (Exception e) {
      System.out.println("doctorDetails Error " + e);
    }
  }
}
