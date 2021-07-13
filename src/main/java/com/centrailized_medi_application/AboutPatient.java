package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class AboutPatient {
    static private String tempemail;

    public void get(String Email) throws SQLException, ClassNotFoundException, IOException {
        //Connecting with the Database

            DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
            Connection c = one.createConnection();
            this.tempemail = Email;

            System.out.println("Fetching value for the user whose EmailId:" + tempemail);
            String sqlStmt = "SELECT * FROM patientinfo where emailId =?";

            PreparedStatement prepStmt = c.prepareStatement(sqlStmt);
            prepStmt.toString();
            prepStmt.setString(1, tempemail);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                //Display values
                System.out.println("**************************************************************");
                System.out.println();
                System.out.println("Requested Patient Info:");
                System.out.println("Firstname: " + rs.getString("firstname"));
                System.out.println("Lastname: " + rs.getString("lastname"));
                System.out.println("Date of birth: " + rs.getString("dateofbirth"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("EmailId: " + rs.getString("emailId"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("BloodGroup: " + rs.getString("bloodGroup"));
                System.out.println("Allergy: " + rs.getString("allergy"));
                System.out.println("ChronicDisease: " + rs.getString("chronicDisease"));
                System.out.println("InsuranceNo: " + rs.getString("insuranceNo"));
                System.out.println("DonorCardNo: " + rs.getString("insuranceNo"));
                System.out.println("FamilyMemberCode: " + rs.getString("familyMemberCode"));
                System.out.println("Volunteer: " + rs.getString("volunteer"));
                System.out.println();
                System.out.println("**************************************************************");
            }
            c.close();
            System.out.println("When you want to move to DashBoard press 1");
            Scanner sc = new Scanner(System.in);
            int tempchoice = sc.nextInt();
            System.out.println("choice of user"+tempchoice);
            if (tempchoice == 1) {
                System.out.println("Moving to Main Menu");
                WelcomePage init = new WelcomePage();
                init.display();
            }
        }

}
