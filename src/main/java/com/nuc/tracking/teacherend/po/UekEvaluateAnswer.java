package com.sample;


public class UekEvaluateAnswer {

  private long id;
  private long studentId;
  private long pagesId;
  private long titleId;
  private String answer;
  private long score;
  private java.sql.Timestamp time;
  private long employeeId;
  private String url;
  private double similarScore;


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


  public long getPagesId() {
    return pagesId;
  }

  public void setPagesId(long pagesId) {
    this.pagesId = pagesId;
  }


  public long getTitleId() {
    return titleId;
  }

  public void setTitleId(long titleId) {
    this.titleId = titleId;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(long employeeId) {
    this.employeeId = employeeId;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public double getSimilarScore() {
    return similarScore;
  }

  public void setSimilarScore(double similarScore) {
    this.similarScore = similarScore;
  }

}
