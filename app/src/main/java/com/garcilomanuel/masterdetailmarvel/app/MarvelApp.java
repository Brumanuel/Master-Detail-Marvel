package com.garcilomanuel.masterdetailmarvel.app;

import android.app.Application;
import android.content.Context;
import com.garcilomanuel.masterdetailmarvel.app.di.RootModule;
import dagger.ObjectGraph;

/**
 * Created by Manuel García.
 *
 *  * Application with injection Dagger
 */
public class MarvelApp extends Application {

  private ObjectGraph objectGraph;

  public static MarvelApp get(Context context) {
    return (MarvelApp) context.getApplicationContext();
  }

  @Override
  public void onCreate() {
    super.onCreate();
    objectGraph = ObjectGraph.create(new RootModule(this));
    objectGraph.inject(this);
  }

  public void inject(Object object) {
    objectGraph.inject(object);
  }
}
