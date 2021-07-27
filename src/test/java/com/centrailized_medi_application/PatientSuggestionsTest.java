package com.centrailized_medi_application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PatientSuggestionsTest {
  public static final String patientUserName = "Ridam@gmail.com";
  String environment = "src/main/resources/config_test.properties";

  @Test
  @DisplayName("To get patient's user name")
  void constructor() throws SQLException, IOException, ClassNotFoundException {
    PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
    assertEquals(patientUserName, patientSuggestions.getPatientUserName());
  }

  @Test
  @DisplayName("To get patient's latitude and longitude")
  void setLatLon() throws SQLException, IOException, ClassNotFoundException {
    PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
    PatientSuggestionsDL patientSuggestionsDL = new PatientSuggestionsDL();
    patientSuggestions.getPatientLatLon(patientSuggestionsDL);

    assertEquals(50.11, patientSuggestions.getLatitude());
    assertEquals(5.28, patientSuggestions.getLongitude());
  }

  @Test
  @DisplayName("Check if suggested doctors list is correct")
  void getSuggestedDoctors() throws SQLException, IOException, ClassNotFoundException {
    String expectedDoctorsList =
        "SUGGESTED DOCTORS\n" +
            "*******************************************\n" +
            "First Name: Shaun\n" +
            "Last Name: Koker\n" +
            "Specialization: Gynaecology\n" +
            "Clinic Address: Delhi\n" +
            "Distance: 2.2 km\n" +
            "Average Rating: 5.0\n" +
            "Contact Number: 009988776655\n" +
            "\n" +
            "*******************************************\n" +
            "First Name: James\n" +
            "Last Name: Blunt\n" +
            "Specialization: Gynaecology\n" +
            "Clinic Address: Delhi\n" +
            "Distance: 3.3 km\n" +
            "Average Rating: 4.0\n" +
            "Contact Number: 009988776656\n" +
            "\n";


    PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
    PatientSuggestionsDL patientSuggestionsDL = new PatientSuggestionsDL();
    patientSuggestions.getPatientLatLon(patientSuggestionsDL);
    patientSuggestions.setSpecialization("Gynaecology");
    patientSuggestions.getSuggestedDoctors(patientSuggestionsDL);
    String actualDoctorsList = PatientSuggestionsPL.viewSuggestedDoctors(patientSuggestions);
    assertEquals(expectedDoctorsList, actualDoctorsList);

  }

  @Disabled("Asks for user input")
  @Test
  void rateDocter() throws SQLException, IOException, ClassNotFoundException {
    PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
    assertTrue(patientSuggestions.rateDoctor(), "Incorrect result");

  }
}