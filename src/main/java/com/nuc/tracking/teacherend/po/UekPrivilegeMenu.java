package com.sample;


public class UekPrivilegeMenu {

  private long id;
  private String name;
  private String targetHref;
  private long parentId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getTargetHref() {
    return targetHref;
  }

  public void setTargetHref(String targetHref) {
    this.targetHref = targetHref;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }

}
