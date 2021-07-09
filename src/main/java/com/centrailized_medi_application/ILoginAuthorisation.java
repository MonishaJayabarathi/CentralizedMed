package com.centrailized_medi_application;

public interface ILoginAuthorisation {

    static int retry=0;
    String user_id = null;
    public String getSecurityQuestion();//will be used to get the security questions for the user trying to login
    public String resetPassword();//This function will provide the user the ability to reset password

}
