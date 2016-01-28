package com.garcilomanuel.masterdetailmarvel.ui.comicdetail.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import com.garcilomanuel.masterdetailmarvel.R;
import com.garcilomanuel.masterdetailmarvel.app.base.BaseFragment;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetail.presenter.ComicDetailPresenter;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

/**
 * Created by Manuel García.
 */
public class ComicDetailViewFragment extends BaseFragment implements ComicDetailView {

  private static final String COMIC_ID_KEY = "comic_id_key";

  @Inject protected ComicDetailPresenter comicDetailPresenter;

  @Bind(R.id.iv_detail) protected ImageView ivDetail;
  @Bind(R.id.tv_name) protected TextView tvName;
  @Bind(R.id.tv_description) protected TextView tvDecription;

  private String comicID;

  public static ComicDetailViewFragment newInstance(String comicId) {
    ComicDetailViewFragment comicDetailViewFragment = new ComicDetailViewFragment();
    Bundle bundle = new Bundle();
    bundle.putString(COMIC_ID_KEY, comicId);
    comicDetailViewFragment.setArguments(bundle);
    return comicDetailViewFragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    comicID = getArguments().getString(COMIC_ID_KEY);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    comicDetailPresenter.setView(this);
    comicDetailPresenter.onViewReady(comicID);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.comic_detail_view, container, false);
  }

  @Override
  public void showComic(Comic comic, int idImageToShow) {
    Picasso.with(getActivity()).load(comic.getUrlImages().get(idImageToShow)).into(ivDetail);
    tvName.setText(comic.getTitle());
    tvDecription.setText(comic.getDescription());
  }

  @Override
  public void showError(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }
}
