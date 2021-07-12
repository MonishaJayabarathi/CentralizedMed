package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class PatientPage extends PatientDashboard
{
    private int patient_id;

    protected String patientUsername; //gives id of logged in as patient

    PatientPage(String username) {
        this.patientUsername = username;
    }



    @Override
    public void About() throws SQLException, IOException, ClassNotFoundException {
        AboutPatient aboutPatient = new AboutPatient(this.patientUsername, this); //testing commit
        AboutPatientPage aboutPatientpage = new AboutPatientPage(aboutPatient);
        aboutPatientpage.display();

    }

    @Override
    public void Consultations() {

    }

    @Override
    public void Prescriptions()
    {
        PatientPrescription pp = new PatientPrescription(patient_id);
        System.out.println(pp.formatPrescription());

    }

    @Override
    public void Suggestions() {

    }
}