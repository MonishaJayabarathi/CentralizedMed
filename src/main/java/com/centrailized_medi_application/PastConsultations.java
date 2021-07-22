package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Monisha J
 * @description : This class in responsible to handle Patients.
 * This retrieves and displays the list of patients consulted the doctor.
 */
public class PastConsultations {
  DB_Layer layer = new DB_Layer();
  private String doctorUsername = null;
  private ArrayList<ArrayList<String>> patientsList = new ArrayList<ArrayList<String>>();

  public PastConsultations(DbConnection connection, String doc_name) throws SQLException, IOException, ClassNotFoundException {
    doctorUsername = doc_name;
  }

  public void retrievePatientDetails(String patientName, String date) throws SQLException, IOException, ClassNotFoundException {

    ResultSet resultSet = layer.getUserDetails(patientName,"Patient");
    while (resultSet.next()) {
      ArrayList<String> resultRow = new ArrayList<String>();
      resultRow.add(resultSet.getString("firstname"));
      resultRow.add(resultSet.getString("lastname"));
      resultRow.add(date);
      resultRow.add(resultSet.getString("id"));
      resultRow.add(resultSet.getString("bloodGroup"));
      resultRow.add(resultSet.getString("contactNo"));
      patientsList.add(resultRow);
    }

  }

  public void retrievePatients() throws SQLException, IOException, ClassNotFoundException {
    ResultSet resultSet = layer.fetchPastConsultations(doctorUsername);
    while (resultSet.next()) {
      retrievePatientDetails(resultSet.getString("patientUsername"), resultSet.getString("consultationDateTime"));
    }

  }

  public String getPreviousConsultations() throws SQLException {
    try {
      this.retrievePatients();
    } catch (SQLException | IOException | ClassNotFoundException throwables) {
      throwables.printStackTrace();
    }

    StringBuilder pList = new StringBuilder();
    pList.append("PAST CONSULTATIONS\n");

    for (ArrayList<String> patient : patientsList) {
      String singlePatient = "*******************************************" + "\n" +
          "First Name: " + patient.get(0) + "\n" +
          "Last Name: " + patient.get(1) + "\n" +
          "Last Consultation: " + patient.get(2) + "\n" +
          "Patient ID: " + patient.get(3) + "\n" +
          "Blood Group: " + patient.get(4) + "\n" +
          "Contact No: " + patient.get(5) + "\n" +
          "\n";
      pList.append(singlePatient);
    }
    return pList.toString();
  }

}
