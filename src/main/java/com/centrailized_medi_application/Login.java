package com.centrailized_medi_application;/* com.centrailized_medi_application.Login Interface to support users ( Patients & Doctors) */

import java.io.IOException;
import java.sql.SQLException;

public abstract class Login
{
    protected abstract void fetch(String u_name, String Psswd);
    protected abstract void validate() throws SQLException, IOException, ClassNotFoundException;
    protected abstract void authenticate() throws SQLException, IOException, ClassNotFoundException;


}
