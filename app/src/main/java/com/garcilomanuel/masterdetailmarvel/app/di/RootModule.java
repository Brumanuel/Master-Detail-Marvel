package com.garcilomanuel.masterdetailmarvel.app.di;

import android.content.Context;
import com.garcilomanuel.masterdetailmarvel.app.MarvelApp;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.view.ComicDetailActivity;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetail.view.ComicDetailViewFragment;
import com.garcilomanuel.masterdetailmarvel.ui.comiclist.view.ComicsListViewFragment;
import com.garcilomanuel.masterdetailmarvel.ui.main.view.MainActivity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Manuel García.
 */

@Module(
    includes = {
        ExecutorModule.class,
        DataSourceModule.class,
        MapperModule.class,
        NavigatorModule.class,
        InteractorModule.class,
        RepositoriModule.class,
        PresenterModule.class
    },
    injects = {
        MarvelApp.class,
        MainActivity.class,
        ComicsListViewFragment.class,
        ComicDetailViewFragment.class,
        ComicDetailActivity.class
    },
    library = true)
public class RootModule {

  private final Context context;

  public RootModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton
  public Context provideContext() {
    return context;
  }
}
