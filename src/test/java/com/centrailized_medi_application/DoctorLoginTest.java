package com.centrailized_medi_application;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DoctorLoginTest {
  DoctorLogin doc = new DoctorLogin();

  @Test
  @DisplayName("To get doctor username")
  void getDoctorUsername() {
    doc.setDoctorUsername("docUsername");
    assertEquals("docUsername", doc.getDoctorUsername(), "doctor username getter fails");
  }

  @Test
  @DisplayName("To set doctor username")
  void setDoctorUsername() {
    doc.setDoctorUsername("docUsername");
    assertEquals("docUsername", doc.getDoctorUsername(), "doctor username setter fails");
  }

  @Test
  @DisplayName("To get doctor password")
  void getDoctorPassword() {
    doc.setDoctorPassword("password");
    assertEquals("password", doc.getDoctorPassword(), "doctor password getter fails");
  }

  @Test
  @DisplayName("To set doctor password")
  void setDoctorPassword() {
    doc.setDoctorPassword("password");
    assertEquals("password", doc.getDoctorPassword(), "doctor password setter fails");
  }
}