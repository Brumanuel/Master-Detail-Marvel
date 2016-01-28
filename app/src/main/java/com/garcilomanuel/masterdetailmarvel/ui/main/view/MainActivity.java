package com.garcilomanuel.masterdetailmarvel.ui.main.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.garcilomanuel.masterdetailmarvel.R;
import com.garcilomanuel.masterdetailmarvel.app.base.BaseActivity;
import com.garcilomanuel.masterdetailmarvel.ui.View;
import com.garcilomanuel.masterdetailmarvel.ui.comiclist.view.ComicsListViewFragment;
import com.garcilomanuel.masterdetailmarvel.ui.main.presenter.MainPresenter;
import javax.inject.Inject;

/**
 * Created by Manuel García.
 */
public class MainActivity extends BaseActivity implements View {

  //Dependency injection
  @Inject protected MainPresenter mainPresenter;

  //View injection
  @Bind(R.id.toolbar) Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_view_container);
    ButterKnife.bind(this);
    mainPresenter.setView(this);
    mainPresenter.onViewCreated();
    initToolBar();
  }

  //init Toolbar with name of application
  private void initToolBar() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
  }

  public void showComicsListView() {
    ComicsListViewFragment comicsListViewFragment = new ComicsListViewFragment();
    getFragmentManager().beginTransaction()
        .replace(R.id.comic_frame, comicsListViewFragment)
        .commit();
  }
}
