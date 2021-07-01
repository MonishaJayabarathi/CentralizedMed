package com.centrailized_medi_application;

import java.sql.*;
import java.util.ArrayList;

/* Class representing prescription of a patient */
public class PatientPrescription {
    private ArrayList<ArrayList<Object>> medicationList;

    /* given patientID, return prescription details from DB
     * connect to DB
     * execute sql query
     * return DB query output */
    public PatientPrescription(int patientID){

    }

    /* return patient prescription resultset which is retrieved from database */
    public ArrayList<ArrayList<Object>> getPrescriptionList(){
        return medicationList;
    }


    /* print prescription details to patient
     * format medication */
    public String getPrescriptionFromDB(ResultSet resultSet){
        return "";
    }

}
