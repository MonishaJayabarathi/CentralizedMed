package com.centrailized_medi_application;

public interface ISuggestionsPersistence {

  void loadPatientLatLon(IPatientSuggestions patientSuggestions);
  void loadDoctorSuggestions(IPatientSuggestions patientSuggestions);


}
