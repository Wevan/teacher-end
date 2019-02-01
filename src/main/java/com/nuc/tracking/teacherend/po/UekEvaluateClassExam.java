package com.sample;


public class UekEvaluateClassExam {

  private long id;
  private long classId;
  private long paperId;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private long invigilator;
  private String comment;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
  }


  public long getPaperId() {
    return paperId;
  }

  public void setPaperId(long paperId) {
    this.paperId = paperId;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public long getInvigilator() {
    return invigilator;
  }

  public void setInvigilator(long invigilator) {
    this.invigilator = invigilator;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
