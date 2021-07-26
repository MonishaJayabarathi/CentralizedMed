package com.centrailized_medi_application;

/*Importing Module*/

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aditya Jain
 * @description: PatientPage is an concrete class and extended Patient Dashboard
 * It overrides methods such as displayAbout(), displayConsultations(), displayPrescriptions()
 * displaySuggestions(), displayLogout().
 */
public class PatientPage extends PatientDashboard {
  private String userName;


  /**
   * Constructor with Patient's username as input parameter
   *
   * @Param String userName as Patients's username
   */
  public PatientPage(String userName) {
    this.userName = userName;
  }

  /**
   * This method is responsible for displaying Patient's details
   *
   * @return None
   * @Param None
   */
  @Override
  public void displayAbout() throws SQLException, IOException, ClassNotFoundException {
    AboutPatient aboutPatient = new AboutPatient(this.userName, this); //testing commit
    AboutPatientPage aboutPatientpage = new AboutPatientPage(aboutPatient);
    aboutPatientpage.display();
  }

  /**
   * This method is responsible for displaying Patient's Consulations
   *
   * @return None
   * @Param None
   */
  @Override
  public void displayConsultations() throws SQLException, IOException, ClassNotFoundException {
    PatientSuggestions patientSuggestions = new PatientSuggestions(userName);
    patientSuggestions.rateDoctor();
  }

  /**
   * This method is responsible for displaying Patient's General & Specific Prescription
   *
   * @return None
   * @Param None
   */
  @Override
  public void displayPrescriptions() throws SQLException, IOException, ClassNotFoundException {

    Prescription prescription = new Prescription(userName);
    PrescriptionDL prescriptionDL = new PrescriptionDL();
    prescription.getPrescriptionList(prescriptionDL);
    String medicationList = PrescriptionPL.displayPrescription(prescription);
    System.out.println(medicationList);
    PatientPage patientPage = new PatientPage(userName);
    patientPage.display();
  }

  /**
   * This method is responsible for displaying suggestion to Patient based on their convience.
   * Like the type of doctor(based on doctor's practice) they wish to visit and whats the distance
   * towards the clinic
   *
   * @return None
   * @Param None
   */
  @Override
  public void displaySuggestions() throws SQLException, IOException, ClassNotFoundException {
    PatientSuggestions patientSuggestions = new PatientSuggestions(userName);
    patientSuggestions.setLatLon();
    patientSuggestions.setSpecializationByPatient();
    System.out.println(patientSuggestions.getSuggestedDoctors());
    PatientPage patientPage = new PatientPage(userName);
    patientPage.display();
  }

  /**
   * This method is responsible for logging out.
   *
   * @return None
   * @Param None
   */
  @Override
  public void displayLogout(){
    System.out.println("User has been successfully logged out !");
    WelcomePage back_to_menu = new WelcomePage();
    back_to_menu.display();
  }
}