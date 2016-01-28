package com.garcilomanuel.masterdetailmarvel.data.marvel.mapper;

import com.garcilomanuel.masterdetailmarvel.data.model.MarvelResponse;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.List;

/**
 * Created by Manuel García.
 */
public interface MarvelApiToDomainMapper {

  List<Comic> mapMarvelResponseToComics(MarvelResponse marvelResponse);
}
