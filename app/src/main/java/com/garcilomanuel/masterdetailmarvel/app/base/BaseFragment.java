package com.garcilomanuel.masterdetailmarvel.app.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import com.garcilomanuel.masterdetailmarvel.app.MarvelApp;

/**
 * Created by Manuel García.
 *
 * Base Fragment with Dagger and ButterKnife injection.
 */
public abstract class BaseFragment extends Fragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    injectViews();
  }

  private void injectDependencies() {
    MarvelApp mvpCleanGamesApplication =
        (MarvelApp) getActivity().getApplication();
    mvpCleanGamesApplication.inject(this);
  }

  private void injectViews() {
    ButterKnife.bind(this, getView());
  }
}
