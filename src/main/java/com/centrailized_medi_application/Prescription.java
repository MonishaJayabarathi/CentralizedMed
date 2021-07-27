package com.centrailized_medi_application;

import java.util.ArrayList;

/* Class representing prescription of a patient */
public class Prescription implements IPrescription{
  private ArrayList<ArrayList<String>> medicationList;
  private String patientUserName;
  private ArrayList<ArrayList<String>> medications;

  /* given patientID, return prescription details from DB
   * connect to DB
   * execute sql query
   * return DB query output */
  public Prescription(String patientUserName) {
    this.patientUserName = patientUserName;
  }

  public String getPatientUserName(){
    return patientUserName;
  }

  public void setPatientUserName(String patientUserName) {
    this.patientUserName = patientUserName;
  }

  public ArrayList<ArrayList<String>> getMedicationList(){
    return medicationList;
  }

  public void setMedicationList(ArrayList<ArrayList<String>> medicationList){
    this.medicationList = medicationList;
  }

  /* return patient medication list which is retrieved from database */
  public void getPrescriptionList(IPrescriptionPersistence prescriptionPersistence) {
    prescriptionPersistence.loadPrescription(this);
  }

  public ArrayList<ArrayList<String>> getMedicationsByDoctor(){
    return medications;
  }

  public void setMedicationsByDoctor(ArrayList<ArrayList<String>> medications) {
    this.medications = medications;
  }

  public void saveMedicationList(IPrescriptionPersistence prescriptionPersistence){

  }

}
