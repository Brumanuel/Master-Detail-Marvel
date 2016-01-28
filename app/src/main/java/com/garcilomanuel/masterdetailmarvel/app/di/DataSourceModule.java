package com.garcilomanuel.masterdetailmarvel.app.di;

import com.garcilomanuel.masterdetailmarvel.data.ComicDataSource;
import com.garcilomanuel.masterdetailmarvel.data.marvel.MarvelRetrofitSource;
import com.garcilomanuel.masterdetailmarvel.data.marvel.mapper.MarvelApiToDomainMapper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Manuel García.
 */

@Module(
    complete = false,
    library = true)
public class DataSourceModule {

  @Provides
  @Singleton
  public ComicDataSource providesComicDataSource(MarvelApiToDomainMapper marvelApiToDomain) {
    return new MarvelRetrofitSource(marvelApiToDomain);
  }
}
