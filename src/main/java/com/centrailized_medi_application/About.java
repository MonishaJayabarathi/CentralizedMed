package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Monisha J
 * @description: This program declares structure for About functionality.
 * Holds methods to be overridden in classes inheriting this.
 */
public interface About {
  public void fetchDetails() throws SQLException, IOException, ClassNotFoundException;
  public void displayDetails() throws SQLException, IOException, ClassNotFoundException;
  public void back() throws SQLException, IOException, ClassNotFoundException;
}
