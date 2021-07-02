package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

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
        p_login.setPatient_name("Rag1234345"); // com.centrailized_medi_application.Patient id
        p_login.setPatient_pass("qwerty"); // com.centrailized_medi_application.Patient pass

        Scanner sc = new Scanner(System.in);
        //If user choses 1 in order to register as patient in the portal
        if(sc.nextInt()==1)
        {
            //Object of PatientRegistration created
            PatientRegistration patient = new PatientRegistration();
            //method named beginRegistration called inorder to perform registration process
            patient.beginRegistration();

        }

        action.setCommand(p_login);
        action.run();
    }
}
