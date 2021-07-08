package com.centrailized_medi_application;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;

class PatientLoginTest {


    /* To verify the set func for login Patient (username)*/
    @Test
    void setPatient_name() throws SQLException, IOException, ClassNotFoundException {
        Patient p1 = new Patient(new WelcomePage(), new PatientPage());
        PatientLogin p_login = new PatientLogin(p1,new WelcomePage());  // Passing the object to the patient login
        p_login.setPatient_name("Aditya@gmail.com");
        assertEquals("Aditya@gmail.com",p_login.getPatient_name(),"Error: Incorrect Name");
    }

    /*Check against empty string for username*/
    @Disabled("setPatient_name_only_char->Calls user input after it succeeds,hence ignored")
    @Test
    void setPatient_name_only_char() throws SQLException, IOException, ClassNotFoundException {
        Patient p1 = new Patient(new WelcomePage(), new PatientPage());
        PatientLogin p_login = new PatientLogin(p1, new WelcomePage());  // Passing the object to the patient login
        p_login.setPatient_name("Aditya1234");
        assertNull(p_login.getPatient_name());
    }

    /* To verify the set func for login Patient (password)*/
    @Test
    void setPatient_pass()
    {
        Patient p1 = new Patient(new WelcomePage(), new PatientPage());
        PatientLogin p_login = new PatientLogin(p1, new WelcomePage());  // Passing the object to the patient login
        p_login.setPatient_pass("Aditya");
        assertEquals("Aditya",p_login.getPatient_pass(),"Error: Incorrect Password");
    }

    @Test
    void execute() throws SQLException, IOException, ClassNotFoundException {

        Patient patient = new Patient(new WelcomePage(), new PatientPage());
        PatientLogin p_login = new PatientLogin(patient,new WelcomePage());  // Passing the object to the patient login
        p_login.setPatient_name("Kazi@gmail.com");
        p_login.setPatient_pass("k1234");


        //Fetch
        patient.fetch(p_login.getPatient_name(),p_login.getPatient_pass());
        // Validate
        patient.validate();

        assertAll("Checking Execute Function",
                () -> assertEquals("Kazi@gmail.com", patient.getUsername()),
                () -> assertEquals("k1234", patient.getPassword()),
                () -> assertTrue(patient.get_id_status()),
                () -> assertTrue(patient.get_pass_status()));

    }
}