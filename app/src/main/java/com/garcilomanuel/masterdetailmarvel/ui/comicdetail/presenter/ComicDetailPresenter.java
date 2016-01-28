package com.garcilomanuel.masterdetailmarvel.ui.comicdetail.presenter;

import com.garcilomanuel.masterdetailmarvel.app.base.BasePresenter;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetail.view.ComicDetailView;

/**
 * Created by Manuel García.
 */
public abstract class ComicDetailPresenter extends BasePresenter<ComicDetailView> {

  public abstract void onViewReady(String comidId);
}
