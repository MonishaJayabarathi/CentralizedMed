package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PatientSuggestionsTest {
    public static final String patientUserName = "patient1";

    @Test
    void constructor(){
        PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
        assertEquals("patient1", patientSuggestions.userName);
    }

    @Test
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

    @Test
    void getSuggestedDoctors() {
        String expectedDoctorsList =
                "SUGGESTED DOCTORS\n" +
                "*******************************************\n" +
                "First Name: Shaun\n" +
                "Last Name: Koker\n" +
                "Specialization: Gynaecology\n" +
                "Clinic Address: Delhi\n" +
                "Distance: 4 km\n" +
                "Average Rating: Twice a day\n" +
                "Contact Number: 009988776655\n" +
                "No Medications\n" +
                "\n" +
                "*******************************************\n" +
                "First Name: James\n" +
                "Last Name: Blunt\n" +
                "Specialization: Physician\n" +
                "Clinic Address: Delhi\n" +
                "Distance: 4 km\n" +
                "Average Rating: Twice a day\n" +
                "Contact Number: 009988776655\n" +
                "No Medications\n" +
                "\n";


        PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
        String actualDoctorsList = patientSuggestions.getSuggestedDoctors();

        assertEquals(expectedDoctorsList, actualDoctorsList);

    }
}