package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientSuggestionsTest {
    public static final String patientUserName = "patient1";

    @Test
    void setLatLon() {
        PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
        patientSuggestions.setLatLon();
        assertEquals(52.631, patientSuggestions.latitude);
        assertEquals(5.571, patientSuggestions.longitude);
    }

    @Test
    void getLatLon() {
    }

    @Test
    void setSpecialization() {
    }

    @Test
    void retrieveDoctorSuggestions() {
    }

    @Test
    void getSuggestedDoctors() {
    }
}