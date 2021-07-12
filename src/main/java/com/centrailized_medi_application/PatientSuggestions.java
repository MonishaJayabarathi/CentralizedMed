package com.centrailized_medi_application;

public class PatientSuggestions {
    private String userName;
    private float latitude;
    private float longitude;
    private String suggestedDoctors;

    /* given patient username, retrieve latitude longitude for the patient
     * connect to patient's information table
     * use patient username to retrieve latitude longitude */
    public PatientSuggestions(String patientUserName){

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
