package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Ridampreet Singh
 * Description: This class acts as a data layer for the whole application and allows other classes to send their
 * parameters so that respective queries can be executed and the valid result sets can be returned.
 * getUserDetails()-Method gets the details from the respective tables of the patient or the doctor and returns a result set
 * insertConsultations()-Inserts the Consultations of doctors.
 * getCredStatus()-Returns the credentials array which contains boolean values of username and password being correct.
 * fetchDonors()-Returns the result set containing donors.
 * check_if_patient()-checks if the user is a patient, if yes then returns all of the information about the patient.
 * check_if_doctor()-checks if the user is a doctor, if yes then returns all of the information about the doctor.
 * updatePatient()-Updates the login information stored about the patient.
 * updateDoctor()-Updates the login information stored about the patient.
 * displayPatientInfo()-Returns a result set containing information about the patient.
 * displayFamilyinfo()-Returns the result set containing the family information.
 * insertNewDoctor()-Inserts a new Doctor into the database.
 * insertNewPatient()-Inserts a new patient into the database.
 * feedRatings()-Inserts ratings about the patient into the database.
 */


public class DB_Layer {
  String environment = "src/main/resources/config_test.properties";

  DB_Connection db = null;
  Connection connect = null;

  public DB_Layer() throws SQLException, IOException, ClassNotFoundException {
    db = new DB_Connection(this.environment);
    connect = db.createConnection();
  }

  public ResultSet getUserDetails(String username, String user_type) throws SQLException {
    String sqlStmt;

    if (user_type.equals("Doctor")) {
      sqlStmt = "SELECT * FROM DoctorInfo where emailId =?;";
    } else {
      sqlStmt = "SELECT * FROM PatientInfo where emailId =?;";
    }

    ResultSet currentDoctorDetails;

    PreparedStatement prepStmt = connect.prepareStatement(sqlStmt);
    prepStmt.toString();

    prepStmt.setString(1, username);

    currentDoctorDetails = prepStmt.executeQuery();
    //c.close();
    return currentDoctorDetails;
  }

  public void close() throws SQLException {
    connect.close();
  }

  public void insertConsultations(String docter_user_name, String p_name, DateTimeFormatter consultation_date, LocalDateTime current_time) throws SQLException {
    PreparedStatement prep_statement = connect.prepareStatement("INSERT INTO `Consultations`(doctorUsername," +
        "patientUsername,consultationDateTime) VALUES (?, ?, ?)");
    prep_statement.setString(1, docter_user_name);
    prep_statement.setString(2, p_name);
    prep_statement.setString(3, (consultation_date.format(current_time)));
    prep_statement.executeUpdate();

  }

  public boolean[] getCredStatus(String u_name, String u_pass) throws SQLException {
    String name;
    String pass;
    boolean res_id = false;
    boolean res_pass = false;
    boolean[] cred_validity = new boolean[2];

    PreparedStatement p1 = connect.prepareStatement("select * from CSCI5308_5_TEST.LoginDetails where username=?");
    p1.setString(1, u_name);
    ResultSet login_name = p1.executeQuery();

    while (login_name.next()) {
      name = login_name.getString("username");

      if (name.equals((u_name))) {
        res_id = true;
      }
      PreparedStatement check_for_doc = connect.prepareStatement("select * from DoctorInfo where emailId=?");
      check_for_doc.setString(1, u_name);
      ResultSet res_check_for_doc = check_for_doc.executeQuery();
      if (res_check_for_doc.next() == true) {
        res_id = true;
        if (res_check_for_doc.getString("password").equals(u_pass)) {
          res_pass = true;
        } else {
          res_pass = false;
        }
        cred_validity[0] = res_id;
        cred_validity[1] = res_pass;

        return cred_validity;
      }


      PreparedStatement p2 = connect.prepareStatement("select * from CSCI5308_5_TEST.LoginDetails where username=? " +
          "and password=?");
      p2.setString(1, u_name);
      p2.setString(2, u_pass);
      ResultSet login_pass = p2.executeQuery();
      while (login_pass.next()) {

        pass = login_pass.getString("password");
        if (pass.equals(u_pass)) {
          res_pass = true;
        }
      }
      cred_validity[0] = res_id;
      cred_validity[1] = res_pass;
    }

    return cred_validity;
  }

  public ResultSet fetchDonors() throws SQLException {
    PreparedStatement get_donors = connect.prepareStatement("Select * from PatientInfo where volunteer=? ");
    get_donors.setString(1, "yes");
    ResultSet exec_get_donors = get_donors.executeQuery();

    return exec_get_donors;
  }

