package com.centrailized_medi_application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
public class PatientRegistrationTest {
    BasicDetails tempbasic = new BasicDetails();
    PatientDetails tempdetails = new PatientDetails();
    SecurityQuestions tempsecurity = new SecurityQuestions();

    @Test
    void RegistrationTest()
    {

        tempbasic.setFirstName("one");
        tempbasic.setLastName("two");
        tempbasic.setDob("06/07/1999");
        tempbasic.setGender("Male");
        tempbasic.setPassword("test@ONE23");
        tempbasic.setEmailId("two@gmail.com");
        tempbasic.setAddress("Sector-29 Gandhinagar");
        tempbasic.setContactNo("4234234232");
        tempdetails.setBloodGroup("o+ve");
        tempdetails.setAllergy("pollengrains");
        tempdetails.setChronicDisease("tonsilitis");
        tempdetails.setInsuranceNo("OI9900909");
        tempdetails.setDonorCardNo("SDFS00322");
        tempdetails.setFamilyMemberCode("FSDFE0000");
        tempdetails.setVolunteer("yes");

        tempbasic.setLatitude(100);
        tempbasic.setLongitude(200);

        tempsecurity.setAnswer1("SG");
        tempsecurity.setAnswer2("SWIM");
        tempsecurity.setAnswer3("Honda");
    }
    @Disabled
    @Test
    @DisplayName("To execute doctor registration")
    void execute() throws SQLException, IOException, ClassNotFoundException {
        RegistrationTest();
        NewPatient newone = new NewPatient(tempbasic,tempdetails,tempsecurity, new WelcomePage());
        PatientRegistration patienttest = new PatientRegistration(newone,new WelcomePage());
        assertEquals(true,newone.getRegistrationStatus(), "Already registered patient execution " +
                "should return false");
    }
}

