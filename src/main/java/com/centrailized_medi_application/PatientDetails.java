package com.centrailized_medi_application;

import java.util.Scanner;

public class PatientDetails implements Details {
  private String bloodGroup;
  private String allergy;
  private String chronicDisease;
  private String insuranceNo;
  private String donorCardNo;
  private String familyMemberCode;
  private String volunteer;
  final private Validation validate = new Validation();
  protected Scanner scanner = new Scanner(System.in);

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getAllergy() {
    return allergy;
  }

  public void setAllergy(String allergy) {
    this.allergy = allergy;
  }

  public String getChonicDisease() {
    return chronicDisease;
  }

  public void setChronicDisease(String chronicDisease) {
    this.chronicDisease = chronicDisease;
  }

  public String getInsuranceNo() {
    return insuranceNo;
  }

  public void setInsuranceNo(String insuranceNo) {
    this.insuranceNo = insuranceNo;
  }

  public String getDonorCardNo() {
    return donorCardNo;
  }

  public void setDonorCardNo(String donorCardNo) {
    this.donorCardNo = donorCardNo;
  }

  public String getFamilyMemberCode() {
    return familyMemberCode;
  }

  public void setFamilyMemberCode(String familyMemberCode) {
    this.familyMemberCode = familyMemberCode;
  }

  public String getVolunteer() {
    return volunteer;
  }

  public void setVolunteer(String volunteer) {
    this.volunteer = volunteer;
  }

  @Override
  public void getDetails() {
    try {
      String temp;
      System.out.println("Enter your Blood Group:");
      temp = scanner.nextLine();
      while (!validate.validateBloodGroup(temp)) {
        System.out.println("Re-Enter Blood Group: ");
        temp = scanner.nextLine();
      }
      setBloodGroup(temp);

      System.out.println("Enter information for Allergies(if there are otherwise enter Null):");
      temp = scanner.nextLine();
      while (!validate.validateAlphanumeric(temp)) {
        System.out.println("Re-Enter information for Allergies(if there are otherwise enter Null): ");
        temp = scanner.nextLine();
      }
      setAllergy(temp);

      System.out.println("Enter Chronic disease if any(otherwise enter null):");
      temp = scanner.nextLine();
      while (!validate.validateAlphanumeric(temp)) {
        System.out.println("Re-Enter Chronic disease if any(otherwise enter null): ");
        temp = scanner.nextLine();
      }
      setChronicDisease(temp);

      System.out.println("Enter your insurance number:");
      temp = scanner.nextLine();
      while (!validate.validateAlphanumeric(temp)) {
        System.out.println("Re-Enter your insurance number:");
        temp = scanner.nextLine();
      }
      setInsuranceNo(temp);

      System.out.println("Enter your donar card number: ");
      temp = scanner.nextLine();
      while (!validate.validateAlphanumeric(temp)) {
        System.out.println("Re-Enter your donar card number: ");
        temp = scanner.nextLine();
      }
      setDonorCardNo(temp);

      System.out.println("Enter your family member identity code:");
      temp = scanner.nextLine();
      while (!validate.validateAlphanumeric(temp)) {
        System.out.println("Re-Enter your family member identity code: ");
        temp = scanner.nextLine();
      }
      setFamilyMemberCode(temp);

      System.out.println("If would you like to be a volunteer please enter yes otherwise no:");
      temp = scanner.nextLine();
      while (!validate.validateVolunteer(temp)) {
        System.out.println("Re-Enter Correct Choice: ");
        temp = scanner.nextLine();
      }
      setVolunteer(temp);

    } catch (Exception e) {
      System.out.println("Patient Details Encountered Error " + e);
    }
  }
}
