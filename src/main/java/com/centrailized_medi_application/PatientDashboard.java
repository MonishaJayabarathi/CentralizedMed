package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class PatientDashboard extends Dashboard{
    public abstract void About() throws SQLException, IOException, ClassNotFoundException;

    public abstract void Consultations() throws SQLException, IOException, ClassNotFoundException;

    public abstract void Prescriptions() throws SQLException, IOException, ClassNotFoundException;

    public abstract void Suggestions() throws SQLException, IOException, ClassNotFoundException;

    public abstract void Logout() throws SQLException, IOException, ClassNotFoundException;

    protected boolean flag = false;
    protected boolean logout=false;
    protected Scanner sc = new Scanner(System.in);
    @Override
    public void display()throws SQLException, IOException, ClassNotFoundException{
        System.out.println("-----------Dashboard-------------");
        System.out.println("1.About");
        System.out.println("2.Consultations");
        System.out.println("3.Prescriptions");
        System.out.println("4.Suggestions");
        System.out.println("5.Logout");
        System.out.println("----------------------------------");
        System.out.println(" Enter from above options to proceed:");

        while (flag != true) {
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {
                this.About();
                flag = true;
            } else if (option == 2) {
                this.Consultations();
                flag = true;
            } else if (option == 3) {
                this.Prescriptions();
                flag = true;
            } else if (option == 4) {
                flag = true;
            }else if(option==5) {
                this.Logout();
                logout=true;
                flag=true;
            }
            else {
                System.out.println("Enter the correct options to proceed");
            }
        }
    }
}