package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class PatientPage extends PatientDashboard
{
    private String user_name;

    public PatientPage(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public void About() throws SQLException, IOException, ClassNotFoundException {
        AboutPatient personal_details = new AboutPatient();
        personal_details.get(user_name);
    }

    @Override
    public void Consultations() {

    }

    @Override
    public void Prescriptions()
    {
        
        PatientPrescription pp = new PatientPrescription(2); // For now
        System.out.println(pp.formatPrescription());

    }

    @Override
    public void Suggestions() {

    }
}