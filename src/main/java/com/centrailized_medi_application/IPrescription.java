package com.centrailized_medi_application;

import java.util.ArrayList;

public interface IPrescription {

  String getPatientUserName();

  void setPatientUserName(String patientUserName);

  void setMedicationList(ArrayList<ArrayList<String>> medicationList);

  void getPrescriptionList(IPrescriptionPersistence prescriptionPersistence);

  ArrayList<ArrayList<String>> getMedicationList();

  ArrayList<ArrayList<String>> getMedicationsByDoctor();

  void setMedicationsByDoctor(ArrayList<ArrayList<String>> medications);

}
