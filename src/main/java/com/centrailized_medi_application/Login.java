package com.centrailized_medi_application;/* com.centrailized_medi_application.Login Interface to support users ( Patients & Doctors) */

public interface Login
{
    public void fetch(String u_name, String Psswd);
    public void validate();
    public void authenticate();


}
