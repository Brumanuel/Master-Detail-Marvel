package com.garcilomanuel.masterdetailmarvel.domain.repository;

import com.garcilomanuel.masterdetailmarvel.data.ComicDataSource;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Manuel García.
 */
public class ComicRespositoryImpTest {

  @Test
  public void addComicToRepository() {
    ComicDataSource comicDataSource = mock(ComicDataSource.class);
    ComicRespositoryImp comicRespositoryImp = new ComicRespositoryImp(comicDataSource);

    Comic comic = mock(Comic.class);
    when(comic.getId()).thenReturn("1");
    comicRespositoryImp.addComic(comic);

    assertTrue(comicRespositoryImp.getAllComics().size() > 0);
  }

  @Test
  public void clearRepository() {
    ComicDataSource comicDataSource = mock(ComicDataSource.class);
    ComicRespositoryImp comicRespositoryImp = new ComicRespositoryImp(comicDataSource);

    Comic comic = mock(Comic.class);
    when(comic.getId()).thenReturn("1");
    comicRespositoryImp.addComic(comic);

    comicRespositoryImp.clear();

    assertTrue(comicRespositoryImp.getAllComics().size() == 0);
  }

  @Test
  public void deleteComic() {
    ComicDataSource comicDataSource = mock(ComicDataSource.class);
    ComicRespositoryImp comicRespositoryImp = new ComicRespositoryImp(comicDataSource);

    Comic comic = mock(Comic.class);
    when(comic.getId()).thenReturn("1");
    comicRespositoryImp.addComic(comic);

    comicRespositoryImp.deleteComic("1");

    assertTrue(comicRespositoryImp.getComic("1") == null);
  }
}