package com.centrailized_medi_application;

import java.util.Scanner;

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
    return "";
  }
  public void setAnswer3(String ans3) {

  }


  @Override
  public void getDetails() {
    System.out.println("Your first school:");
    setAnswer1(sc.next());
    System.out.println("Your hobby:");
    setAnswer2(sc.next());
  }
}
