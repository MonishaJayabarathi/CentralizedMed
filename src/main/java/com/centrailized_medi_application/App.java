package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException
    {
        MainMenu init = new MainMenu();
        init.display();
    }
}
