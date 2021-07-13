package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PatientSuggestionsTest {
    public static final String patientUserName = "patient1";

    @Test
    void setLatLon() throws SQLException, IOException, ClassNotFoundException {
        PatientSuggestions patientSuggestions = new PatientSuggestions(patientUserName);
        patientSuggestions.setLatLon();

        assertEquals(50.11d, patientSuggestions.latitude);
        assertEquals(5.28, patientSuggestions.longitude);
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