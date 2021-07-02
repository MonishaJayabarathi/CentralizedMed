package com.centrailized_medi_application;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BasicDetailsTest {

  private BasicDetails bd = new BasicDetails();;

  @Test
  @DisplayName("To get firstName")
  void get_set_FirstName() {
    bd.setFirstName("testFirstName");
    assertEquals("testFirstName", bd.getFirstName(), "firstName getter fails");
  }

  @Test
  @DisplayName("To set firstName")
  void setFirstName() {
    bd.setFirstName("testFirstName");
    assertEquals("testFirstName", bd.getFirstName(), "firstName setter fails");
  }

  @Test
  @DisplayName("To get firstName")
  void getLastName() {
    bd.setLastName("testLastNAme");
    assertEquals("testLastNAme", bd.getLastName(), "testLastNAme getter fails");
  }

  @Test
  @DisplayName("To set lastName")
  void setLastName() {
    bd.setLastName("testLastNAme");
    assertEquals("testLastNAme", bd.getLastName(), "lastName setter fails");
  }

  @Test
  @DisplayName("To get email")
  void getEmailId() {
    bd.setEmailId("testEmail@123.in");
    assertEquals("testEmail@123.in", bd.getEmailId(), "email getter fails");
  }

  @Test
  @DisplayName("To set email")
  void setEmailId() {
    bd.setEmailId("testEmail@123.in");
    assertEquals("testEmail@123.in", bd.getEmailId(), "email setter fails");
  }

  @Test
  @DisplayName("To get password")
  void getPassword() {
    bd.setPassword("testPassword");
    assertEquals("testPassword", bd.getPassword(), "password getter fails");
  }

  @Test
  @DisplayName("To set password")
  void setPassword() {
    bd.setPassword("testPassword");
    assertEquals("testPassword", bd.getPassword(), "password setter fails");
  }

  @Test
  @DisplayName("To get confirm password")
  void getConfirmPassword() {
    bd.setConfirmPassword("testConfirmPassword");
    assertEquals("testConfirmPassword", bd.getConfirmPassword(), "ConfirmPassword getter fails");
  }

  @Test
  @DisplayName("To set confirm password")
  void setConfirmPassword() {
    bd.setConfirmPassword("testConfirmPassword");
    assertEquals("testConfirmPassword", bd.getConfirmPassword(), "ConfirmPassword setter fails");
  }
}