package com.garcilomanuel.masterdetailmarvel.app.base;

import com.garcilomanuel.masterdetailmarvel.ui.View;

/**
 * Created by Manuel García.
 *
 * Base presenter with typed heritage.
 */
public abstract class BasePresenter<T extends View> {

  protected T view;

  public void setView(T view) {
    this.view = view;
  }
}
