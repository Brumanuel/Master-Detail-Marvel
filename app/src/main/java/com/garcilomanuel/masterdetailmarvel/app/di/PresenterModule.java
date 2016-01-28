package com.garcilomanuel.masterdetailmarvel.app.di;

import com.garcilomanuel.masterdetailmarvel.app.navigator.Navigator;
import com.garcilomanuel.masterdetailmarvel.domain.interactor.GetComicById;
import com.garcilomanuel.masterdetailmarvel.domain.interactor.GetComicsByCharacter;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetail.presenter.ComicDetailPresenter;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetail.presenter.ComicDetailPresenterImp;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.presenter.ComicDetailContainerPresenterImp;
import com.garcilomanuel.masterdetailmarvel.ui.comicdetailcontainer.presenter.ComicDetailContainterPresenter;
import com.garcilomanuel.masterdetailmarvel.ui.comiclist.presenter.ComicsListPresenter;
import com.garcilomanuel.masterdetailmarvel.ui.comiclist.presenter.ComicsListPresenterImp;
import com.garcilomanuel.masterdetailmarvel.ui.main.presenter.MainPresenter;
import com.garcilomanuel.masterdetailmarvel.ui.main.presenter.MainPresenterImp;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Manuel García.
 */

@Module(
    complete = false,
    library = true)
public class PresenterModule {

  @Provides
  ComicsListPresenter providesComicsListPresenter(GetComicsByCharacter getComicsByCharacter,
      Navigator navigator) {
    return new ComicsListPresenterImp(getComicsByCharacter, navigator);
  }

  @Provides
  ComicDetailPresenter providesComicDetailPresenter(GetComicById getComicById) {
    return new ComicDetailPresenterImp(getComicById);
  }

  @Provides
  MainPresenter provideMainPresenter() {
    return new MainPresenterImp();
  }

  @Provides
  ComicDetailContainterPresenter provideComicDetailContainterPresenter(Navigator navigator) {
    return new ComicDetailContainerPresenterImp(navigator);
  }
}
