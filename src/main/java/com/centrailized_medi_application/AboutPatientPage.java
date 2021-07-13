package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class AboutPatientPage{
    private AboutPatient aboutp;

    AboutPatientPage(AboutPatient abtPatient) {
        this.aboutp = abtPatient;
    }

    // initiates actual execution for About Patient Tab
    public void display() throws SQLException, IOException, ClassNotFoundException {
        this.aboutp.fetchDetails();
        this.aboutp.displayDetails();
        this.aboutp.back();
    }
}
