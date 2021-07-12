package com.centrailized_medi_application;

import java.util.List;
import java.util.Scanner;

public class PatientSuggestions {
    private String userName;
    public float latitude;
    public float longitude;
    private String suggestedDoctors;
    private String specialization;

    /* initialize the class using patient username */
    public PatientSuggestions(String userName){
        this.userName = userName;

    }

    /* use patient username to retrieve latitude longitude for the patient
     * connect to patient's information table
     * use patient username to retrieve latitude longitude
     */
    public void setLatLon(){

    }


    /* ask patient input for specialization */
    public void setSpecialization() {
        //Scanner inputSpecialization = new Scanner(System.in);
        //this.specialization = inputSpecialization.nextLine();
    }

    /* for current patient retrieve top rated specialized doctors within 10km
     * connect to doctors table in DB
     * filter doctors using specialization
     * filter doctors by considering doctors within 10km radius of patient
     * order doctors by their ratings
     */
    public void retrieveDoctorSuggestions(){

    }

    /* getter function for list of suggested doctors */
    public String getSuggestedDoctors(){
        return suggestedDoctors;
    }



}
