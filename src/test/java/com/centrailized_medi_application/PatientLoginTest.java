package com.centrailized_medi_application;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;

class PatientLoginTest {

  String environment = "src/main/resources/config_test.properties";
  /* To verify the set func for login Patient (username)*/

  @Test
  void setPatient_name() throws SQLException, IOException, ClassNotFoundException {
    String userName = "Aditya@hotmail.com";
    String password = "a1234";
    Patient p1 = new Patient(new WelcomePage(), new PatientPage(userName), new DB_Connection(environment, userName, password));
    PatientLogin p_login = new PatientLogin(p1, new WelcomePage());  // Passing the object to the patient login
    p_login.setPatientName(userName);
    assertEquals(userName, p_login.getPatientName(), "Error: Incorrect Name");
  }

  /*Check against empty string for username*/
  @Disabled("setPatient_name_only_char->Calls user input after it succeeds,hence ignored")
  @Test
  void setPatient_name_only_char() throws SQLException, IOException, ClassNotFoundException {
    String userName = "Aditya1234";
    String password = "a1234";
    Patient p1 = new Patient(new WelcomePage(), new PatientPage(userName), new DB_Connection(environment, userName, password));
    PatientLogin p_login = new PatientLogin(p1, new WelcomePage());  // Passing the object to the patient login
    p_login.setPatientName(userName);
    assertNull(p_login.getPatientName());
  }

  /* To verify the set func for login Patient (password)*/

  @Test
  void setPatient_pass() throws SQLException, IOException, ClassNotFoundException {
    String userName = "Aditya";
    String password = "a1234";
    Patient p1 = new Patient(new WelcomePage(), new PatientPage(userName), new DB_Connection(environment, userName, password));
    PatientLogin p_login = new PatientLogin(p1, new WelcomePage());  // Passing the object to the patient login
    p_login.setPatientPass(userName);
    assertEquals(userName, p_login.getPatientPass(), "Error: Incorrect Password");
  }

  @Test
  void execute() throws SQLException, IOException, ClassNotFoundException {
    String userName = "Aditya@hotmail.com";
    String password = "a1234";
    Patient patient = new Patient(new WelcomePage(), new PatientPage(userName), new DB_Connection(environment, userName, password));
    PatientLogin p_login = new PatientLogin(patient, new WelcomePage());  // Passing the object to the patient login
    p_login.setPatientName(userName);
    p_login.setPatientPass(password);


    //Fetch
    patient.fetch(p_login.getPatientName(), p_login.getPatientPass());
    // Validate
    patient.validate();

    assertAll("Checking Execute Function",
        () -> assertEquals(userName, patient.getUsername()),
        () -> assertEquals(password, patient.getPassword()),
        () -> assertTrue(patient.get_id_status()),
        () -> assertTrue(patient.get_pass_status()));

  }
}