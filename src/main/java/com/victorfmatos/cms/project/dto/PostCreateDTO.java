package com.victorfmatos.cms.project.dto;

public class PostCreateDTO {
  private String title;
  private String content;
  private Long authorId;

  public PostCreateDTO() {
  }

  public PostCreateDTO(String title, String content, Long authorId) {
    this.title = title;
    this.content = content;
    this.authorId = authorId;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

}
