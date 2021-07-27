package com.centrailized_medi_application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PrescriptionDL implements IPrescriptionPersistence {

  @Override
  public void loadPrescription(IPrescription prescription) {
    ArrayList<ArrayList<String>> medicationList = new ArrayList<>();
    String patientUserName = prescription.getPatientUserName();

    try {
      DbConnection one = new DB_Connection();
      Connection connection = one.createConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(
          "SELECT BrandName, GenericName, Route, Strength, Amount, Frequency, TimeOfDay FROM patient_info, MedicationGeneral, MedicationSpecific, PatientMedication\n" +
              "WHERE patient_info.emailId = '" + patientUserName + "' AND\n" +
              "\tMedicationSpecific.MedicationGeneralID = MedicationGeneral.MedicationGeneralID AND\n" +
              "    patient_info.id = PatientMedication.id AND\n" +
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
        medicationList.add(resultRow);
      }

      resultSet.close();
      statement.close();
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    prescription.setMedicationList(medicationList);
  }
}
