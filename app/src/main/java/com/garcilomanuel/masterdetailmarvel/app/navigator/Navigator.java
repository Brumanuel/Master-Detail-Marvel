package com.garcilomanuel.masterdetailmarvel.app.navigator;

import android.app.Activity;
import android.content.Intent;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.view.ComicDetailActivity;

/**
 * Created by Manuel García.
 *
 * Navigator have the current activity, if we use in presenters, we can move without have context.
 * You can change the flow of aplication changing the navigator.
 */
public class Navigator {

  private Activity activity;

  public void goBack() {
    activity.finish();
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public void goDetailsView(String comicId) {
    Intent intent = new Intent(activity, ComicDetailActivity.class);
    intent.putExtra(ComicDetailActivity.COMIC_ID_KEY, comicId);
    activity.startActivity(intent);
  }
}
