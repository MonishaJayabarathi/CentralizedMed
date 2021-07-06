package com.centrailized_medi_application;

import java.io.IOException;
import java.sql.SQLException;

public class Action
{
    LoginCommand command;

    public void setCommand(LoginCommand command) {
        this.command = command;
    }
    public void run() throws SQLException, IOException, ClassNotFoundException
    {
        command.confirmation();
    }

}
