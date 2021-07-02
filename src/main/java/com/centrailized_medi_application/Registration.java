package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public interface Registration
{
  public void update();
  public void authenticate() throws SQLException, IOException, ClassNotFoundException;

}
