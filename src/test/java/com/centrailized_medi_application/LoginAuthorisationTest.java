package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginAuthorisationTest
{
    @Test
    public void reset()
    {
        Integer retry=3;
        boolean clearedSecurityQues=true;
        String user_name="Neelay@gmail.com";
        LoginAuthorisation lg=new LoginAuthorisation();
        assertEquals("Password reset was successful !",lg.resetPassword());

    }

}