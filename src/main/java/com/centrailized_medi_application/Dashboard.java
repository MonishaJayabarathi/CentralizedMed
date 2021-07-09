package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public abstract class Dashboard
{
    public abstract void display() throws SQLException, IOException, ClassNotFoundException;
}

