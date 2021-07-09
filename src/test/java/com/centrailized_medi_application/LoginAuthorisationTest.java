package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginAuthorisationTest {
    @Test
    public void reset() {
        Integer retry = 3;
        boolean clearedSecurityQues = true;
        String user_name = "Neelay@gmail.com";
        LoginAuthorisation lg = new LoginAuthorisation();
        assertEquals("Password reset was successful !", lg.resetPassword());

    }


    @Test
    void verifySecurityAnswer() throws SQLException, IOException, ClassNotFoundException {
        boolean[] creds = new boolean[2];
        String environment = "src/main/resources/config_test.properties";
        DB_Connection db = new DB_Connection(environment);
        Connection connect = db.createConnection();
        String user_name = "Neelay@gmail.com";
        PreparedStatement answer = connect.prepareStatement("select * from userinfo where emailId=?");
        answer.setString(1, user_name);
        ResultSet s1 = answer.executeQuery();
        s1.next();
        LoginAuthorisation key = new LoginAuthorisation();
        assertEquals(s1.getString("firstAnswer"), key.getSecurityQuestion(), "Incorrect Security Answer");

    }
}