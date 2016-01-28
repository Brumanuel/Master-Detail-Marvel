package com.garcilomanuel.masterdetailmarvel.app.di;

import com.garcilomanuel.masterdetailmarvel.app.executor.InteractorExecutor;
import com.garcilomanuel.masterdetailmarvel.app.executor.MainThreadExecutor;
import com.garcilomanuel.masterdetailmarvel.domain.interactor.GetComicById;
import com.garcilomanuel.masterdetailmarvel.domain.interactor.GetComicByIdImp;
import com.garcilomanuel.masterdetailmarvel.domain.interactor.GetComicsByCharacter;
import com.garcilomanuel.masterdetailmarvel.domain.interactor.GetComicsByCharacterId;
import com.garcilomanuel.masterdetailmarvel.domain.repository.ComicRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Manuel García.
 */

@Module(
    complete = false,
    library = true)
public class InteractorModule {

  @Provides
  GetComicsByCharacter getComicsByCharacter(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, ComicRepository comicRepository) {
    return new GetComicsByCharacterId(interactorExecutor, mainThreadExecutor, comicRepository);
  }

  @Provides
  GetComicById getGetComicById(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, ComicRepository comicRepository) {
    return new GetComicByIdImp(interactorExecutor, mainThreadExecutor, comicRepository);
  }
}