  public ResultSet check_if_patient(String user_name) throws SQLException {
    PreparedStatement check_if_patient = connect.prepareStatement("select * from PatientInfo where emailId=?");
    check_if_patient.setString(1, user_name);
    ResultSet s1 = check_if_patient.executeQuery();

    return s1;
  }

  public ResultSet check_if_doctor(String user_name) throws SQLException {
    PreparedStatement check_if_Doctor = connect.prepareStatement("select * from DoctorInfo where emailId=?");
    check_if_Doctor.setString(1, user_name);
    ResultSet s2 = check_if_Doctor.executeQuery();

    return s2;
  }

  public void updatePatient(String newPassword, String user_name) throws SQLException {
    PreparedStatement updatePass = connect.prepareStatement("Update PatientInfo set password=? where emailId=?");
    updatePass.setString(1, newPassword);
    updatePass.setString(2, user_name);
    updatePass.execute();
    updatePass = connect.prepareStatement("Update LoginDetails set pass=? where username=?");
    updatePass.setString(1, newPassword);
    updatePass.setString(2, user_name);
    updatePass.execute();

  }

  public void updateDoctor(String newPassword, String user_name) throws SQLException {

    PreparedStatement updatePass = connect.prepareStatement("Update DoctorInfo set password=? where emailId=?");
    updatePass.setString(1, newPassword);
    updatePass.setString(2, user_name);
    updatePass.execute();
    updatePass = connect.prepareStatement("Update LoginDetails set pass=? where username=?");
    updatePass.setString(1, newPassword);
    updatePass.setString(2, user_name);
    updatePass.execute();

  }

  public ResultSet displayPatientInfo(String patientEmail) throws SQLException {
    String sqlStmt = "SELECT * FROM PatientInfo where emailId =?";

    PreparedStatement prepStmt = connect.prepareStatement(sqlStmt);
    prepStmt.setString(1, patientEmail);
    ResultSet currentPatientDetails = prepStmt.executeQuery();

    return currentPatientDetails;

  }

  public ResultSet displayFamilyinfo(String familyCode, String patientEmail) throws SQLException {
    String sqlStmt =
        "SELECT * FROM PatientInfo where familyMemberCode =\"" + familyCode + "\" and not emailId=\"" + patientEmail +
            "\"";

    PreparedStatement prepStmt = connect.prepareStatement(sqlStmt);
    ResultSet familyDetails = prepStmt.executeQuery();

    return familyDetails;
  }

