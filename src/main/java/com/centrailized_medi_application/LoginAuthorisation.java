package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginAuthorisation implements ILoginAuthorisation {
    @Override
    public String getSecurityQuestion(String user_name) throws SQLException, IOException, ClassNotFoundException {
        String environment = "src/main/resources/config_test.properties";
        DB_Connection db = new DB_Connection(environment);
        Connection connect = db.createConnection();
        PreparedStatement answer = connect.prepareStatement("select * from patient_info where emailId=?");
        answer.setString(1, user_name);
        ResultSet s1 = answer.executeQuery();
        if(s1.next())
        {
            return (s1.getString("security_answer_1"));
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
        DB_Connection db=new DB_Connection(configFile);
        Connection connection=db.createConnection();
        PreparedStatement checkUser = connection.prepareStatement("select * from patient_info where emailId=?");
        checkUser.setString(1, user_name);
        ResultSet s2 = checkUser.executeQuery();
        if(s2.next()==false)
        {
            connection.close();
            return "User is not registered !";

        }
        else
        {
            Scanner sc=new Scanner(System.in);
            String newPassword=sc.next();
            PreparedStatement updatePass=connection.prepareStatement("Update patient_info set password=? where emailid=?");
            updatePass.setString(1,newPassword);
            updatePass.setString(2,user_name);
            updatePass.execute();
            updatePass=connection.prepareStatement("Update login_details set pass=? where user_name=?");
            updatePass.setString(1,newPassword);
            updatePass.setString(2,user_name);
            updatePass.execute();
            connection.close();
            return "Password reset was successful !";
        }

    }


}
