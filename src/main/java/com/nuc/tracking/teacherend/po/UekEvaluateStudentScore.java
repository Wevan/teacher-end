package com.sample;


public class UekEvaluateStudentScore {

  private long id;
  private long studentId;
  private long pagesId;
  private long objectivesScore;
  private long subjectivityScore;
  private long score;
  private String status;
  private java.sql.Timestamp time;
  private long employeeId;
  private java.sql.Date dotime;


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


  public long getObjectivesScore() {
    return objectivesScore;
  }

  public void setObjectivesScore(long objectivesScore) {
    this.objectivesScore = objectivesScore;
  }


  public long getSubjectivityScore() {
    return subjectivityScore;
  }

  public void setSubjectivityScore(long subjectivityScore) {
    this.subjectivityScore = subjectivityScore;
  }


  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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


  public java.sql.Date getDotime() {
    return dotime;
  }

  public void setDotime(java.sql.Date dotime) {
    this.dotime = dotime;
  }

}
