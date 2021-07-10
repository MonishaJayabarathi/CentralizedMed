package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddPatientTest {

  String environment = "src/main/resources/config_test.properties";
  @Test
  public void fetch_details_and_add() throws SQLException, IOException, ClassNotFoundException {
    String docter_name = "key@gmail.com";
    String docter_pass = "k123";
    boolean exist = true;
    String patient_name = "Aditya@hotmail.com";
    DB_Connection db_access = new DB_Connection(environment,patient_name,null);
    AddPatient new_entry = new AddPatient(db_access);
    assertEquals(exist, new_entry.verify_patient(patient_name), "Patient is not registered into the system");

  }

}