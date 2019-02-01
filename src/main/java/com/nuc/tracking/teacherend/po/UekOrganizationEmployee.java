package com.sample;


public class UekOrganizationEmployee {

  private long id;
  private String jobNumber;
  private String name;
  private java.sql.Date hiredate;
  private long status;
  private long positionId;
  private long userId;
  private long sex;
  private String tel;
  private String photo;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getJobNumber() {
    return jobNumber;
  }

  public void setJobNumber(String jobNumber) {
    this.jobNumber = jobNumber;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public java.sql.Date getHiredate() {
    return hiredate;
  }

  public void setHiredate(java.sql.Date hiredate) {
    this.hiredate = hiredate;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getPositionId() {
    return positionId;
  }

  public void setPositionId(long positionId) {
    this.positionId = positionId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

}
