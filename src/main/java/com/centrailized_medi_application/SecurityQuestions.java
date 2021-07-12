package com.centrailized_medi_application;

import java.util.Scanner;

/**
 * @author Monisha J
 * @description: This program gets the answers for security question from the person trying to register or
 * trying to reset password. The class has getter and setter of the required variables holding security answers.
 */
public class SecurityQuestions implements Details {
  private  String answer1;
  private  String answer2;
  private  String answer3;

  protected Scanner sc = new Scanner(System.in);

  public String getAnswer1() {
    return answer1;
  }
  public void setAnswer1(String ans1) {
    this.answer1 = ans1;
  }
  public String getAnswer2() {
    return answer2;
  }
  public void setAnswer2(String ans2) {
    this.answer2 = ans2;
  }
  public String getAnswer3() {
    return answer3;
  }
  public void setAnswer3(String ans3) {
    this.answer3 = ans3;
  }

  //this method displays questions and records its answers
  @Override
  public void getDetails() {
    System.out.println("Your first school:");
    setAnswer1(sc.nextLine());
    System.out.println("Your hobby:");
    setAnswer2(sc.nextLine());
    System.out.println("Your first bike:");
    setAnswer3(sc.nextLine());
  }
}
