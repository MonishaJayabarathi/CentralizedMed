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
 */



public class DB_Layer {
String environment="src/main/resources/config_test.properties";
  public ResultSet getUserDetails(String username,String user_type) throws ClassNotFoundException, IOException, SQLException {

    String sqlStmt;
    if(user_type.equals("Doctor")){ sqlStmt = "SELECT * FROM doctor_info where emailId =?;";}
    else{ sqlStmt = "SELECT * FROM patient_info where emailId =?;";}

    ResultSet currentDoctorDetails;
    DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
    Connection c = one.createConnection();



    PreparedStatement prepStmt = c.prepareStatement(sqlStmt);
    prepStmt.toString();

    prepStmt.setString(1, username);

    currentDoctorDetails = prepStmt.executeQuery();

    return currentDoctorDetails;
  }

  public void insertConsultations(String docter_user_name, String p_name, DateTimeFormatter consultation_date, LocalDateTime current_time) throws SQLException, IOException, ClassNotFoundException {
      DB_Connection db_access=new DB_Connection(environment);
      Connection local = db_access.createConnection();
      PreparedStatement prep_statement = local.prepareStatement("INSERT INTO `consultations`(doctor_username,patient_username,consultation_date_and_time) VALUES (?, ?, ?)");
      prep_statement.setString(1, docter_user_name);
      prep_statement.setString(2, p_name);
      prep_statement.setString(3, (consultation_date.format(current_time)));
      prep_statement.executeUpdate();

  }


  public boolean[] getCredStatus(String u_name,String u_pass) throws SQLException, IOException, ClassNotFoundException {
String name;
boolean res_id = false;
boolean res_pass = false;
boolean[] cred_validity=new boolean[2];
String pass;
DB_Connection db=new DB_Connection(environment);
Connection connection=db.createConnection();
    PreparedStatement p1 = connection.prepareStatement("select * from CSCI5308_5_TEST.login_details where user_name=?");
    p1.setString(1, u_name);
    ResultSet login_name = p1.executeQuery();
    // and pass=?
    // p1.setString(2, u_pass);
    while (login_name.next())
    {
      name=login_name.getString("user_name");
      //System.out.println(b.getString("user_name"));
      if(name.equals((u_name)))
      {
        res_id = true;
      }
      PreparedStatement check_for_doc=connection.prepareStatement("select * from doctor_info where emailid=?");
      check_for_doc.setString(1,u_name);
      ResultSet res_check_for_doc=check_for_doc.executeQuery();
      if(res_check_for_doc.next()==true)
      {
        res_id=true;
        if(res_check_for_doc.getString("password").equals(u_pass))
        {
          res_pass=true;
        }
        else
        {
          res_pass=false;
        }
        cred_validity[0]=res_id;
        cred_validity[1]=res_pass;
        return cred_validity;
      }




      PreparedStatement p2 = connection.prepareStatement("select * from CSCI5308_5_TEST.login_details where user_name=? and pass=?");
      p2.setString(1, u_name);
      p2.setString(2, u_pass);
      ResultSet login_pass  = p2.executeQuery();
      while (login_pass.next()) {

        pass = login_pass.getString("pass");
        if (pass.equals(u_pass)) {
          res_pass = true;
        }
      }
      cred_validity[0]=res_id;
      cred_validity[1]=res_pass;
    }
    return cred_validity;
  }

  public ResultSet fetchDonors() throws SQLException, IOException, ClassNotFoundException {
    DB_Connection db=new DB_Connection(environment);
    Connection connect=db.createConnection();
    PreparedStatement get_donors=connect.prepareStatement("Select * from patient_info where volunteer=? ");
    get_donors.setString(1,"yes");
    ResultSet exec_get_donors=get_donors.executeQuery();
    return exec_get_donors;
  }


  public ResultSet check_if_patient(String user_name) throws SQLException, IOException, ClassNotFoundException {
    DB_Connection db = new DB_Connection(environment);
    Connection connect = db.createConnection();
    PreparedStatement check_if_patient = connect.prepareStatement("select * from patient_info where emailId=?");
    check_if_patient.setString(1, user_name);
    ResultSet s1 = check_if_patient.executeQuery();
    return s1;
  }

