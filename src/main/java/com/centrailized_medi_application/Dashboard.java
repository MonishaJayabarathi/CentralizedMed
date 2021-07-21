package com.centrailized_medi_application;

/*Importing Modules*/

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aditya Jain & Monisha J
 * @description: Dashboard is an abstract class. It has a functionality display().
 * The Class is extended by PatientDashboard & DoctorDashboard which when triggered
 * loads the dashboard for Patient & Doctor respectively.
 */
public abstract class Dashboard {
  public abstract void display() throws SQLException, IOException, ClassNotFoundException;
}

