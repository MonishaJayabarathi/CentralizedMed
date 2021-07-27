package com.centrailized_medi_application;

import java.util.ArrayList;

public interface IPatientSuggestions {

  String getPatientUserName();

  double getLatitude();

  double getLongitude();

  void setLatitude(double latitude);

  void setLongitude(double longitude);

  String getSpecialization();

  void setSpecialization(String specialization);

  ArrayList<ArrayList<String>> getDoctorsList();

  void setDoctorsList( ArrayList<ArrayList<String>> doctorsList);


}
