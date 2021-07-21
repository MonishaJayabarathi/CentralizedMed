package com.centrailized_medi_application;

/*Importing Module*/

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aditya Jain & Monisha J
 * @description: Action is an Ivoker class, which sets command and puts the command to work
 * with the help of run().
 */
public class Action {
  LoginCommand command; // command object of class LoginCommand

  /**
   * This method sets the Command.
   *
   * @return void
   * @Param LoginCommand command - command object
   */
  public void setCommand(LoginCommand command) {
    this.command = command;
  }

  /**
   * This method triggers the confirmation() defined inside LoginCommand object.
   *
   * @return void
   * @Param void
   */
  public void run() throws SQLException, IOException, ClassNotFoundException {
    command.confirmation();
  }
}
