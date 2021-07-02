package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientLoginTest {


    /* To verify the set func for login Patient (username)*/
    @Test
    void setPatient_name()
    {
        PatientLogin p_login = new PatientLogin(new Patient());  // Passing the object to the patient login
        p_login.setPatient_name("Aditya");
        assertEquals("Aditya",p_login.getPatient_name(),"Error: Incorrect Name");
    }

    /* To verify the set func for login Patient (password)*/
    @Test
    void setPatient_pass()
    {
        PatientLogin p_login = new PatientLogin(new Patient());  // Passing the object to the patient login
        p_login.setPatient_pass("Aditya");
        assertEquals("Aditya",p_login.getPatient_pass(),"Error: Incorrect Password");
    }

    @Test
    void execute()
    {

    }
}