package com.centrailized_medi_application;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DoctorLoginTest {
  Doctor dr = new Doctor(new WelcomePage(), new DoctorPage("monisha@yahoo.com"));
  DoctorLogin docLogin = new DoctorLogin(dr,new WelcomePage());

  @Test
  @DisplayName("To get doctor username")
  void getDoctorUsername() throws SQLException, IOException, ClassNotFoundException {
    docLogin.setDoctorName("docUsername");
    assertEquals("docUsername", docLogin.getDoctorName(), "doctor username getter fails");
  }

  @Test
  @DisplayName("To set doctor username")
  void setDoctorUsername() throws SQLException, IOException, ClassNotFoundException {
    docLogin.setDoctorName("docUsername");
    assertEquals("docUsername", docLogin.getDoctorName(), "doctor username setter fails");
  }

  @Test
  @DisplayName("To get doctor password")
  void getDoctorPassword() {
    docLogin.setDoctorPassword("password");
    assertEquals("password", docLogin.getDoctorPassword(), "doctor password getter fails");
  }

  @Test
  @DisplayName("To set doctor password")
  void setDoctorPassword() {
    docLogin.setDoctorPassword("password");
    assertEquals("password", docLogin.getDoctorPassword(), "doctor password setter fails");
  }

  @Test
  @DisplayName("To execute doctor login")
  void execute() throws SQLException, IOException, ClassNotFoundException {
    docLogin.setDoctorName("Kazi@gmail.com");
    docLogin.setDoctorPassword("k1234");

    //Fetch and Validate
    dr.fetch(docLogin.getDoctorName(),docLogin.getDoctorPassword());
    dr.validate();

    assertAll("Checking Execute Function",
        () -> assertEquals("Kazi@gmail.com", dr.getUsername()),
        () -> assertEquals("k1234", dr.getPassword()),
        () -> assertTrue(dr.getUsernameStatus()),
        () -> assertTrue(dr.getPasswordStatus()));
  }
}