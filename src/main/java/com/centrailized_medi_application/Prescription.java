package com.centrailized_medi_application;

import java.util.ArrayList;

/* Class representing prescription of a patient */
public class Prescription implements IPrescription{
  private ArrayList<ArrayList<String>> medicationList;
  private String patientUserName;

  /* given patientID, return prescription details from DB
   * connect to DB
   * execute sql query
   * return DB query output */
  public Prescription(String patientUserName) {
    this.patientUserName = patientUserName;
  }

  public void setMedicationList(ArrayList<ArrayList<String>> medicationList){
    this.medicationList = medicationList;
  }

  public String getPatientUserName(){
    return patientUserName;
  }

  /* return patient medication list which is retrieved from database */
  public void getPrescriptionList(IPrescriptionPersistence prescriptionPersistence) {
    prescriptionPersistence.loadPrescription(this);
  }

  public ArrayList<ArrayList<String>> getMedicationList(){
    return medicationList;
  }

}
