package com.centrailized_medi_application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityQuestionsTest {
  private SecurityQuestions sq = new SecurityQuestions();

  @Test
  @DisplayName("To get answer1")
  void getAnswer1() {
    sq.setAnswer1("answer11");
    assertEquals("answer11", sq.getAnswer1(), "answer1 getter fails");
  }

  @Test
  @DisplayName("To set answer1")
  void setAnswer1() {
    sq.setAnswer1("answer12");
    assertEquals("answer12", sq.getAnswer1(), "answer1 setter fails");
  }
}