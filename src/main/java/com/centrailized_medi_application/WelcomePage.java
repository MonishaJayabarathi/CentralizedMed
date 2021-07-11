package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class WelcomePage extends MainDashboard
{
    @Override
    public void display_patient_login() throws ClassNotFoundException, SQLException, IOException {

        System.out.println("Enter your username:");
        String patient_name = (sc.next());
        System.out.println("Enter your password:");
        String patient_pass = (sc.next());
        Action action = new Action(); // Initialize Action
        Patient p1 = new Patient(this,new PatientPage());  // Initialize patient
        PatientLogin p_login = new PatientLogin(p1, this);  // Passing the object to the patient login
        p_login.setPatient_name(patient_name);
        p_login.setPatient_pass(patient_pass);
        action.setCommand(p_login);
        action.run();

    }
    @Override
    public void display_patient_registration() throws SQLException, IOException, ClassNotFoundException {
        try {
            PatientRegistration patient = new PatientRegistration();
            AboutPatient patientinfo = new AboutPatient();
            System.out.println("Would you like to register then press 1 or would you like to know information about patient press 2");
            Scanner one = new Scanner(System.in);
            int temp = one.nextInt();
            if (temp == 1) {

                patient.beginRegistration();
            } else if (temp == 2) {
                try {
                    System.out.println("Please enter email id of patient");
                    String Email = one.next();
                    System.out.println("Entered email:" + Email);
                    patientinfo.get(Email);
                } catch (Exception e) {
                    System.out.println("Exception Encountered Please enter correct value");
                }

            } else {
                System.out.println("Enter correct option either 1 or 2");
            }
        }catch (Exception e)
        {
            System.out.println("Input Exception Encountered moving to main menu");
            WelcomePage init = new WelcomePage();
            init.display();
        }
    }

    @Override
    public void display_doctor_registration() throws SQLException, IOException, ClassNotFoundException {
        BasicDetails basicDetails = new BasicDetails();
        DoctorDetails doctorDetails = new DoctorDetails();
        SecurityQuestions securityQuestions = new SecurityQuestions();
        Action action = new Action(); // Initialize Action
        NewDoctor doc = new NewDoctor(basicDetails, doctorDetails, securityQuestions, this );
        DoctorRegistration docReg = new DoctorRegistration(doc, this);
        docReg.start();
        action.setCommand(docReg);
        action.run();
    }

    @Override
    public void display_doctor_login() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Enter your username:");
        String doctor_name = (sc.next());
        System.out.println("Enter your password:");
        String doctor_password = (sc.next());
        Action action = new Action(); // Initialize Action
        Doctor dr = new Doctor(this,new DoctorPage(doctor_name));  // Initialize doctor
        DoctorLogin doctorLogin = new DoctorLogin(dr, this);  // Passing the object to the doctor login
        doctorLogin.setDoctorName(doctor_name);
        doctorLogin.setDoctorPassword(doctor_password);
        action.setCommand(doctorLogin);
        action.run();
    }

}