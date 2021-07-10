package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddPatientTest {


  @Test
  public void fetch_details_and_add() {
    String docter_name = "key@gmail.com";
    String docter_pass = "k123";
    boolean exist = true;
    String patient_name = "Aditya@hotmail.com";
    AddPatient new_entry = new AddPatient();
    assertEquals(exist, new_entry.verify_patient(patient_name), "Patient is not registered into the system");

  }

}