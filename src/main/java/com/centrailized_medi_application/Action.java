package com.centrailized_medi_application;

public class Action
{
    LoginCommand command;
    public Action()
    {

    }
    public void setCommand(LoginCommand command) {
        this.command = command;
    }
    public void run()
    {
        command.execute();
    }

}
