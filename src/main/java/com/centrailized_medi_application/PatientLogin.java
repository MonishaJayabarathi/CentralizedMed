package com.centrailized_medi_application;/* com.centrailized_medi_application.Patient com.centrailized_medi_application.Login Implementation which implements from com.centrailized_medi_application.LoginCommand Interface*/

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientLogin implements LoginCommand
{
    Login patient_login;
    private String patient_name;
    private String patient_pass;
    private Scanner sc = new Scanner(System.in);
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
        System.out.println("Enter your username:");
        this.patient_name = (sc.next());
        System.out.println("Enter your password:");
        this.patient_pass = (sc.next());
        this.confirmation();

        patient_login.fetch(this.patient_name,this.patient_pass);
        patient_login.validate();
        patient_login.authenticate();

    }


    public void confirmation () throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Please enter 1 to submit");
        if (sc.nextInt() == 1)
            this.execute();
        else {
            System.out.println("Are you sure you want to cancel action, please enter y/n to confirm");
            if (sc.next() == "y")
                System.out.println("move to main menu");
            else
                this.confirmation();
        }
    }
}
