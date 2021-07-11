package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public interface Registration
{
  public  void getDetails();
  public void update() throws IOException, ClassNotFoundException, SQLException;
  public void action() throws SQLException, IOException, ClassNotFoundException;
}
