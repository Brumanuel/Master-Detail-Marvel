package com.garcilomanuel.masterdetailmarvel.ui.main.presenter;

/**
 * Created by Manuel García.
 */
public class MainPresenterImp extends MainPresenter {

  public MainPresenterImp() {
  }

  @Override
  public void onViewCreated() {
    view.showComicsListView();
  }
}
