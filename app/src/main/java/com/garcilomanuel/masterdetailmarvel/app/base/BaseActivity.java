package com.garcilomanuel.masterdetailmarvel.app.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.garcilomanuel.masterdetailmarvel.app.MarvelApp;
import com.garcilomanuel.masterdetailmarvel.app.navigator.Navigator;
import javax.inject.Inject;

/**
 * Created by Manuel García.
 *
 * Activity father, have injection Dagger and set the child activity to the navigator.
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Inject protected Navigator navigator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
    navigator.setActivity(this);
  }

  private void injectDependencies() {
    MarvelApp marvelApp = (MarvelApp) getApplication();
    marvelApp.inject(this);
  }
}
