package com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.presenter;

import com.garcilomanuel.masterdetailmarvel.app.navigator.Navigator;

/**
 * Created by Manuel García.
 */
public class ComicDetailContainerPresenterImp extends ComicDetailContainterPresenter {

  private Navigator navigator;

  public ComicDetailContainerPresenterImp(Navigator navigator) {
    this.navigator = navigator;
  }

  @Override
  public void onViewCreated(String idComic) {
    view.showComicDetailsView(idComic);
  }

  @Override
  public void onBackPressed() {
    navigator.goBack();
  }
}
