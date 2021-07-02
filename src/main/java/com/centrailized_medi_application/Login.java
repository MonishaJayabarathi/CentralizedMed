package com.centrailized_medi_application;/* com.centrailized_medi_application.Login Interface to support users ( Patients & Doctors) */

import java.io.IOException;
import java.sql.SQLException;

public interface Login
{
    public void fetch(String u_name, String Psswd);
    public void validate() throws SQLException, IOException, ClassNotFoundException;
    public void authenticate();


}
