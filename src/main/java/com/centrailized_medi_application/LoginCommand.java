package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/* To Drive the necessary functions for logging into the system*/
public interface LoginCommand
{
    public void execute() throws SQLException, IOException, ClassNotFoundException;
}
