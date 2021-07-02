package com.centrailized_medi_application;

import java.util.Scanner;

public class TestAction
{
    public static void main(String[] args)
    {
        TestAction login = new TestAction();
    }

    public TestAction()
    {
        Action action = new Action(); // Initialize com.centrailized_medi_application.Action
        Patient p1 = new Patient();  // Initialize patient
        PatientLogin p_login = new PatientLogin(p1);  // Passing the object to the patient login

        // Setting com.centrailized_medi_application.Patient id and pass manually for now
        p_login.setPatient_name("Rag1234345"); // com.centrailized_medi_application.Patient id
        p_login.setPatient_pass("qwerty"); // com.centrailized_medi_application.Patient pass

        Scanner sc = new Scanner(System.in);
        if(sc.nextInt()==1)
        {
            PatientRegistration patient = new PatientRegistration();
            patient.beginRegistration();


        }

        action.setCommand(p_login);
        action.run();
    }
}
