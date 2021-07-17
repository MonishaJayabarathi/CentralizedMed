package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class MainDashboard extends Dashboard {
    public abstract void display_patient_login() throws SQLException, IOException, ClassNotFoundException;

    public abstract void display_doctor_login() throws SQLException, IOException, ClassNotFoundException;

    public abstract void display_doctor_registration() throws SQLException, IOException, ClassNotFoundException;

    public abstract void display_patient_registration() throws SQLException, IOException, ClassNotFoundException;
    protected boolean flag = false;
    protected Scanner sc = new Scanner(System.in);
    public void display() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n*****Centralized Medi-Application*****\n");
        System.out.println("-----------Main Menu-------------");
        System.out.println(" 1.Register as a Patient\n 2.Login as a Patient\n 3.Register as a Doctor\n 4.Login as a Doctor\n 5.Exit");
        System.out.println("----------------------------------");
        System.out.println(" Enter from above options to proceed:");

        while (flag != true) {
            int option = sc.nextInt();
            if (option == 1) {
                this.display_patient_registration();
                flag = true;
            } else if (option == 2) {
                this.display_patient_login();
                flag = true;
            } else if (option == 3) {
                this.display_doctor_registration();
                flag = true;
            } else if (option == 4) {
                this.display_doctor_login();
                flag = true;
            } else if(option==5){
                System.exit(0);
            }
            else {
                System.out.println("Enter the correct options to proceed");
            }
        }
    }
}