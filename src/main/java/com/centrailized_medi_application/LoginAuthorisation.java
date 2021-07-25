package com.centrailized_medi_application;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
    DB_Layer layer = null;

    @Override
    public String getSecurityQuestion(String user_name) throws SQLException, IOException, ClassNotFoundException {

        layer=DB_Layer.singleConnection();

        List<Object> resultState = layer.check_if_patient(user_name);

        ResultSet s1 = (ResultSet) resultState.get(0);
        PreparedStatement prtstmt1 = (PreparedStatement) resultState.get(1);

        List<Object> resultState1 = layer.check_if_doctor(user_name);

        ResultSet s2= (ResultSet) resultState1.get(0);
        PreparedStatement prtstmt2 = (PreparedStatement) resultState1.get(1);

        if(s1.next())
        {
            System.out.println("Please enter Your first school:");
            Scanner sc=new Scanner(System.in);
            String inputAnswer=sc.nextLine();
            String answerFromDB=s1.getString("security_answer_1");
            if(answerFromDB.equals(inputAnswer)){
                resetPassword(user_name,true,retry);
            }

            s1.close();
            prtstmt1.close();
            layer.close();

            return (answerFromDB);
        }
        else if(s2.next()){
            System.out.println("Please enter Your first school:");
            Scanner sc2=new Scanner(System.in);
            String inputAnswer=sc2.nextLine();
            String answerFromDB=s2.getString("security_answer_1");

            if(answerFromDB.equals(inputAnswer)){
                resetPassword(user_name,true,retry);
            }
            s2.close();
            prtstmt2.close();
            layer.close();

            return (answerFromDB);
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

        layer= DB_Layer.singleConnection();
        List<Object> resultState = layer.check_if_patient(user_name);

        ResultSet s2 = (ResultSet) resultState.get(0);
        PreparedStatement prtstmt2 = (PreparedStatement) resultState.get(1);


        List<Object> resultState1 = layer.check_if_doctor(user_name);

        ResultSet s3= (ResultSet) resultState1.get(0);
        PreparedStatement prtstmt3 = (PreparedStatement) resultState1.get(1);

        if(s2.next())
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the new password");
            String newPassword=sc.next();
            layer.updatePatient(newPassword,user_name);
            s2.close();
            prtstmt2.close();
            layer.close();
            return "Password reset was successful !";
        }
        else if(s3.next())
        {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the new password");
            String newPassword=sc.next();
            layer.updateDoctor(newPassword,user_name);

            s3.close();
            prtstmt3.close();
            layer.close();
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
