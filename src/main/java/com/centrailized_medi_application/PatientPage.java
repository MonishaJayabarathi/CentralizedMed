package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class PatientPage extends PatientDashboard
{
    protected String user_name;

    public PatientPage(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public void About() throws SQLException, IOException, ClassNotFoundException {
        AboutPatient aboutPatient = new AboutPatient(this.user_name, this); //testing commit
        AboutPatientPage aboutPatientpage = new AboutPatientPage(aboutPatient);
        aboutPatientpage.display();
    }

    @Override
    public void Consultations() throws SQLException, IOException, ClassNotFoundException {
        PatientSuggestions patientSuggestions = new PatientSuggestions(user_name);
        patientSuggestions.rateDoctor();
    }

    @Override
    public void Prescriptions() throws SQLException, IOException, ClassNotFoundException {

        PatientPrescription pp = new PatientPrescription(2); // For now
        System.out.println(pp.formatPrescription());
        PatientPage pd = new PatientPage(user_name);
        pd.display();

    }

    @Override
    public void Suggestions() throws SQLException, IOException, ClassNotFoundException {
        PatientSuggestions patientSuggestions = new PatientSuggestions(user_name);
        patientSuggestions.setLatLon();
        patientSuggestions.retrieveDoctorSuggestions();
        patientSuggestions.getSuggestedDoctors();
        PatientPage pd = new PatientPage(user_name);
        pd.display();
    }


    @Override
    public void Logout() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("User has been successfuly logged out !");
        WelcomePage back_to_menu=new WelcomePage();
        back_to_menu.display();
//        return "User has been successfuly logged out !";
    }
}