  public void insertNewDoctor(BasicDetails basicDetails, DoctorDetails doctorDetails, SecurityQuestions securityQuestions) throws SQLException {
    PreparedStatement st = connect.prepareStatement("Insert into LoginDetails(usernname,password) values(?,?)");
    st.setString(1, basicDetails.getEmailId());
    st.setString(2, basicDetails.getPassword());

    st.execute();
    st = connect.prepareStatement("Select * from LoginDetails where username=\"" + basicDetails.getEmailId() + "\"");
    ResultSet rs2 = st.executeQuery();
    rs2.next();
    int curr_id = rs2.getInt("loginId");

    PreparedStatement insert_statement = connect.prepareStatement("insert into " +
        "DoctorInfo(id,firstname,lastname,gender,dateOfBirth,address,latitude,longitude,contactNo,speciality," +
        "registrationNumber," +
        "emailId,password,securityAnswer1,securityAnswer2,securityAnswer3) " +
        "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
    insert_statement.setInt(1, curr_id);
    insert_statement.setString(2, basicDetails.getFirstName());
    insert_statement.setString(3, basicDetails.getLastName());
    insert_statement.setString(4, basicDetails.getGender());
    insert_statement.setString(5, basicDetails.getDob());
    insert_statement.setString(6, basicDetails.getAddress());
    insert_statement.setInt(7, basicDetails.getLatitude());
    insert_statement.setInt(8, basicDetails.getLongitude());
    insert_statement.setString(9, basicDetails.getContactNo());
    insert_statement.setString(10, doctorDetails.getSpeciality());
    insert_statement.setInt(11, doctorDetails.getRegistrationNumber());
    insert_statement.setString(12, basicDetails.getEmailId());
    insert_statement.setString(13, basicDetails.getPassword());
    insert_statement.setString(14, securityQuestions.getAnswer1());
    insert_statement.setString(15, securityQuestions.getAnswer2());
    insert_statement.setString(16, securityQuestions.getAnswer3());

    insert_statement.execute();

  }

  public void insertNewPatient(BasicDetails basicDetails, PatientDetails patientDetails, SecurityQuestions securityQuestions) throws SQLException {
    PreparedStatement st = connect.prepareStatement("Insert into LoginDetails(username,password) values(?,?)");
    st.setString(1, basicDetails.getEmailId());
    st.setString(2, basicDetails.getPassword());

    st.execute();
    st = connect.prepareStatement("Select * from LoginDetails where username=\"" + basicDetails.getEmailId() + "\"");
    ResultSet rs2 = st.executeQuery();
    rs2.next();
    int curr_id = rs2.getInt("loginId");

    PreparedStatement test = connect.prepareStatement("INSERT INTO PatientInfo(id,firstname,lastname," +
        "dateOfbirth,gender,password,emailId,address,contactNo,bloodGroup," +
        "allergy,chronicDisease,insuranceNo,donorCardNo,familyMemberCode,volunteer,securityAnswer1," +
        "securityAnswer2,securityAnswer3,latitude,longitude) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

    test.setInt(1, curr_id);
    test.setString(2, basicDetails.getFirstName());
    test.setString(3, basicDetails.getLastName());
    test.setString(4, basicDetails.getDob());
    test.setString(5, basicDetails.getGender());
    test.setString(6, basicDetails.getPassword());
    test.setString(7, basicDetails.getEmailId());
    test.setString(8, basicDetails.getAddress());
    test.setString(9, basicDetails.getContactNo());
    test.setString(10, patientDetails.getBloodGroup());
    test.setString(11, patientDetails.getAllergy());
    test.setString(12, patientDetails.getChonicDisease());
    test.setString(13, patientDetails.getInsuranceNo());
    test.setString(14, patientDetails.getDonorCardNo());
    test.setString(15, patientDetails.getFamilyMemberCode());
    test.setString(16, patientDetails.getVolunteer());
    test.setString(17, securityQuestions.getAnswer1());
    test.setString(18, securityQuestions.getAnswer2());
    test.setString(19, securityQuestions.getAnswer3());
    test.setInt(20, basicDetails.getLatitude());
    test.setInt(21, basicDetails.getLongitude());
    test.execute();

  }

  public void feedRatings(String userName) throws SQLException, IOException, ClassNotFoundException {
    PreparedStatement prep_statement = connect.prepareStatement("SELECT * FROM `Consultations` WHERE patientUsername" +
        " = ?");
    prep_statement.setString(1, userName);
    ResultSet doc_list = prep_statement.executeQuery();
    //prep_statement.close();
    Scanner sc = new Scanner(System.in);
    while (doc_list.next()) {
      System.out.println(doc_list.getString("doctorUsername") + " " + doc_list.getString("consultationDateTime"));
      System.out.println("Enter rating:");
      int rating = sc.nextInt();
      int current_value = 0;

      //Fetch existing values
      String email_doc = doc_list.getString("doctorUsername");
      PreparedStatement current_val = connect.prepareStatement("SELECT * FROM `DoctorInfo` WHERE emailId=?");
      current_val.setString(1, email_doc);
      //current_val.setInt(2, rating);
      ResultSet get_current_value = current_val.executeQuery();
      int updt_rating = 0;
      if (get_current_value.next()) {
        current_value = get_current_value.getInt("rating");
        updt_rating = (current_value + rating) / 2;
      } else {
        updt_rating = rating;
      }

      //Update with the patient values
      PreparedStatement pstatement = connect.prepareStatement("Update DoctorInfo set rating=? where emailId=?");
      pstatement.setInt(1, updt_rating);
      email_doc = doc_list.getString("doctorUsername");
      pstatement.setString(2, email_doc);
      boolean doc_rate = pstatement.execute();
    }

  }

  /**
   * This method fetches distinct patient usernames who consulted the given doctor
   *
   * @param doctorUsername
   * @return ResultSet exec_get_past_consultations - List of unique consulted patients
   * @throws SQLException
   */
  public ResultSet fetchPastConsultations(String doctorUsername) throws SQLException {
    PreparedStatement get_past_consultations = connect.prepareStatement("SELECT consultationDateTime, " +
        "patientUsername " +
        "from " + "Consultations WHERE doctorUsername ='" + doctorUsername + "' GROUP BY patientUsername");
    ResultSet exec_get_past_consultations = get_past_consultations.executeQuery();

    return exec_get_past_consultations;
  }


}