  public ResultSet check_if_doctor(String user_name) throws SQLException, IOException, ClassNotFoundException {
    DB_Connection db = new DB_Connection(environment);
    Connection connect = db.createConnection();
    PreparedStatement check_if_Doctor = connect.prepareStatement("select * from doctor_info where emailId=?");
    check_if_Doctor.setString(1, user_name);
    ResultSet s2 = check_if_Doctor.executeQuery();
    return s2;
  }

  public void updatePatient(String newPassword,String user_name) throws SQLException, IOException, ClassNotFoundException {
    DB_Connection db=new DB_Connection(environment);
    Connection connection= db.createConnection();
                PreparedStatement updatePass=connection.prepareStatement("Update patient_info set password=? where emailid=?");
            updatePass.setString(1,newPassword);
            updatePass.setString(2,user_name);
            updatePass.execute();
            updatePass=connection.prepareStatement("Update login_details set pass=? where user_name=?");
            updatePass.setString(1,newPassword);
            updatePass.setString(2,user_name);
            updatePass.execute();
  }

  public void updateDoctor(String newPassword,String user_name) throws SQLException, IOException, ClassNotFoundException {
    DB_Connection db=new DB_Connection(environment);
    Connection connection= db.createConnection();
    PreparedStatement updatePass=connection.prepareStatement("Update doctor_info set password=? where emailid=?");
    updatePass.setString(1,newPassword);
    updatePass.setString(2,user_name);
    updatePass.execute();
    updatePass=connection.prepareStatement("Update login_details set pass=? where user_name=?");
    updatePass.setString(1,newPassword);
    updatePass.setString(2,user_name);
    updatePass.execute();
    connection.close();
  }

  public ResultSet displayPatientInfo(String patientEmail) throws SQLException, IOException, ClassNotFoundException {
    DbConnection test = new DB_Connection(environment);
   Connection c = test.createConnection();

    String sqlStmt = "SELECT * FROM patient_info where emailId =?";

    PreparedStatement prepStmt = c.prepareStatement(sqlStmt);
        prepStmt.setString(1, patientEmail);
        ResultSet currentPatientDetails = prepStmt.executeQuery();
        return currentPatientDetails;

  }

  public ResultSet displayFamilyinfo(String familyCode,String patientEmail) throws SQLException, IOException, ClassNotFoundException {
    DbConnection test = new DB_Connection(environment);
    Connection c = test.createConnection();
    String sqlStmt = "SELECT * FROM patient_info where familyMemberCode =\""+familyCode+"\" and not emailId=\""+patientEmail+"\"";
    PreparedStatement prepStmt = c.prepareStatement(sqlStmt);


    ResultSet familyDetails = prepStmt.executeQuery();
    return familyDetails;
  }

