package com.centrailized_medi_application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

/* Class representing prescription of a patient */
public class PatientPrescription {
    private ArrayList<ArrayList<String>> medicationList = new ArrayList<ArrayList<String>>();

    /* given patientID, return prescription details from DB
     * connect to DB
     * execute sql query
     * return DB query output */
    public PatientPrescription(int patientID){
        try {
            // Load a connection library between Java and the database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception ex) {
                System.out.println("Error connecting to jdbc");
            }

            // retrieve credentials from properties file
            FileInputStream testEnvironmentCred = new FileInputStream("src/main/resources/config_test.properties");
            Properties testCredentials = new Properties();
            testCredentials.load(testEnvironmentCred);
            String hostName = testCredentials.getProperty("database");
            String userName = testCredentials.getProperty("user");
            String password = testCredentials.getProperty("password");

            // connect to test database and execute query
            Connection connection = DriverManager.getConnection(hostName, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT BrandName, GenericName, Route, Strength, Amount, Frequency, TimeOfDay FROM Patients, MedicationGeneral, MedicationSpecific, PatientMedication\n" +
                            "WHERE Patients.PatientID = "+ Integer.toString(patientID) +" AND\n" +
                            "\tMedicationSpecific.MedicationGeneralID = MedicationGeneral.MedicationGeneralID AND\n" +
                            "    Patients.PatientID = PatientMedication.PatientID AND\n" +
                            "    MedicationSpecific.MedicationSpecificID = PatientMedication.MedicationSpecificID;");

            // add the retrieved medication list to class arraylist of medications
            while (resultSet.next()) {
                ArrayList<String> resultRow = new ArrayList<String>();
                resultRow.add(resultSet.getString("BrandName"));
                resultRow.add(resultSet.getString("GenericName"));
                resultRow.add(resultSet.getString("Route"));
                resultRow.add(Integer.toString(resultSet.getInt("Strength")));
                resultRow.add(Integer.toString(resultSet.getInt("Amount")));
                resultRow.add(resultSet.getString("Frequency"));
                resultRow.add(resultSet.getString("TimeOfDay"));
                this.medicationList.add(resultRow);

            }
            connection.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    /* return patient medication list which is retrieved from database */
    public ArrayList<ArrayList<String>> getPrescriptionList(){
        return medicationList;
    }


    /* format prescription details for viewing in interface
     */
    public String formatPrescription(){
        StringBuilder formattedPrescription = new StringBuilder();
        formattedPrescription.append("PRESCRIPTIONS\n");

        // format headings for medication of each time of day
        StringBuilder morningMedications = new StringBuilder();
        morningMedications.append("*******************************************\n" +
                "Time of day: Morning\n");
        StringBuilder eveningMedications = new StringBuilder();
        eveningMedications.append("*******************************************\n" +
                "Time of day: Evening\n");
        StringBuilder nightMedications = new StringBuilder();
        nightMedications.append("*******************************************\n" +
                "Time of day: Night\n");

        // counters to keep track of number of medications for each time of day
        int morningCounter = 0;
        int eveningCounter = 0;
        int nightCounter = 0;

        // iterate over medication list retrieved from DB and add to appropriate time of day stringBuilder
        for (ArrayList<String> medication: medicationList){
            StringBuilder singleMedication = new StringBuilder();
            singleMedication.append("   MEDICATION\n");
            singleMedication.append("   Brand Name : ").append(medication.get(0)).append("\n");
            singleMedication.append("   Generic Name : ").append(medication.get(1)).append("\n");
            singleMedication.append("   Route : ").append(medication.get(2)).append("\n");
            singleMedication.append("   Strength : ").append(medication.get(3)).append(" mg\n");
            singleMedication.append("   Amount : ").append(medication.get(4)).append(" Tablet\n");
            singleMedication.append("   Frequency : ").append(medication.get(5)).append("\n");
            singleMedication.append("\n");

            if (medication.get(6).equals("Morning")){
                morningMedications.append(singleMedication);
                morningCounter += 1;
            } else if (medication.get(6).equals("Evening")){
                eveningMedications.append(singleMedication);
                eveningCounter += 1;
            } else if (medication.get(6).equals("Night")){
                nightMedications.append(singleMedication);
                nightCounter += 1;
            }
        }

        // check if any time of day has zero medications and format the prescription accordingly
        if (morningCounter == 0){ morningMedications.append("No Medications\n");}
        if (eveningCounter == 0){ eveningMedications.append("No Medications\n");}
        if (nightCounter == 0){ nightMedications.append("No Medications\n");}

        // append medications from each time of day into a final prescription
        formattedPrescription.append(morningMedications).append(eveningMedications).append(nightMedications);

        return formattedPrescription.toString();
    }

}
