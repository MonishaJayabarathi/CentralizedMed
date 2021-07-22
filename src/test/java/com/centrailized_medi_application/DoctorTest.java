package com.centrailized_medi_application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
  String environment = "src/main/resources/config_test.properties";

  @Test
  @DisplayName("Should fetch username and password given as param")
  void fetch() throws SQLException, IOException, ClassNotFoundException {
    String userName="Kazi@gmail.com";
    String password="k1234";
    Doctor dr=new Doctor(new WelcomePage(),new DoctorPage(userName),new DB_Connection(environment,userName,password), new LoginAuthorisation());
    DoctorLogin docLogin=new DoctorLogin(dr,new WelcomePage());
    docLogin.setDoctorName("Kazi@gmail.com");
    docLogin.setDoctorPassword("k1234");

    dr.fetch(docLogin.getDoctorName(),docLogin.getDoctorPassword());
    assertAll("Fetch Function",
        () -> assertEquals("Kazi@gmail.com", dr.getUsername()),
        () -> assertEquals("k1234", dr.getPassword()));
  }

  @Test
  @DisplayName("Should validate username and password")
  void validate() throws SQLException, IOException, ClassNotFoundException {
    String userName="Kazi@gmail.com";
    String password="k1234";
    Doctor dr = new Doctor(new WelcomePage(), new DoctorPage(userName), new DB_Connection(environment, userName, password), new LoginAuthorisation());
    DoctorLogin docLogin = new DoctorLogin(dr,new WelcomePage());
    docLogin.setDoctorName(userName);
    docLogin.setDoctorPassword(password);


    dr.fetch(docLogin.getDoctorName(),docLogin.getDoctorPassword());
    dr.validate();
    assertAll("Validate Function",
        () -> assertTrue(dr.getUsernameStatus()),
        () -> assertTrue(dr.getPasswordStatus()));
  }

//   valid username and password
  @Disabled("authenticate->Calls user input after it succeeds,hence ignored")
  @Test
  @DisplayName("Should authenticate username and password to be true")
  void authenticate() throws SQLException, IOException, ClassNotFoundException {
    String userName="Kazi@gmail.com";
    String password="k1234";
    Doctor dr = new Doctor(new WelcomePage(), new DoctorPage(userName), new DB_Connection(environment, userName, password), new LoginAuthorisation());
    DoctorLogin docLogin = new DoctorLogin(dr,new WelcomePage());
    docLogin.setDoctorName(userName);
    docLogin.setDoctorPassword(password);

    dr.fetch(docLogin.getDoctorPassword(),docLogin.getDoctorPassword());
    dr.validate();
    dr.authenticate();
    assertTrue(dr.getValidationStatus());
  }


  // Valid username and Invalid password
  @Disabled("authenticate_invalid_password->Calls user input after it succeeds,hence ignored")
  @Test
  @DisplayName("Should not allow access as password is invalid")
  void authenticate_invalid_password() throws SQLException, IOException, ClassNotFoundException {
    String userName="Aditya";
    String password="a12";
    Doctor dr = new Doctor(new WelcomePage(), new DoctorPage(userName), new DB_Connection(environment, userName, password), new LoginAuthorisation());
    DoctorLogin docLogin = new DoctorLogin(dr,new WelcomePage());
    docLogin.setDoctorName(userName);
    docLogin.setDoctorPassword(password);

    dr.fetch(docLogin.getDoctorName(),docLogin.getDoctorPassword());
    dr.validate();
    dr.authenticate();
    assertTrue(dr.getValidationStatus());
  }

  // Invalid username and  password
  @Disabled("authenticate_invalid_creds->Calls user input after it succeeds,hence ignored")
  @Test
  @DisplayName("Should invaidate both username and password")
  void authenticate_invalid_creds() throws SQLException, IOException, ClassNotFoundException {
    String userName="test";
    String password="a12";
    Doctor dr = new Doctor(new WelcomePage(), new DoctorPage(userName), new DB_Connection(environment, userName, password), new LoginAuthorisation());
    DoctorLogin docLogin = new DoctorLogin(dr,new WelcomePage());
    docLogin.setDoctorName(userName);
    docLogin.setDoctorPassword(password);

    dr.fetch(docLogin.getDoctorName(),docLogin.getDoctorPassword());
    dr.validate();
    dr.authenticate();
    assertTrue(dr.getValidationStatus());
  }
}