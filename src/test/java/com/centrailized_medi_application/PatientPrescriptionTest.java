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
        String expectedMedicationList = "Amodis, Metronidazole BP, By Mouth, 400, 1, Twice a day, Morning, ";

        PatientPrescription patientPrescription = new PatientPrescription(1);
        ArrayList<ArrayList<String>> medicationList = patientPrescription.getPrescriptionList();
        StringBuilder actualMedicationList = new StringBuilder();
        for (ArrayList<String> medication: medicationList){
            StringBuilder singleMedicationDetails = new StringBuilder();
            for (String medicationDetails: medication){
                singleMedicationDetails.append(medicationDetails);
                singleMedicationDetails.append(", ");
            }
            actualMedicationList.append(singleMedicationDetails.toString());
        }

        assertEquals(expectedMedicationList, actualMedicationList.toString());
    }

    /* formatPrescription() structures the DB results into suitable format for user */
    @Test
    void formatPrescription(){
        String expectedPrescriptionFormat =
                "PRESCRIPTIONS\n" +
                "*******************************************\n" +
                "Time of day: Morning\n" +
                "   Medication 1\n" +
                "   Brand Name : Amodis\n" +
                "   Generic Name : Metronidazole BP\n" +
                "   Strength : 400 mg" +
                "   Amount : 1 Tab\n" +
                "   Route : By Mouth\n" +
                "   Frequency : Twice a day";

        PatientPrescription patientPrescription = new PatientPrescription(1);
        String actualPrescriptionFormat = patientPrescription.formatPrescription();

        assertEquals(expectedPrescriptionFormat, actualPrescriptionFormat);
    }


}