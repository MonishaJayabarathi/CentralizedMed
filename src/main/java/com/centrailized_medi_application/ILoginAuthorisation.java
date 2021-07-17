package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public interface ILoginAuthorisation {


    String user_id = null;
    public String getSecurityQuestion(String Username) throws SQLException, IOException, ClassNotFoundException;//will be used to get the security questions for the user trying to login
    public String resetPassword(String user_name,boolean securityQuesCleared,Integer retries) throws SQLException, IOException, ClassNotFoundException;//This function will provide the user the ability to reset password

}
