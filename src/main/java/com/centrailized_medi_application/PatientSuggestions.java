package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientSuggestions implements IPatientSuggestions{
  private String patientUserName;
  private double latitude;
  private double longitude;
  private String specialization;
  private ArrayList<ArrayList<String>> doctorsList = new ArrayList<ArrayList<String>>();

  /* initialize the class using patient username */
  public PatientSuggestions(String patientUserName) {
    this.patientUserName = patientUserName;
  }

  /* use patient username to retrieve latitude longitude for the patient
   * connect to patient's information table
   * use patient username to retrieve latitude longitude
   */
  public String getPatientUserName() {
    return patientUserName;
  }

  public double getLatitude(){
    return latitude;
  }

  public double getLongitude(){
    return longitude;
  }

  public void setLatitude(double latitude){
    this.latitude = latitude;
  }

  public void setLongitude(double longitude){
    this.longitude = longitude;
  }

  public void getPatientLatLon(ISuggestionsPersistence suggestionsPersistence){
    suggestionsPersistence.loadPatientLatLon(this);
  }

  public String getSpecialization(){
    return specialization;
  }

  /* set specialization explicitly */
  public void setSpecialization(String specialization){
    this.specialization = specialization;
  }

  public ArrayList<ArrayList<String>> getDoctorsList(){
    return doctorsList;
  }

  public void setDoctorsList( ArrayList<ArrayList<String>> doctorsList){
    this.doctorsList = doctorsList;
  }

  public void getSuggestedDoctors(ISuggestionsPersistence suggestionsPersistence){
    suggestionsPersistence.loadDoctorSuggestions(this);
  }

  public boolean rateDoctor() throws SQLException, IOException, ClassNotFoundException {

    DB_Layer layer = DB_Layer.singleConnection();
    List<Object> resultState = layer.feedRatings(patientUserName);
    ResultSet result1 = (ResultSet) resultState.get(0);
    ResultSet result2 = (ResultSet) resultState.get(1);
    PreparedStatement prepStmt = (PreparedStatement) resultState.get(2);

    PatientPage pd = new PatientPage(this.patientUserName);
    pd.display();

    result1.close();
    result2.close();
    prepStmt.close();
    layer.close();
    return true;
  }

}