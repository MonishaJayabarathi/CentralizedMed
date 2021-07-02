package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class TestAction
{
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n*****Centralized Medi-Application*****\n");
        System.out.println("-----------Main Menu-------------");
        System.out.println(" 1.Register as a Patient\n 2.Login as a Patient\n 3.Register as a Doctor\n 4.Login as a Doctor");
        System.out.println("----------------------------------");
        System.out.println(" Enter from above options to proceed:");

        //Receive input and instantiate corresponding class
        Scanner sc = new Scanner(System.in);
        if(sc.nextInt() == 1)
        {
            //Object of PatientRegistration created
            PatientRegistration patient = new PatientRegistration();
            //method named beginRegistration called inorder to perform registration process
            patient.beginRegistration();
        } else if(sc.nextInt() == 3) {
            DoctorRegistration doc = new DoctorRegistration();
            doc.run();
        } else if(sc.nextInt() == 4) {
            DoctorLogin doc = new DoctorLogin();
            doc.run();
        }
        Action action = new Action(); // Initialize com.centrailized_medi_application.Action
        Patient p1 = new Patient();  // Initialize patient
        PatientLogin p_login = new PatientLogin(p1);  // Passing the object to the patient login

        // Setting com.centrailized_medi_application.Patient id and pass manually for now
        p_login.setPatient_name("Rag1234345"); // com.centrailized_medi_application.Patient id
        p_login.setPatient_pass("qwerty"); // com.centrailized_medi_application.Patient pass
        action.setCommand(p_login);
        action.run();
    }
}
