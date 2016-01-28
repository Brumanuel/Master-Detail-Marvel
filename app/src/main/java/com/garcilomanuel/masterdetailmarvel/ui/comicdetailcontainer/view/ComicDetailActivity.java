package com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.garcilomanuel.masterdetailmarvel.R;
import com.garcilomanuel.masterdetailmarvel.app.base.BaseActivity;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetail.view.ComicDetailViewFragment;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.presenter.ComicDetailContainterPresenter;
import javax.inject.Inject;

/**
 * Created by Manuel García.
 */
public class ComicDetailActivity extends BaseActivity implements ComicDetailContainer {

  public static final String COMIC_ID_KEY = "comic_id_key";

  //Dependency injection
  @Inject protected ComicDetailContainterPresenter presenter;

  //View injection
  @Bind(R.id.toolbar) Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.comic_detail_container);
    ButterKnife.bind(this);
    presenter.setView(this);
    presenter.onViewCreated(getIntent().getExtras().getString(COMIC_ID_KEY));
    initToolBar();
  }

  //Init toolbar with back button and application name
  private void initToolBar() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {
      @Override
      public void onClick(android.view.View v) {
        presenter.onBackPressed();
      }
    });
  }

  public void showComicDetailsView(String comidId) {
    ComicDetailViewFragment comicDetailViewFragment = ComicDetailViewFragment.newInstance(comidId);
    getFragmentManager().beginTransaction()
        .replace(R.id.comic_frame, comicDetailViewFragment)
        .commit();
  }
}
