package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class Action
{
    LoginCommand command;

    public  void mainMenu() throws SQLException, IOException, ClassNotFoundException {
        TestAction testAction =  new TestAction();
    }
    public void setCommand(LoginCommand command) {
        this.command = command;
    }
    public void run() throws SQLException, IOException, ClassNotFoundException {
        command.execute();
    }

}
