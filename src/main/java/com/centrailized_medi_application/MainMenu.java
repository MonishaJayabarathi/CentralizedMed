package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu
{
    private boolean flag = false;

    public void display() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n*****Centralized Medi-Application*****\n");
        System.out.println("-----------Main Menu-------------");
        System.out.println(" 1.Register as a Patient\n 2.Login as a Patient\n 3.Register as a Doctor\n 4.Login as a Doctor");
        System.out.println("----------------------------------");
        System.out.println(" Enter from above options to proceed:");

        while(flag!=true) {
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {
                this.display_patient_registration();
                flag = true;
            } else if (option == 2) {
                this.display_patient_login();
                flag = true;
            } else if (option == 3) {
                this.display_doctor_registration();
                flag = true;
            } else if (option == 4) {
                this.display_doctor_login();
                flag = true;
            } else {
                System.out.println("Enter the correct options to proceed");

            }
        }
    }

    public void display_patient_login() throws SQLException, IOException, ClassNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username:");
        String patient_name = (sc.next());
        System.out.println("Enter your password:");
        String patient_pass = (sc.next());

        Action action = new Action(); // Initialize com.centrailized_medi_application.Action
        Patient p1 = new Patient();  // Initialize patient
        PatientLogin p_login = new PatientLogin(p1);  // Passing the object to the patient login
        // Setting com.centrailized_medi_application.Patient id and pass manually for now
        p_login.setPatient_name(patient_name);
        p_login.setPatient_pass(patient_pass);
        action.setCommand(p_login);
        action.run();

    }
    public void display_patient_registration() throws SQLException, ClassNotFoundException, IOException {
        PatientRegistration patient = new PatientRegistration();
        System.out.println("Would you like to register then press 1 or would you like to know information about patient press 2");
        Scanner one = new Scanner(System.in);
        int temp = one.nextInt();
        if (temp == 1) {

            patient.beginRegistration();
        }
        else if(temp==2)
        {
            System.out.println("Please enter email id of patient");
            String Email = one.next();
            System.out.println("enere email:"+Email);
            patient.get(Email);
        }
        else
        {
            System.out.println("Enter correct option either 1 or 2");
        }
    }
    public void display_doctor_registration()
    {
        DoctorRegistration doc = new DoctorRegistration();
        doc.run();
    }
    public void display_doctor_login() throws SQLException, IOException, ClassNotFoundException {
        DoctorLogin doc = new DoctorLogin();
        doc.run();
    }
}
