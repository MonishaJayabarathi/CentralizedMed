package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class TestAction
{
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        TestAction login = new TestAction();
    }

    public TestAction() throws SQLException, IOException, ClassNotFoundException {
        Action action = new Action(); // Initialize com.centrailized_medi_application.Action
        Patient p1 = new Patient();  // Initialize patient
        PatientLogin p_login = new PatientLogin(p1);  // Passing the object to the patient login

        // Setting com.centrailized_medi_application.Patient id and pass manually for now
//        p_login.setPatient_name("Rag1234345"); // com.centrailized_medi_application.Patient id
//        p_login.setPatient_pass("qwerty"); // com.centrailized_medi_application.Patient pass


        p_login.setPatient_name("jaggi");
        p_login.setPatient_pass("2");
        action.setCommand(p_login);
        action.run();
    }
}
