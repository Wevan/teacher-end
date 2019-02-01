package com.sample;


public class UekEvaluateWrongTitles {

  private long id;
  private long studentId;
  private long titleId;
  private String wrongAnswer;
  private java.sql.Timestamp time;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }


  public long getTitleId() {
    return titleId;
  }

  public void setTitleId(long titleId) {
    this.titleId = titleId;
  }


  public String getWrongAnswer() {
    return wrongAnswer;
  }

  public void setWrongAnswer(String wrongAnswer) {
    this.wrongAnswer = wrongAnswer;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }

}
