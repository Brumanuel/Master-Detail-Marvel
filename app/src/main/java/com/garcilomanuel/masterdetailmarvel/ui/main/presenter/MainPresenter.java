package com.garcilomanuel.masterdetailmarvel.ui.main.presenter;

import com.garcilomanuel.masterdetailmarvel.app.base.BasePresenter;
import com.garcilomanuel.masterdetailmarvel.ui.main.view.MainActivity;
import com.garcilomanuel.masterdetailmarvel.ui.main.view.MainView;

/**
 * Created by Manuel García.
 */
public abstract class MainPresenter extends BasePresenter<MainView> {

  public abstract void onViewCreated();
}
