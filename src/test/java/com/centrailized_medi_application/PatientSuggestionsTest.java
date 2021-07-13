package com.centrailized_medi_application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PatientSuggestionsTest {
    public static final String patientUserName = "patient1@gmail.com";

    @Test
    @DisplayName("To get patient's user name")
    void constructor(){
        PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
        assertEquals("patient1@gmail.com", patientSuggestions.userName);
    }

    @Test
    @DisplayName("To get patient's latitude and longitude")
    void setLatLon() throws SQLException, IOException, ClassNotFoundException {
        PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
        patientSuggestions.setLatLon();

        assertEquals(50.11, patientSuggestions.latitude);
        assertEquals(5.28, patientSuggestions.longitude);
    }

    /*@Test
    void setSpecialization() {
        PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
        patientSuggestions.setSpecialization();

        assertEquals();
    }*/

    /*@Test
    void retrieveDoctorSuggestions() {

    }*/

    @Disabled("Disabled because it asks for user input")
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
        patientSuggestions.setLatLon();
        patientSuggestions.setSpecialization();
        String actualDoctorsList = patientSuggestions.getSuggestedDoctors();
        assertEquals(expectedDoctorsList, actualDoctorsList);

    }

    @Disabled("Asks for user input")
    @Test
    void rateDocter() throws SQLException, IOException, ClassNotFoundException {
        PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
        assertTrue(patientSuggestions.rateDoctor(),"Incorrect result");

    }
}