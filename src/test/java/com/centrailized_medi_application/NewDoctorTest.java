package com.centrailized_medi_application;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class NewDoctorTest {
  BasicDetails bc = new BasicDetails();
  SecurityQuestions sq = new SecurityQuestions();
  DoctorDetails dd = new DoctorDetails();

  //mocks the doctor data that is to be inserted
  void mockData() {
    bc.setFirstName("Monisha");
    bc.setLastName("J");
    bc.setGender("Female");
    bc.setDob("Dec 31 2000");
    bc.setAddress("Street1 city1");
    bc.setLatitude(80);
    bc.setLongitude(90);
    bc.setEmailId("monisha@123.com");
    bc.setPassword("password");

    dd.setSpeciality("neurologist");
    dd.setRegistrationNumber(1234567);

    sq.setAnswer1("school1");
    sq.setAnswer2("hobby1");
    sq.setAnswer3("Scooty");
  }

  @Test
  @DisplayName("Should register doctor successfully")
  void update() throws SQLException, IOException, ClassNotFoundException {
    mockData(); //setup doctor details
    NewDoctor dr = new NewDoctor(bc,dd,sq, new WelcomePage());
    assertFalse(dr.getRegistrationStatus(), "unregistered doctor should be false");
    dr.update();
    assertTrue(dr.getRegistrationStatus(), "registered user should have it true");
  }
}