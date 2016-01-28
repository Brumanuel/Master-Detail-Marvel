package com.garcilomanuel.masterdetailmarvel.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel García.
 */
public class Events {

  private String available;
  private String returned;
  private String collectionURI;
  private List<Item> items = new ArrayList<Item>();

  public String getAvailable() {
    return available;
  }

  public void setAvailable(String available) {
    this.available = available;
  }

  public String getReturned() {
    return returned;
  }

  public void setReturned(String returned) {
    this.returned = returned;
  }

  public String getCollectionURI() {
    return collectionURI;
  }

  public void setCollectionURI(String collectionURI) {
    this.collectionURI = collectionURI;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
