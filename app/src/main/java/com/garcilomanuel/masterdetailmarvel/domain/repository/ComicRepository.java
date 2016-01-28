package com.garcilomanuel.masterdetailmarvel.domain.repository;

import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.List;

/**
 * Created by Manuel García.
 */
public interface ComicRepository {

  void addComic(Comic comic);

  void addComics(List<Comic> comics);

  Comic getComic(String id);

  void deleteComic(String id);

  List<Comic> getComics(int idCharacter);

  List<Comic> getAllComics();

  void clear();
}
