package com.garcilomanuel.masterdetailmarvel.ui.comiclist.presenter;

import com.garcilomanuel.masterdetailmarvel.app.base.BasePresenter;
import com.garcilomanuel.masterdetailmarvel.ui.comiclist.view.ComicsListView;

/**
 * Created by Manuel García.
 */
public abstract class ComicsListPresenter extends BasePresenter<ComicsListView> {

  public abstract void onViewCreated();

  public abstract void onComicSelected(String comicId);
}
