package com.centrailized_medi_application;
/*Importing modules*/

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aditya Jain & Monisha J
 * @description: Abstract class LoginCommand has abstract methods such as execute() and confirmation().
 * execute() triggers actions such as fetch(), validate() and authenticate() when user is trying to login
 * confirmation() triggers execute() whenever user agrees to proceed with
 */
public abstract class LoginCommand {
  protected abstract void execute() throws SQLException, IOException, ClassNotFoundException;

  protected abstract void confirmation() throws SQLException, IOException, ClassNotFoundException;
}
