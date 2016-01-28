package com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.presenter;

import com.garcilomanuel.masterdetailmarvel.app.base.BasePresenter;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.view.ComicDetailContainer;

/**
 * Created by Manuel García.
 */
public abstract class ComicDetailContainterPresenter extends BasePresenter<ComicDetailContainer> {

  public abstract void onViewCreated(String idComic);

  public abstract void onBackPressed();
}
