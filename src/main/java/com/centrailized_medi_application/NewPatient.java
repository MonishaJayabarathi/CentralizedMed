package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewPatient implements Details, Registration {
    protected boolean hasRegisteredSuccessfully = false;
    MainDashboard init;
    private BasicDetails basicDetails;
    private PatientDetails patientDetails;
    private SecurityQuestions securityQuestions;

    NewPatient(BasicDetails basic, PatientDetails pdetails, SecurityQuestions securityqs, MainDashboard main ) {
        this.basicDetails = basic;
        this.patientDetails = pdetails;
        this.securityQuestions = securityqs;
        this.init = main;
    }

    public boolean getRegistrationStatus() {
        return this.hasRegisteredSuccessfully;
    }

    @Override
    public void getDetails() {
        this.basicDetails.getDetails();
        this.patientDetails.getDetails();
        this.securityQuestions.getDetails();
    }
    @Override
    public void update() throws IOException, ClassNotFoundException, SQLException {
        // Update details to patient table
//        DB_Connection db=new DB_Connection("src/main/resources/config_test.properties");
//        Connection connection=db.createConnection();
//
//        PreparedStatement st =connection.prepareStatement("Insert into login_details(user_name,pass) values(?,?)");
//        st.setString(1,this.basicDetails.getEmailId());
//        st.setString(2,this.basicDetails.getPassword());
//
//        st.execute();
//        st = connection.prepareStatement("Select * from login_details where user_name=\"" + this.basicDetails.getEmailId() + "\"");
//        ResultSet rs2 = st.executeQuery();
//        rs2.next();
//        int curr_id = rs2.getInt("idlogin_details");
//
//        PreparedStatement test=connection.prepareStatement("INSERT INTO patient_info(id,firstname,lastname," +
//                "dateOfbirth,gender,password,emailId,address,contactNo,bloodGroup," +
//                "allergy,chronicDisease,insuranceNo,donorCardNo,familyMemberCode,volunteer,security_answer_1,security_answer_2,security_answer_3,latitude,longitude) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//
//        test.setInt(1,curr_id);
//        test.setString(2,this.basicDetails.getFirstName());
//        test.setString(3,this.basicDetails.getLastName());
//        test.setString(4,this.basicDetails.getDob());
//        test.setString(5,this.basicDetails.getGender());
//        test.setString(6,this.basicDetails.getPassword());
//        test.setString(7,this.basicDetails.getEmailId());
//        test.setString(8,this.basicDetails.getAddress());
//        test.setString(9,this.basicDetails.getContactNo());
//        test.setString(10,this.patientDetails.getBloodGroup());
//        test.setString(11,this.patientDetails.getAllergy());
//        test.setString(12,this.patientDetails.getChonicDisease());
//        test.setString(13,this.patientDetails.getInsuranceNo());
//        test.setString(14,this.patientDetails.getDonorCardNo());
//        test.setString(15,this.patientDetails.getFamilyMemberCode());
//        test.setString(16,this.patientDetails.getVolunteer());
//        test.setString(17,this.securityQuestions.getAnswer1());
//        test.setString(18,this.securityQuestions.getAnswer2());
//        test.setString(19,this.securityQuestions.getAnswer3());
//        test.setInt(20,this.basicDetails.getLatitude());
//        test.setInt(21,this.basicDetails.getLongitude());
//        test.execute();
        DB_Layer layer=new DB_Layer();
        layer.insertNewPatient(basicDetails,patientDetails,securityQuestions);
        this.hasRegisteredSuccessfully = true;

    }

    @Override
    public void action() throws SQLException, IOException, ClassNotFoundException {
        // check if the details were updated successfully
        if(this.hasRegisteredSuccessfully) {
            String firstName = this.basicDetails.getFirstName();
            System.out.println(firstName + " you have registered successfully. You can now login and access your dashboard"); // name to be replaced with the actual name stored in db
            this.init.display_patient_login();
        } else {
            System.out.println("Unable to register. Please try again!");
            System.out.println("Navigating to main menu...");
            this.init.display();
        }
    }
}
