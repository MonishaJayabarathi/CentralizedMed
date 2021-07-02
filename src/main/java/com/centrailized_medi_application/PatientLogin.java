package com.centrailized_medi_application;/* com.centrailized_medi_application.Patient com.centrailized_medi_application.Login Implementation which implements from com.centrailized_medi_application.LoginCommand Interface*/

import java.io.IOException;
import java.sql.SQLException;

public class PatientLogin implements LoginCommand
{
    Login patient_login;
    private String patient_name;
    private String patient_pass;
    public PatientLogin(Login p_login)
    {
        patient_login = p_login;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public void setPatient_pass(String patient_pass) {
        this.patient_pass = patient_pass;
    }

    public String getPatient_name() {

        return patient_name;
    }


    public String getPatient_pass() {
        return patient_pass;
    }

    @Override
    public void execute() throws SQLException, IOException, ClassNotFoundException {
        patient_login.fetch(this.patient_name,this.patient_pass);
        patient_login.validate();
        patient_login.authenticate();

    }
}
