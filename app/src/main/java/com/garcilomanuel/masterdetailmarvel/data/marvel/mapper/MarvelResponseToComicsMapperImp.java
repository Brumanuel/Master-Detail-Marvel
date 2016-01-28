package com.garcilomanuel.masterdetailmarvel.data.marvel.mapper;

import com.garcilomanuel.masterdetailmarvel.data.model.Image;
import com.garcilomanuel.masterdetailmarvel.data.model.MarvelResponse;
import com.garcilomanuel.masterdetailmarvel.data.model.Result;
import com.garcilomanuel.masterdetailmarvel.data.model.Thumbnail;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel García.
 */
public class MarvelResponseToComicsMapperImp implements MarvelApiToDomainMapper {

  public List<Comic> mapMarvelResponseToComics(MarvelResponse marvelResponse) {
    List<Comic> comics = new ArrayList<>();
    for (Result result : marvelResponse.getData().getResults()) {
      comics.add(mapResultToComic(result));
    }
    return comics;
  }

  private Comic mapResultToComic(Result result) {
    Comic comic = new Comic();

    comic.setId(result.getId());
    comic.setDescription(result.getDescription());
    comic.setPages(result.getPageCount());
    comic.setThumnailUri(mapThumbnailToThumnailUri(result.getThumbnail()));
    comic.setTitle(result.getTitle());
    comic.setUrlImages(mapImages(result.getImages()));
    comic.setAuthor(result.getFormat());

    return comic;
  }

  private String mapThumbnailToThumnailUri(Thumbnail thumbnail) {
    return thumbnail.getPath() + "." + thumbnail.getExtension();
  }

  private List<String> mapImages(List<Image> images) {
    List<String> urlImages = new ArrayList<>();

    for (Image image : images) {
      urlImages.add(image.getPath() + "." + image.getExtension());
    }
    return urlImages;
  }
}
