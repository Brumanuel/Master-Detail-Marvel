package com.garcilomanuel.masterdetailmarvel.app.di;

import com.garcilomanuel.masterdetailmarvel.data.ComicDataSource;
import com.garcilomanuel.masterdetailmarvel.domain.repository.ComicRepository;
import com.garcilomanuel.masterdetailmarvel.domain.repository.ComicRespositoryImp;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Manuel García.
 */

@Module(
    complete = false,
    library = true)
public class RepositoriModule {

  @Provides
  @Singleton
  ComicRepository provideComicRepositori(ComicDataSource comicDataSource) {
    return new ComicRespositoryImp(comicDataSource);
  }
}