  public void insertNewDoctor(BasicDetails basicDetails,DoctorDetails doctorDetails,SecurityQuestions securityQuestions) throws SQLException, IOException, ClassNotFoundException {
    DB_Connection db=new DB_Connection("src/main/resources/config_test.properties");
    Connection connection=db.createConnection();

    PreparedStatement st =connection.prepareStatement("Insert into login_details(user_name,pass) values(?,?)");
    st.setString(1,basicDetails.getEmailId());
    st.setString(2,basicDetails.getPassword());

    st.execute();
    st = connection.prepareStatement("Select * from login_details where user_name=\"" + basicDetails.getEmailId() + "\"");
    ResultSet rs2 = st.executeQuery();
    rs2.next();
    int curr_id = rs2.getInt("idlogin_details");

    PreparedStatement insert_statement=connection.prepareStatement("insert into " +
        "doctor_info(id,firstname,lastname,gender,dateOfBirth,address,latitude,longitude,contactNo,speciality,registrationNumber," +
        "emailId,password,security_answer_1,security_answer_2,security_answer_3) " +
        "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
    insert_statement.setInt(1,curr_id);
    insert_statement.setString(2,basicDetails.getFirstName());
    insert_statement.setString(3,basicDetails.getLastName());
    insert_statement.setString(4,basicDetails.getGender());
    insert_statement.setString(5,basicDetails.getDob());
    insert_statement.setString(6,basicDetails.getAddress());
    insert_statement.setInt(7,basicDetails.getLatitude());
    insert_statement.setInt(8,basicDetails.getLongitude());
    insert_statement.setString(9,basicDetails.getContactNo());
    insert_statement.setString(10,doctorDetails.getSpeciality());
    insert_statement.setInt(11,doctorDetails.getRegistrationNumber());
    insert_statement.setString(12,basicDetails.getEmailId());
    insert_statement.setString(13,basicDetails.getPassword());
    insert_statement.setString(14,securityQuestions.getAnswer1());
    insert_statement.setString(15,securityQuestions.getAnswer2());
    insert_statement.setString(16,securityQuestions.getAnswer3());

    insert_statement.execute();
    connection.close();
  }


  public void insertNewPatient(BasicDetails basicDetails,PatientDetails patientDetails,SecurityQuestions securityQuestions) throws SQLException, IOException, ClassNotFoundException {
    DB_Connection db=new DB_Connection("src/main/resources/config_test.properties");
    Connection connection=db.createConnection();

    PreparedStatement st =connection.prepareStatement("Insert into login_details(user_name,pass) values(?,?)");
    st.setString(1,basicDetails.getEmailId());
    st.setString(2,basicDetails.getPassword());

    st.execute();
    st = connection.prepareStatement("Select * from login_details where user_name=\"" + basicDetails.getEmailId() + "\"");
    ResultSet rs2 = st.executeQuery();
    rs2.next();
    int curr_id = rs2.getInt("idlogin_details");

    PreparedStatement test=connection.prepareStatement("INSERT INTO patient_info(id,firstname,lastname," +
        "dateOfbirth,gender,password,emailId,address,contactNo,bloodGroup," +
        "allergy,chronicDisease,insuranceNo,donorCardNo,familyMemberCode,volunteer,security_answer_1,security_answer_2,security_answer_3,latitude,longitude) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

    test.setInt(1,curr_id);
    test.setString(2,basicDetails.getFirstName());
    test.setString(3,basicDetails.getLastName());
    test.setString(4,basicDetails.getDob());
    test.setString(5,basicDetails.getGender());
    test.setString(6,basicDetails.getPassword());
    test.setString(7,basicDetails.getEmailId());
    test.setString(8,basicDetails.getAddress());
    test.setString(9,basicDetails.getContactNo());
    test.setString(10,patientDetails.getBloodGroup());
    test.setString(11,patientDetails.getAllergy());
    test.setString(12,patientDetails.getChonicDisease());
    test.setString(13,patientDetails.getInsuranceNo());
    test.setString(14,patientDetails.getDonorCardNo());
    test.setString(15,patientDetails.getFamilyMemberCode());
    test.setString(16,patientDetails.getVolunteer());
    test.setString(17,securityQuestions.getAnswer1());
    test.setString(18,securityQuestions.getAnswer2());
    test.setString(19,securityQuestions.getAnswer3());
    test.setInt(20,basicDetails.getLatitude());
    test.setInt(21,basicDetails.getLongitude());
    test.execute();
  }


  public void feedRatings(String userName) throws SQLException, IOException, ClassNotFoundException {
    DbConnection one = new DB_Connection(environment);
    Connection connection = one.createConnection();

    PreparedStatement prep_statement = connection.prepareStatement("SELECT * FROM `consultations` WHERE patient_username = ?");
    prep_statement.setString(1, userName);
    ResultSet doc_list = prep_statement.executeQuery();
    //prep_statement.close();
    Scanner sc = new Scanner(System.in);
    while (doc_list.next()){
      System.out.println(doc_list.getString("doctor_username") + " " + doc_list.getString("consultation_date_and_time"));
      System.out.println("Enter rating:");
      int rating = sc.nextInt();
      int current_value = 0;

      //Fetch existing values
      String email_doc =doc_list.getString("doctor_username");
      PreparedStatement current_val = connection.prepareStatement("SELECT * FROM `doctor_info` WHERE emailId=?");
      current_val.setString(1, email_doc);
      //current_val.setInt(2, rating);
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
  }


}
