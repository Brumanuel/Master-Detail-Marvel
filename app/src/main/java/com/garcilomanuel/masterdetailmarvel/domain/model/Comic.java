package com.garcilomanuel.masterdetailmarvel.domain.model;

import java.util.List;

/**
 * Created by Manuel García.
 */
public class Comic {

  private String id;
  private String pages;
  private String title;
  private String description;
  private String thumnailUri;
  private String Author;

  public String getAuthor() {
    return Author;
  }

  public void setAuthor(String author) {
    Author = author;
  }

  private List<String> urlImages;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPages() {
    return pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getThumnailUri() {
    return thumnailUri;
  }

  public void setThumnailUri(String thumnailUri) {
    this.thumnailUri = thumnailUri;
  }

  public List<String> getUrlImages() {
    return urlImages;
  }

  public void setUrlImages(List<String> urlImages) {
    this.urlImages = urlImages;
  }
}
