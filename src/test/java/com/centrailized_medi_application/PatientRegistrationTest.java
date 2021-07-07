package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PatientRegistrationTest {

    //Creating test cases for the registration patient class for various set & get function
    @Test
    void RegistrationTest()
    {
        PatientRegistration testcheck = new PatientRegistration();

        testcheck.setFirstAnswer("SGhighschool");
        assertEquals("SGhighschool",testcheck.getFirstAnswer());

        testcheck.setSecondAnswer("Swim");
        assertEquals("Swim",testcheck.getSecondAnswer());

        testcheck.setThirdAnswer("Honda");
        assertEquals("Honda",testcheck.getThirdAnswer());

        testcheck.setBloodGroup("o+ve");
        assertEquals("o+ve",testcheck.getBloodGroup());

        testcheck.setAllergy("pollen");
        assertEquals("pollen",testcheck.getAllergy());

        testcheck.setChronicDisease("tonsilitis");
        assertEquals("tonsilitis",testcheck.getChonicDisease());

        testcheck.setDonorCardNo("qwe123");
        assertEquals("qwe123",testcheck.getDonorCardNo());

        testcheck.setFamilyMemberCode("fam1");
        assertEquals("fam1",testcheck.getFamilyMemberCode());

        testcheck.setVolunteer("yes");
        assertEquals("yes",testcheck.getVolunteer());

        testcheck.setInsuranceNo("insure1");
        assertEquals("insure1",testcheck.getInsuranceNo());

    }



}
