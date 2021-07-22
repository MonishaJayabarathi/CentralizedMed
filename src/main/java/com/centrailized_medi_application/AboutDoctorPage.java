package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Monisha J
 * @description : This program has the concrete class.
 * This initiates execution.
 * @params : AboutDoctor abtDr - gets instance of the class holding actual functionality.
 */
public class AboutDoctorPage {
  private AboutDoctor ad;

  AboutDoctorPage(AboutDoctor abtDr) {
    this.ad = abtDr;
  }

  /**
   * This method initiates actual execution for About doctor Tab
   *
   * @throws SQLException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public void display() throws SQLException, IOException, ClassNotFoundException {
    this.ad.fetchDetails();
    this.ad.displayDetails();
    this.ad.back();
  }
}
