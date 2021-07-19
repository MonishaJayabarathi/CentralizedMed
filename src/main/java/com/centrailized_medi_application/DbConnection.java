package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DBConnection interface
public interface DbConnection {

    public boolean[] getDetails() throws SQLException, IOException, ClassNotFoundException;
    public Connection createConnection();

}
