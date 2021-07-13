package com.centrailized_medi_application;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientSuggestions {
    public String userName;
    public double latitude;
    public double longitude;
    private String suggestedDoctors;
    private String specialization;
    private ArrayList<ArrayList<String>> doctorsList = new ArrayList<ArrayList<String>>();

    /* initialize the class using patient username */
    public PatientSuggestions(String userName){
        this.userName = userName;

    }

    /* use patient username to retrieve latitude longitude for the patient
     * connect to patient's information table
     * use patient username to retrieve latitude longitude
     */
    public void setLatLon() throws SQLException, IOException, ClassNotFoundException {
        DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
        Connection connection = one.createConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM patient_info;");

        while (resultSet.next()) {
            this.latitude = resultSet.getDouble("latitude");
            this.longitude = resultSet.getDouble("longitude");
        }

    }


    /* ask patient input for specialization */
    public void setSpecialization() {
        Scanner inputSpecialization = new Scanner(System.in);
        this.specialization = inputSpecialization.nextLine();
    }

    /* for current patient retrieve top rated specialized doctors within 10km
     * connect to doctors table in DB
     * filter doctors using specialization
     * filter doctors by considering doctors within 10km radius of patient
     * order doctors by their ratings
     */
    public void retrieveDoctorSuggestions(){



    }

    /* getter function for list of suggested doctors */
    public String getSuggestedDoctors(){
        this.retrieveDoctorSuggestions();


        return suggestedDoctors;
    }



}
