package com.centrailized_medi_application;

import java.util.Scanner;

public class SecurityQuestions implements Details {
  private  String answer1;
  private  String answer2;

  protected Scanner sc = new Scanner(System.in);

  public String getAnswer1() {
    return answer1;
  }
  public void setAnswer1(String ans1) {
    this.answer1 = ans1;
  }
  public String getAnswer2() {
    return "";
  }
  public void setAnswer2(String ans2) {

  }

  @Override
  public void getDetails() {
    System.out.println("Your first school:");
    setAnswer1(sc.next());
  }
}
