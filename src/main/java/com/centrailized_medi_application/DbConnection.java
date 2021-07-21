package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * author:Ridampreet Singh
 * DbConnection interface implemented by the classes.
 * getDetails()-method will return boolean array containing the validity status of the entered credentials.
 * createConnection()-returns a connection so that the connection can be established with the database.
 */
public interface DbConnection {

    public boolean[] getDetails() throws SQLException, IOException, ClassNotFoundException;
    public Connection createConnection();

}
