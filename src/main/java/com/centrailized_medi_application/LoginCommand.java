package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/* To Drive the necessary functions for logging into the system*/
public abstract class LoginCommand
{
    protected abstract void execute() throws SQLException, IOException, ClassNotFoundException;
    protected abstract void confirmation() throws SQLException, IOException, ClassNotFoundException;
}
