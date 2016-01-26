package com.garcilomanuel.masterdetailmarvel.app.base;

import android.view.View;

/**
 * Created by Manuel García.
 *
 * Base presenter with type heritage.
 */
public abstract class BasePresenter<T extends View> {

  protected T view;

  public void setView(T view) {
    this.view = view;
  }
}
