package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class AddPatientTest {

  String environment = "src/main/resources/config_test.properties";
  @Test
  public void fetch_details_and_add() throws SQLException, IOException, ClassNotFoundException {
    boolean exist = true;
    String doc_name = "key@gmail.com";
    String patient_name = "Aditya@hotmail.com";
    DB_Connection db_access = new DB_Connection(environment,patient_name,null);
    AddPatient new_entry = new AddPatient(db_access,doc_name);
    assertEquals(exist, new_entry.verify_patient(patient_name), "Patient is not registered into the system");

  }

  @Test
  public void fetch_details_and_add_invalid() throws SQLException, IOException, ClassNotFoundException {
    boolean exist = false;
    String doc_name = "key@gmail.com";
    String patient_name = "Nihal@hotmail.com";
    DB_Connection db_access = new DB_Connection(environment,patient_name,null);
    AddPatient new_entry = new AddPatient(db_access,doc_name);
    assertEquals(exist, new_entry.verify_patient(patient_name), "Patient is registered into the system");
  }

  @Test
  public void link_patient_with_doc() throws SQLException, IOException, ClassNotFoundException { String docter_name = "key@gmail.com";
    String patient_name = "Aditya@hotmail.com";
    DB_Connection db_access = new DB_Connection(environment,patient_name,null);
    String doc_name = "key@gmail.com";
    AddPatient new_entry = new AddPatient(db_access,doc_name);
    if(new_entry.verify_patient(patient_name))
    {
      assertEquals("Added Successfully!", new_entry.link_patient(),"Could not add patient");
    }

  }

}