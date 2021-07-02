package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;

import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PatientPrescriptionTest {

    /* PatientPrescription retrieves the correct prescription from the database for current patient with one medication*/
    @Test
    void PatientPrescription_oneMedication(){
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

    /* PatientPrescription retrieves the correct prescription from the database for current patient with
     * a total of four medications prescribed for all three times of the day */
    @Test
    void PatientPrescription_manyMedications(){
        String expectedMedicationList = "Amodis, Metronidazole BP, By Mouth, 400, 1, Twice a day, Morning, " +
                "Flonase, Fluticasone, By Mouth, 200, 1, Once a day, Morning, " +
                "Fosamax, Alendronate, By Mouth, 400, 1, Twice a day, Evening, " +
                "Glucophage, Melformin, By Mouth, 100, 1, Once a day, Night, ";

        PatientPrescription patientPrescription = new PatientPrescription(2);
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

    /* formatPrescription() structures the DB results into suitable format for user with one medication */
    @Test
    void formatPrescription_oneMedication(){
        String expectedPrescriptionFormat =
                "PRESCRIPTIONS\n" +
                "*******************************************\n" +
                "Time of day: Morning\n" +
                "   MEDICATION\n" +
                "   Brand Name : Amodis\n" +
                "   Generic Name : Metronidazole BP\n" +
                "   Route : By Mouth\n" +
                "   Strength : 400 mg\n" +
                "   Amount : 1 Tablet\n" +
                "   Frequency : Twice a day\n" +
                "\n" +
                "*******************************************\n" +
                "Time of day: Evening\n" +
                "No Medications\n" +
                "*******************************************\n" +
                "Time of day: Night\n" +
                "No Medications\n";

        PatientPrescription patientPrescription = new PatientPrescription(1);
        String actualPrescriptionFormat = patientPrescription.formatPrescription();

        assertEquals(expectedPrescriptionFormat, actualPrescriptionFormat);
    }

    /* formatPrescription() structures the DB results into suitable format for user with many medications */
    @Test
    void formatPrescription_manyMedications(){
        String expectedPrescriptionFormat =
                "PRESCRIPTIONS\n" +
                        "*******************************************\n" +
                        "Time of day: Morning\n" +
                        "   MEDICATION\n" +
                        "   Brand Name : Amodis\n" +
                        "   Generic Name : Metronidazole BP\n" +
                        "   Route : By Mouth\n" +
                        "   Strength : 400 mg\n" +
                        "   Amount : 1 Tablet\n" +
                        "   Frequency : Twice a day\n" +
                        "\n" +
                        "   MEDICATION\n" +
                        "   Brand Name : Flonase\n" +
                        "   Generic Name : Fluticasone\n" +
                        "   Route : By Mouth\n" +
                        "   Strength : 200 mg\n" +
                        "   Amount : 1 Tablet\n" +
                        "   Frequency : Once a day\n" +
                        "\n" +
                        "*******************************************\n" +
                        "Time of day: Evening\n" +
                        "   MEDICATION\n" +
                        "   Brand Name : Fosamax\n" +
                        "   Generic Name : Alendronate\n" +
                        "   Route : By Mouth\n" +
                        "   Strength : 400 mg\n" +
                        "   Amount : 1 Tablet\n" +
                        "   Frequency : Twice a day\n" +
                        "\n" +
                        "*******************************************\n" +
                        "Time of day: Night\n" +
                        "   MEDICATION\n" +
                        "   Brand Name : Glucophage\n" +
                        "   Generic Name : Melformin\n" +
                        "   Route : By Mouth\n" +
                        "   Strength : 100 mg\n" +
                        "   Amount : 1 Tablet\n" +
                        "   Frequency : Once a day\n" +
                        "\n";

        PatientPrescription patientPrescription = new PatientPrescription(2);
        String actualPrescriptionFormat = patientPrescription.formatPrescription();

        assertEquals(expectedPrescriptionFormat, actualPrescriptionFormat);
    }


}