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
        Patient patient = new Patient(new WelcomePage(),new PatientPage());
        PatientLogin p_login = new PatientLogin(patient, new WelcomePage());
        p_login.setPatient_name("Kazi@gmail.com");
        p_login.setPatient_pass("k1234");

        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        assertAll("Fetch Function",
                () -> assertEquals("Kazi@gmail.com", patient.getUsername()),
                () -> assertEquals("k1234", patient.getPassword()));
    }

    // Validation test case
    @Test
    void validate() throws SQLException, IOException, ClassNotFoundException {

        Patient patient = new Patient(new WelcomePage(),new PatientPage());
        PatientLogin p_login = new PatientLogin(patient, new WelcomePage());
        p_login.setPatient_name("Kazi@gmail.com");
        p_login.setPatient_pass("k1234");

        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        assertAll("Validate Function",
                () -> assertTrue(patient.get_id_status()),
                () -> assertTrue(patient.get_pass_status()));
    }

    // Correct Id and pass
    @Disabled("authenticate->Calls user input after it succeeds,hence ignored")
    @Test
    void authenticate() throws SQLException, IOException, ClassNotFoundException {
        Patient patient = new Patient(new WelcomePage(),new PatientPage());
        PatientLogin p_login = new PatientLogin(patient,new WelcomePage());
        p_login.setPatient_name("Kazi@gmail.com");
        p_login.setPatient_pass("k1234");

        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        patient.authenticate();
        assertTrue(patient.get_auth_status());
    }


    // Incorrect Password but correct id
    @Disabled("authenticate_pass_incorrect_pass->Calls user input after it succeeds,hence ignored")
    @Test
    void authenticate_pass_incorrect_pass() throws SQLException, IOException, ClassNotFoundException {

        Patient patient = new Patient(new WelcomePage(),new PatientPage());
        PatientLogin p_login = new PatientLogin(patient, new WelcomePage());
        p_login.setPatient_name("Aditya");
        p_login.setPatient_pass("a12");

        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        patient.authenticate();
        assertTrue(patient.get_auth_status());
    }

    // Incorrect password and id
    @Disabled("authenticate_pass_invalid->Calls user input after it succeeds,hence ignored")
    @Test
    void authenticate_pass_invalid() throws SQLException, IOException, ClassNotFoundException {

        Patient patient = new Patient(new WelcomePage(),new PatientPage());
        PatientLogin p_login = new PatientLogin(patient, new WelcomePage());
        p_login.setPatient_name("test");
        p_login.setPatient_pass("a12");

        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        patient.authenticate();
        assertTrue(patient.get_auth_status());
    }
}