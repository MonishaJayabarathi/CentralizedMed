package com.centrailized_medi_application;

import java.sql.Connection;
import java.sql.SQLException;

//DBConnection interface
public interface DbConnection {

    public boolean[] getDetails() throws SQLException;
    public Connection createConnection();

}
