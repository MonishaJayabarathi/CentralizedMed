package com.centrailized_medi_application;
import java.io.IOException;
import java.sql.*;
import java.util.*;

//Class for patient registration

public class PatientRegistration extends LoginCommand {
    NewPatient patient;
    MainDashboard init;

    public PatientRegistration(NewPatient p, MainDashboard init) {
        this.patient = p;
        this.init = init;
    }

    public void start() throws SQLException, IOException, ClassNotFoundException {
        this.patient.getDetails();
        this.confirmation();
    }

    @Override
    public void execute() throws SQLException, IOException, ClassNotFoundException {
        this.patient.update();
        this.patient.action();
    }

    @Override
    public void confirmation() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Please enter 1 to register or any other option to revert");
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() == 1) {
            this.execute();
        } else {
            System.out.println("Are you sure you want to cancel registration, please enter y/n to confirm");
            sc = new Scanner(System.in);
            if (sc.nextLine().toLowerCase().equals("y")) {
                System.out.println("Navigating to main menu...");
                this.init.display();
            } else {
                System.out.println("Registration in progress....");
                this.execute();
            }
        }
    }
}





