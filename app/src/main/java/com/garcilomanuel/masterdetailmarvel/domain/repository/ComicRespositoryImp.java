package com.garcilomanuel.masterdetailmarvel.domain.repository;

import com.garcilomanuel.masterdetailmarvel.data.ComicDataSource;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manuel García.
 */
public class ComicRespositoryImp implements ComicRepository {

  private ComicDataSource comicDataSource;
  private Map<String, Comic> comics = new HashMap<>();

  public ComicRespositoryImp(ComicDataSource comicDataSource) {
    this.comicDataSource = comicDataSource;
  }

  @Override
  public void addComic(Comic comic) {
    comics.put(comic.getId(), comic);
  }

  @Override
  public void addComics(List<Comic> comicsList) {
    for (Comic comic : comicsList) {
      comics.put(comic.getId(), comic);
    }
  }

  @Override
  public Comic getComic(String id) {
    return comics.get(id);
  }

  @Override
  public void deleteComic(String id) {
    comics.remove(id);
  }

  @Override
  public List<Comic> getComics(int idCharacter) {
    addComics(comicDataSource.getComics(idCharacter));
    return new ArrayList<>(comics.values());
  }

  @Override
  public List<Comic> getAllComics() {
    return new ArrayList<>(comics.values());
  }

  @Override
  public void clear() {
    comics.clear();
  }
}
