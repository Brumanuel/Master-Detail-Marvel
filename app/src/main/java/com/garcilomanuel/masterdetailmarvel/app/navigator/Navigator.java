package com.garcilomanuel.masterdetailmarvel.app.navigator;

import android.app.Activity;

/**
 * Created by Manuel García.
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
}
