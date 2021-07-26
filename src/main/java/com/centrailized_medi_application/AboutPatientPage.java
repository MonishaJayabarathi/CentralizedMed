package com.centrailized_medi_application;

public class AboutPatientPage {
  private AboutPatient aboutp;

  AboutPatientPage(AboutPatient abtPatient) {
    this.aboutp = abtPatient;
  }

  // initiates actual execution for About Patient Tab
  public void display() {
    this.aboutp.fetchDetails();
    this.aboutp.displayDetails();
    this.aboutp.back();
  }
}
