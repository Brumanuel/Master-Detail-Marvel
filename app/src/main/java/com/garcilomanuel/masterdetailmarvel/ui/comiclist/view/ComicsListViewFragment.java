package com.garcilomanuel.masterdetailmarvel.ui.comiclist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.Bind;
import com.garcilomanuel.masterdetailmarvel.R;
import com.garcilomanuel.masterdetailmarvel.app.base.BaseFragment;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import com.garcilomanuel.masterdetailmarvel.ui.comiclist.adapter.ComicRecyclerAdapter;
import com.garcilomanuel.masterdetailmarvel.ui.comiclist.presenter.ComicsListPresenter;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Manuel García.
 */
public class ComicsListViewFragment extends BaseFragment implements ComicsListView {

  //Dependency injection
  @Inject protected ComicsListPresenter comicsListPresenter;

  //View injection
  @Bind(R.id.rv_comics) protected RecyclerView rvComics;
  @Bind(R.id.pb_loading) protected ProgressBar pbLoading;

  private ComicRecyclerAdapter comicRecyclerAdapter;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.comics_list_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initRecyclerView();
    startLoading();
    comicsListPresenter.setView(this);
    comicsListPresenter.onViewCreated();
  }

  private void initRecyclerView() {
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    comicRecyclerAdapter = new ComicRecyclerAdapter();
    comicRecyclerAdapter.setOnClick(new ComicRecyclerAdapter.OnClick() {
      @Override
      public void onComicClicked(Comic comic) {
        comicsListPresenter.onComicSelected(comic.getId());
      }
    });

    rvComics.setLayoutManager(layoutManager);
    rvComics.setAdapter(comicRecyclerAdapter);
  }

  @Override
  public void showComics(List<Comic> comicList) {
    stopLoading();
    comicRecyclerAdapter.updateComics(comicList);
  }

  @Override
  public void showError(String message) {
    stopLoading();
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }

  private void startLoading() {
    pbLoading.setVisibility(View.VISIBLE);
  }

  private void stopLoading() {
    pbLoading.setVisibility(View.GONE);
  }
}
