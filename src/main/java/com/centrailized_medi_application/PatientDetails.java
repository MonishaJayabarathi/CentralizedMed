package com.centrailized_medi_application;

import java.util.Scanner;

public class PatientDetails implements Details{
    private String bloodGroup;
    private String allergy;
    private String chronicDisease;
    private String insuranceNo;
    private String donorCardNo;
    private String familyMemberCode;
    private String volunteer;
    protected Scanner scanner = new Scanner(System.in);

    public String getBloodGroup() { return bloodGroup; }

    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getAllergy() { return allergy; }

    public void setAllergy(String allergy) { this.allergy = allergy; }

    public String getChonicDisease() { return chronicDisease; }

    public void setChronicDisease(String chronicDisease) { this.chronicDisease = chronicDisease; }

    public String getInsuranceNo() { return  insuranceNo; }

    public void setInsuranceNo(String insuranceNo){ this.insuranceNo = insuranceNo; }

    public String getDonorCardNo() { return donorCardNo; }

    public void setDonorCardNo(String donorCardNo){ this.donorCardNo = donorCardNo; }

    public String getFamilyMemberCode(){ return familyMemberCode; }

    public void setFamilyMemberCode(String familyMemberCode){ this.familyMemberCode = familyMemberCode; }

    public String getVolunteer() { return volunteer; }

    public void setVolunteer(String volunteer){ this.volunteer = volunteer; }

    @Override
    public void getDetails() {
        try {
            System.out.println("Enter your Blood Group:");
            String bloodGroup = scanner.nextLine();
            setBloodGroup(bloodGroup);

            System.out.println("Enter information for Allergies(if there are otherwise enter Null):");
            String allergy = scanner.nextLine();
            setAllergy(allergy);

            System.out.println("Enter Chronic disease if any(otherwise enter null):");
            String chronicDisease = scanner.nextLine();
            setChronicDisease(chronicDisease);

            System.out.println("Enter your insurance number:");
            String insuranceNo = scanner.nextLine();
            setInsuranceNo(insuranceNo);

            System.out.println("Enter your donar card number (if you have):");
            String donorCardNo = scanner.nextLine();
            setDonorCardNo(donorCardNo);

            System.out.println("Enter your family members identity code:");
            String familyMemberCode = scanner.nextLine();
            setFamilyMemberCode(familyMemberCode);

            System.out.println("If would you like to be a volunteer please enter yes otherwise no:");
            String volunteer = scanner.nextLine();
            setVolunteer(volunteer);

        } catch (Exception e) {
            System.out.println("Patient Details Encountered Error " + e);
        }
    }
}
