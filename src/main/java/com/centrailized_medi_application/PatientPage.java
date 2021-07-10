package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

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


    @Override
    public void Logout() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("User has been successfuly logged out !");
        WelcomePage back_to_menu=new WelcomePage();
        back_to_menu.display();
//        return "User has been successfuly logged out !";
    }
}