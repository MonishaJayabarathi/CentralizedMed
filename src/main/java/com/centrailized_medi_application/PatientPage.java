package com.centrailized_medi_application;

public class PatientPage extends PatientDashboard
{
    private int patient_id;
    @Override
    public void About() {

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