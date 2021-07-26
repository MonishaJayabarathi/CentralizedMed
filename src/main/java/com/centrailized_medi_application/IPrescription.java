package com.centrailized_medi_application;

import java.util.ArrayList;

public interface IPrescription {

  void setMedicationList(ArrayList<ArrayList<String>> medicationList);

  String getPatientUserName();

  void getPrescriptionList(IPrescriptionPersistence prescriptionPersistence);

  ArrayList<ArrayList<String>> getMedicationList();

}
