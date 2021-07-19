package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginAuthorisation implements ILoginAuthorisation {
    int retry=0;

    @Override
    public String getSecurityQuestion(String user_name) throws SQLException, IOException, ClassNotFoundException {
        String environment = "src/main/resources/config_test.properties";
//        DB_Connection db = new DB_Connection(environment);
        Connection connect = DB_Connection.getDB_Connection_Instance(environment);
        PreparedStatement check_if_patient = connect.prepareStatement("select * from patient_info where emailId=?");
        check_if_patient.setString(1, user_name);
        ResultSet s1 = check_if_patient.executeQuery();

        PreparedStatement check_if_Doctor = connect.prepareStatement("select * from doctor_info where emailId=?");
        check_if_Doctor.setString(1, user_name);
        ResultSet s2 = check_if_Doctor.executeQuery();

        if(s1.next())
        {
            System.out.println("Please enter Your first school:");
            Scanner sc=new Scanner(System.in);
            String inputAnswer=sc.nextLine();
            String answerFromDB=s1.getString("security_answer_1");
            if(answerFromDB.equals(inputAnswer)){
                resetPassword(user_name,true,retry);
            }
            return (s1.getString("security_answer_1"));
        }
        else if(s2.next()){
            System.out.println("Please enter Your first school:");
            Scanner sc2=new Scanner(System.in);
            String inputAnswer=sc2.nextLine();
            String answerFromDB=s2.getString("security_answer_1");

            if(answerFromDB.equals(inputAnswer)){
                resetPassword(user_name,true,retry);
            }
            return (s2.getString("security_answer_1"));
//            System.out.println("Doctor found !!");




        }
        else
        {
            return ("User Does not Exist");
        }
    }

    @Override
    public String resetPassword(String user_name,boolean securityQuesCleared,Integer retries) throws SQLException, IOException, ClassNotFoundException {
        if(securityQuesCleared==false)
        {
            return "Please answer the security question first !";
        }
        String configFile="src/main/resources/config_test.properties";
//        DB_Connection db=new DB_Connection(configFile);
        Connection connection=DB_Connection.getDB_Connection_Instance(configFile);
        PreparedStatement checkUser = connection.prepareStatement("select * from patient_info where emailId=?");
        checkUser.setString(1, user_name);
        ResultSet s2 = checkUser.executeQuery();
        PreparedStatement checkUser_from_Doctor = connection.prepareStatement("select * from doctor_info where emailId=?");
        checkUser_from_Doctor.setString(1, user_name);
        ResultSet s3 = checkUser_from_Doctor.executeQuery();
        if(s2.next())
        {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the new password");
            String newPassword=sc.next();
            PreparedStatement updatePass=connection.prepareStatement("Update patient_info set password=? where emailid=?");
            updatePass.setString(1,newPassword);
            updatePass.setString(2,user_name);
            updatePass.execute();
            updatePass=connection.prepareStatement("Update login_details set pass=? where user_name=?");
            updatePass.setString(1,newPassword);
            updatePass.setString(2,user_name);
            updatePass.execute();

            return "Password reset was successful !";
        }
        else if(s3.next())
        {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the new password");
            String newPassword=sc.next();
            PreparedStatement updatePass=connection.prepareStatement("Update doctor_info set password=? where emailid=?");
            updatePass.setString(1,newPassword);
            updatePass.setString(2,user_name);
            updatePass.execute();
            updatePass=connection.prepareStatement("Update login_details set pass=? where user_name=?");
            updatePass.setString(1,newPassword);
            updatePass.setString(2,user_name);
            updatePass.execute();
        }
        else
        {

            connection.close();
            return "User is not registered !";

        }
        connection.close();
        return null;
    }

    public void set_Retry(Integer localRetry) {

         this.retry=localRetry;

       System.out.println("Incorrect tries: "+retry);
    }


}
