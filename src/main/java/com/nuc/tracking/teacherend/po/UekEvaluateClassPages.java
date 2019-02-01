package com.sample;


public class UekEvaluateClassPages {

  private long id;
  private long pagesId;
  private long classId;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private long invigilator;
  private String comment;
  private java.sql.Timestamp addTime;
  private long employeeId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPagesId() {
    return pagesId;
  }

  public void setPagesId(long pagesId) {
    this.pagesId = pagesId;
  }


  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
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


  public java.sql.Timestamp getAddTime() {
    return addTime;
  }

  public void setAddTime(java.sql.Timestamp addTime) {
    this.addTime = addTime;
  }


  public long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(long employeeId) {
    this.employeeId = employeeId;
  }

}
