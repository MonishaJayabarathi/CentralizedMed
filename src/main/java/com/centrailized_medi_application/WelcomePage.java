package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class WelcomePage extends MainDashboard
{
    String environment = "src/main/resources/config_test.properties";
    @Override
    public void display_patient_login() throws ClassNotFoundException, SQLException, IOException {

        System.out.println("Enter your username:");
        String patient_name = (sc.next());
        System.out.println("Enter your password:");
        String patient_pass = (sc.next());
        Action action = new Action(); // Initialize Action
        Patient p1 = new Patient(this,new PatientPage(), new DB_Connection(environment,patient_name,patient_pass));  // Initialize patient
        PatientLogin p_login = new PatientLogin(p1, this);  // Passing the object to the patient login
        p_login.setPatient_name(patient_name);
        p_login.setPatient_pass(patient_pass);
        action.setCommand(p_login);
        action.run();

    }
    @Override
    public void display_patient_registration()
    {
        PatientRegistration patient = new PatientRegistration();
        patient.beginRegistration();
    }
    @Override
    public void display_doctor_registration()
    {
        DoctorRegistration doc = new DoctorRegistration();
        doc.run();
    }
    @Override
    public void display_doctor_login() throws SQLException, IOException, ClassNotFoundException {
        DoctorLogin doc = new DoctorLogin();
        doc.run();
    }

}