package com.centrailized_medi_application;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
public class FamilyInfoTest {

    @Test
    void familyInfoTestOne() throws SQLException, IOException, ClassNotFoundException {
        FamilyInfo testone = new FamilyInfo();

        String  expectedFamilyCode ="1001";

        assertEquals(expectedFamilyCode,testone.getFamilyInfo("patient1@gmail.com"));
    }

    @Test
    void familyInfoTestTwo() throws SQLException, IOException, ClassNotFoundException {
        FamilyInfo testtwo = new FamilyInfo();

        String  expectedFamilyCode ="1001";

        assertEquals(expectedFamilyCode,testtwo.getFamilyInfo("test123@gmail.com"));
    }
}
