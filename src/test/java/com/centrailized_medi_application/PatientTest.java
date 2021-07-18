package com.centrailized_medi_application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    // Fetch test case
    String environment = "src/main/resources/config_test.properties";
    @Test
    void fetch() throws SQLException, IOException, ClassNotFoundException {
        String user_name = "Aditya@hotmail.com";
        String password= "a1234";
        Patient patient = new Patient(new WelcomePage(),new PatientPage(user_name), new DB_Connection(environment,user_name,password));
        PatientLogin p_login = new PatientLogin(patient, new WelcomePage());
        p_login.setPatient_name(user_name);
        p_login.setPatient_pass(password);
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        assertAll("Fetch Function",
                () -> assertEquals(user_name, patient.getUsername()),
                () -> assertEquals(password, patient.getPassword()));
    }

    // Validation test case
    @Test
    void validate() throws SQLException, IOException, ClassNotFoundException {
        String user_name = "Aditya@hotmail.com";
        String password= "a1234";
        Patient patient = new Patient(new WelcomePage(),new PatientPage(user_name),new DB_Connection(environment,user_name,password));
        PatientLogin p_login = new PatientLogin(patient, new WelcomePage());
        p_login.setPatient_name(user_name);
        p_login.setPatient_pass(password);
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
        String user_name = "Aditya@hotmail.com";
        String password= "a1234";
        Patient patient = new Patient(new WelcomePage(),new PatientPage(user_name),new DB_Connection(environment,user_name,password));
        PatientLogin p_login = new PatientLogin(patient,new WelcomePage());
        p_login.setPatient_name(user_name);
        p_login.setPatient_pass(password);
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        patient.authenticate();
        assertTrue(patient.get_auth_status());
    }


    // Incorrect Password but correct id
    @Disabled("authenticate_pass_incorrect_pass->Calls user input after it succeeds,hence ignored")
    @Test
    void authenticate_pass_incorrect_pass() throws SQLException, IOException, ClassNotFoundException {
        String user_name = "Aditya";
        String password= "a12";
        Patient patient = new Patient(new WelcomePage(),new PatientPage(user_name),new DB_Connection(environment,user_name,password));
        PatientLogin p_login = new PatientLogin(patient, new WelcomePage());
        p_login.setPatient_name(user_name);
        p_login.setPatient_pass(password);
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        patient.validate();
        patient.authenticate();
        assertTrue(patient.get_auth_status());
    }

    // Incorrect password and id
    @Disabled("authenticate_pass_invalid->Calls user input after it succeeds,hence ignored")
    @Test
    void authenticate_pass_invalid() throws SQLException, IOException, ClassNotFoundException {
        String user_name = "test";
        String password= "a12";
        Doctor doctor = new Doctor(new WelcomePage(),new DoctorPage(user_name));
        DoctorLogin d_login = new DoctorLogin(doctor, new WelcomePage());
        d_login.setDoctorName(user_name);
        d_login.setDoctorPassword(password);

    }
}