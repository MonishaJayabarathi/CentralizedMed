package com.centrailized_medi_application;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author Ridampreet Singh & Aditya Jain
 * Implements interface ILoginAuthorisation.
 * getSecurityQuestion()-gets the security question from the database for that specific user.
 * resetPassword()-method invoked from the getSecurityQuestion() when the user has successfuly
 * answered security question, asks user for the new password and then sends to the database.
 */
public class LoginAuthorisation implements ILoginAuthorisation {
    int retry=0;

    @Override
    public String getSecurityQuestion(String user_name) throws SQLException, IOException, ClassNotFoundException {

        DB_Layer layer=new DB_Layer();
        ResultSet s1 = layer.check_if_patient(user_name);


        ResultSet s2= layer.check_if_doctor(user_name);

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

        DB_Layer layer=new DB_Layer();
        ResultSet s2=layer.check_if_patient(user_name);

        ResultSet s3=layer.check_if_doctor(user_name);

        if(s2.next())
        {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the new password");
            String newPassword=sc.next();

            layer.updatePatient(newPassword,user_name);


            return "Password reset was successful !";
        }
        else if(s3.next())
        {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the new password");
            String newPassword=sc.next();
            layer.updateDoctor(newPassword,user_name);

        }
        else
        {


            return "User is not registered !";

        }

        return null;
    }

    @Override
    public void set_Retry(Integer localRetry) {

         this.retry=localRetry;

       System.out.println("Incorrect tries: "+retry);
    }


}
