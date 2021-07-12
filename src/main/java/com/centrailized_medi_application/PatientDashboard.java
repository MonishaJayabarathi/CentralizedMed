package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class PatientDashboard extends Dashboard{
    public abstract void About() throws SQLException, IOException, ClassNotFoundException;

    public abstract void Consultations();

    public abstract void Prescriptions();

    public abstract void Suggestions();
    protected boolean flag = false;
    protected Scanner sc = new Scanner(System.in);
    @Override
    public void display()throws SQLException, IOException, ClassNotFoundException{
        System.out.println("-----------Dashboard-------------");
        System.out.println("1.About");
        System.out.println("2.Consultations");
        System.out.println("3.Prescriptions");
        System.out.println("4.Suggestions");
        System.out.println("----------------------------------");
        System.out.println(" Enter from above options to proceed:");

        while (flag != true) {
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {


                this.About();  // navigates to display About Doctor Tab.
                flag = true;
            } else if (option == 2) {
                flag = true;
            } else if (option == 3) {
                this.Prescriptions();
                flag = true;
            } else if (option == 4) {
                flag = true;
            } else {
                System.out.println("Enter the correct options to proceed");
            }
        }
    }
}