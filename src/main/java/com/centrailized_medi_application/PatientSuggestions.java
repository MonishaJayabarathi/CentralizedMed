package com.centrailized_medi_application;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientSuggestions {
    public String userName;
    public double latitude;
    public double longitude;
    private String specialization;
    private ArrayList<ArrayList<String>> doctorsList = new ArrayList<ArrayList<String>>();

    /* initialize the class using patient username */
    public PatientSuggestions(String userName){
        this.userName = userName;

    }

    /* use patient username to retrieve latitude longitude for the patient
     * connect to patient's information table
     * use patient username to retrieve latitude longitude
     */
    public void setLatLon() throws SQLException, IOException, ClassNotFoundException {
        DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
        Connection connection = one.createConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CSCI5308_5_TEST.patient_info\n"+
                "WHERE patient_info.emailID = '"+ this.userName + "';");

        while (resultSet.next()) {
            this.latitude = resultSet.getDouble("latitude");
            this.longitude = resultSet.getDouble("longitude");
        }

    }


    /* ask patient input for specialization */
    public void setSpecialization(String speciality) {
        //Scanner inputSpecialization = new Scanner(System.in);
        //this.specialization = inputSpecialization.nextLine();
        this.specialization = speciality;
    }

    /* for current patient retrieve top rated specialized doctors within 10km
     * connect to doctors table in DB
     * filter doctors using specialization
     * filter doctors by considering doctors within 10km radius of patient
     * order doctors by their ratings
     */
    public void retrieveDoctorSuggestions() throws SQLException, IOException, ClassNotFoundException {
        DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
        Connection connection = one.createConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("WITH D_table AS\n" +
                "\t(SELECT firstname,lastname,speciality,address, SQRT(POWER(ABS(latitude-" + this.latitude +")*110.574,2)+POWER(ABS(111.320*COS(latitude*0.0174532925)-111.320*COS(" + this.latitude +"*0.0174532925)),2)) as distance,rating,contactNo from doctor_info\n" +
                "\tWHERE speciality = '" + this.specialization + "') \n" +
                "SELECT * FROM D_table\n" +
                "WHERE distance < 10\n" +
                "ORDER BY rating DESC;");

        NumberFormat formatter = new DecimalFormat("#0.0");
        while (resultSet.next()) {
            ArrayList<String> resultRow = new ArrayList<String>();
            resultRow.add(resultSet.getString("firstname"));
            resultRow.add(resultSet.getString("lastname"));
            resultRow.add(resultSet.getString("speciality"));
            resultRow.add(resultSet.getString("address"));
            resultRow.add(String.valueOf((formatter.format(resultSet.getDouble("distance")) )) );
            resultRow.add(String.valueOf(resultSet.getDouble("rating")));
            resultRow.add(resultSet.getString("contactNo"));
            doctorsList.add(resultRow);
        }

    }

    /* getter function for list of suggested doctors */
    public String getSuggestedDoctors() {
        try {
            this.retrieveDoctorSuggestions();
        } catch (SQLException | IOException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        StringBuilder suggestedDoctors = new StringBuilder();
        suggestedDoctors.append("SUGGESTED DOCTORS\n");

        for (ArrayList<String> doctor: doctorsList) {
            String singleDoctor = "*******************************************" + "\n" +
                    "First Name: " + doctor.get(0) + "\n" +
                    "Last Name: " + doctor.get(1) + "\n" +
                    "Specialization: " + doctor.get(2) + "\n" +
                    "Clinic Address: " + doctor.get(3) + "\n" +
                    "Distance: " + doctor.get(4) + " km" + "\n" +
                    "Average Rating: " + doctor.get(5) + "\n" +
                    "Contact Number: " + doctor.get(6) + "\n" +
                    "\n";
            suggestedDoctors.append(singleDoctor);
        }

        return suggestedDoctors.toString();
    }

    public boolean rateDoctor() throws SQLException, IOException, ClassNotFoundException {
        DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
        Connection connection = one.createConnection();

        PreparedStatement prep_statement = connection.prepareStatement("SELECT * FROM `consultations` WHERE patient_username = ?");
        prep_statement.setString(1, this.userName);
        ResultSet doc_list = prep_statement.executeQuery();
        //prep_statement.close();
        Scanner sc = new Scanner(System.in);
        while (doc_list.next()){
            System.out.println(doc_list.getString("doctor_username") + doc_list.getString("consultation_date_and_time"));
            System.out.println("Enter rating:");
            int rating = sc.nextInt();
            int current_value = 0;

            //Fetch existing values
            String email_doc =doc_list.getString("doctor_username");
            PreparedStatement current_val = connection.prepareStatement("SELECT * FROM `doctor_info` WHERE emailId=? and rating=?");
            current_val.setString(1, email_doc);
            current_val.setInt(2, rating);
            ResultSet get_current_value = current_val.executeQuery();
            int updt_rating = 0;
            if(get_current_value.next()) {
                current_value = get_current_value.getInt("rating");
                updt_rating = (current_value + rating) / 2;
            }
           else
            {
                updt_rating = rating;
            }

            //Update with the patient values
            PreparedStatement pstatement = connection.prepareStatement("Update doctor_info set rating=? where emailId=?");
            pstatement.setInt(1, updt_rating);
            email_doc =doc_list.getString("doctor_username");
            pstatement.setString(2, email_doc);
            boolean doc_rate = pstatement.execute();

        }

        return true;
    }

}
