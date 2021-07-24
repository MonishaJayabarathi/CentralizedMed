package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class AddPatientTest {

  String environment = "src/main/resources/config_test.properties";
  @Test
  public void fetch_details_and_add() throws SQLException, IOException, ClassNotFoundException {
    boolean exist = true;
    String doc_name = "key@gmail.com";
    String patient_name = "Aditya@hotmail.com";
    AddPatient new_entry = new AddPatient(doc_name);
    assertEquals(exist, new_entry.patientPresence(patient_name), "Patient is not registered into the system");
  }

  @Test
  public void fetch_details_and_add_invalid() throws SQLException, IOException, ClassNotFoundException {
    boolean exist = false;
    String doc_name = "key@gmail.com";
    String patient_name = "Nihal@hotmail.com";
    AddPatient new_entry = new AddPatient(doc_name);
    assertEquals(exist, new_entry.patientPresence(patient_name), "Patient is registered into the system");
  }

  @Test
  public void link_Valid_patient() throws SQLException, IOException, ClassNotFoundException {
    String docter_name = "key@gmail.com";
    String patient_name = "Aditya@hotmail.com";
    AddPatient new_entry = new AddPatient(docter_name);
    assertTrue(new_entry.link_patient(patient_name), "Could not add patient");
  }

}