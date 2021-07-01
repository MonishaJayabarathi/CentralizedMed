package com.centrailized_medi_application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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
                    "SELECT BrandName, GenericName, Route, Strength, Amount, Frequency, TimeOfDay " +
                            "FROM Patients, MedicationGeneral, MedicationSpecific\n" +
                            "WHERE Patients.PatientID = 1;");

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

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }

    /* return patient medication list which is retrieved from database */
    public ArrayList<ArrayList<String>> getPrescriptionList(){
        return medicationList;
    }


    /* print prescription details to patient
     * format medication */
    public String getPrescriptionFromDB(ResultSet resultSet){
        return "";
    }

}
