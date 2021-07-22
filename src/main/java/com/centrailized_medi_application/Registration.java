package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This interface declares the methods to be defined while a user registration is carried out.
 */
public interface Registration {
  public void update() throws IOException, ClassNotFoundException, SQLException;

  public void action() throws SQLException, IOException, ClassNotFoundException;

}
