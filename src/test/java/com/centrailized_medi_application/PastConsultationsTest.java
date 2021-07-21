package com.centrailized_medi_application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PastConsultationsTest {
  public static final String doctorUsername = "key@gmail.com";
  private String environment = "src/main/resources/config_test.properties";
  PastConsultations pastConsultations;

  void constructor() throws SQLException, IOException, ClassNotFoundException {
    pastConsultations = new PastConsultations(new DB_Connection(environment), doctorUsername);
  }

  @Test
  @DisplayName("To see the past consultation list")
  void getPreviousConsultations() throws SQLException, IOException, ClassNotFoundException {
    this.constructor();
    String result = "PAST CONSULTATIONS\n" +
        "*******************************************\n" +
        "First Name: bat\n" +
        "Last Name: mqn\n" +
        "Last Consultation: 13/07/2021 18:31:50\n" +
        "Patient ID: 103\n" +
        "Blood Group: B+ve\n" +
        "Contact No: 8768678761\n" +
        "\n" +
        "*******************************************\n" +
        "First Name: Ridam\n" +
        "Last Name: Preet\n" +
        "Last Consultation: 12/07/2021 20:01:03\n" +
        "Patient ID: 4\n" +
        "Blood Group: B+ve\n" +
        "Contact No: 998877665544\n" +
        "\n";
    assertEquals(result, pastConsultations.getPreviousConsultations());
  }
}