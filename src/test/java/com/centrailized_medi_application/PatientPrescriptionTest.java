package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;

import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PatientPrescriptionTest {

    /* PatientPrescription retrieves the correct prescription from the database for current patient */
    @Test
    void PatientPrescription(){
        String expectedMedicationList = "1, Amodis, Metronidazole BP, By Mouth, 400, 1, Twice a day";

        PatientPrescription patientPrescription = new PatientPrescription(1);
        ArrayList<ArrayList<Object>> medicationList = patientPrescription.getPrescriptionList();
        StringBuilder actualMedicationList = new StringBuilder();
        for (Object medication: medicationList){
            actualMedicationList.append((String) medication);
        }

        assertEquals(expectedMedicationList, actualMedicationList.toString(),
                "PatientPrescription() constructor did not process the correct medication list ");
    }


}