package com.sample;


public class UekFrontNews {

  private long id;
  private long userId;
  private java.sql.Timestamp addTime;
  private String content;
  private String title;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getAddTime() {
    return addTime;
  }

  public void setAddTime(java.sql.Timestamp addTime) {
    this.addTime = addTime;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
