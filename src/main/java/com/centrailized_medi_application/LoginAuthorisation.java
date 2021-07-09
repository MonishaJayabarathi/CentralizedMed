package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAuthorisation implements ILoginAuthorisation {
    @Override
    public String getSecurityQuestion() throws SQLException, IOException, ClassNotFoundException {
        String environment = "src/main/resources/config_test.properties";
        DB_Connection db = new DB_Connection(environment);
        Connection connect = db.createConnection();
        String user_name = "Neelay@gmail.com";
        PreparedStatement answer = connect.prepareStatement("select * from userinfo where emailId=?");
        answer.setString(1, user_name);
        ResultSet s1 = answer.executeQuery();
        s1.next();
        return s1.getString("firstAnswer");
    }

    @Override
    public String resetPassword()
    {
        return null;
    }


}
