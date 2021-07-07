package com.centrailized_medi_application;


import java.util.Scanner;

public class PatientDashboard implements Menu
{
    private boolean flag = false;
    private int patient_id;

    void PatientDashboard(int id)
    {
        patient_id = id;
    }
    @Override
    public void display()
    {
        System.out.println("-----------Dashboard-------------");
        System.out.println("1.About");
        System.out.println("2.Consultations");
        System.out.println("3.Prescriptions");
        System.out.println("4.Suggestions");
        System.out.println("----------------------------------");
        System.out.println(" Enter from above options to proceed:");

        while(flag!=true) {
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {
                flag = true;
            } else if (option == 2) {
                flag = true;
            } else if (option == 3) {
                display_prescription();
                flag = true;
            } else if (option == 4) {
                flag = true;
            } else {
                System.out.println("Enter the correct options to proceed");
            }
        }
    }

    public void display_prescription()
    {
        PatientPrescription pp = new PatientPrescription(patient_id);
        System.out.println(pp.formatPrescription());
    }

}