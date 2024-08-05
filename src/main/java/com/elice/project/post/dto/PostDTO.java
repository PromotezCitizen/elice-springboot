package com.elice.project.post.dto;

public class PostDTO {
  private String title;
  private String content;

  public void setContent(String content) { this.content = content; }
  public String getContent() { return content; }

  public void setTitle(String title) { this.title = title; }
  public String getTitle() { return title; }
}
