package com.garcilomanuel.masterdetailmarvel.app.di;

import com.garcilomanuel.masterdetailmarvel.data.marvel.mapper.MarvelApiToDomainMapper;
import com.garcilomanuel.masterdetailmarvel.data.marvel.mapper.MarvelResponseToComicsMapperImp;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Manuel García.
 */

@Module(
    complete = false,
    library = true)
public class MapperModule {

  @Provides
  MarvelApiToDomainMapper provideMarvelToDomainMapper() {
    return new MarvelResponseToComicsMapperImp();
  }
}
