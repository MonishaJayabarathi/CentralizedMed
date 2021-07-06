package com.centrailized_medi_application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    // Fetch test case
    @Test
    void fetch() throws SQLException, IOException, ClassNotFoundException {
        PatientLogin p_login = new PatientLogin(new Patient());
        p_login.setPatient_name("Aditya");
        p_login.setPatient_pass("a1234");
        Patient patient = new Patient();
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        assertAll("Fetch Function",
                () -> assertEquals("Aditya", patient.getUsername()),
                () -> assertEquals("a1234", patient.getPassword()));
    }

    // Validation test case
    @Test
    void validate() throws SQLException, IOException, ClassNotFoundException {
        PatientLogin p_login = new PatientLogin(new Patient());
        p_login.setPatient_name("Aditya");
        p_login.setPatient_pass("a1234");
        Patient patient = new Patient();
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        assertAll("Valdiate Function",
                () -> assertTrue(patient.get_id_status()),
                () -> assertTrue(patient.get_pass_status()));
    }

    // Correct Id and pass
    @Test
    void authenticate() throws SQLException, IOException, ClassNotFoundException {
        PatientLogin p_login = new PatientLogin(new Patient());
        p_login.setPatient_name("Aditya");
        p_login.setPatient_pass("a1234");
        Patient patient = new Patient();
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        patient.authenticate();
        assertTrue(patient.get_auth_status());
    }


    // Incorrect Password but correct id
    @Disabled("authenticate_pass_incorrect_pass->Calls user input after it succeeds,hence ignored")
    @Test
    void authenticate_pass_incorrect_pass() throws SQLException, IOException, ClassNotFoundException {
        PatientLogin p_login = new PatientLogin(new Patient());
        p_login.setPatient_name("Aditya");
        p_login.setPatient_pass("a12");
        Patient patient = new Patient();
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        patient.authenticate();
        assertTrue(patient.get_auth_status());
    }

    // Incorrect password and id
    @Disabled("authenticate_pass_incorrect->Calls user input after it succeeds,hence ignored")
    @Test
    void authenticate_pass_invalid() throws SQLException, IOException, ClassNotFoundException {
        PatientLogin p_login = new PatientLogin(new Patient());
        p_login.setPatient_name("test");
        p_login.setPatient_pass("a12");
        Patient patient = new Patient();
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        patient.authenticate();
        assertTrue(patient.get_auth_status());
    }
}