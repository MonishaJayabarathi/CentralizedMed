package com.centrailized_medi_application;

/*Importing Modules*/

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aditya Jain & Monisha J
 * @description: Login abstract class has abstract methods such as
 * fetch(), validate() and authenticate(). LoginCommand Object works on Login class. (Command Design Pattern)
 */
public abstract class Login {
  protected abstract void fetch(String username, String Psswd);

  protected abstract void validate();

  protected abstract void authenticate();
}
