package com.garcilomanuel.masterdetailmarvel.ui.comicdetail.presenter;

import com.garcilomanuel.masterdetailmarvel.domain.interactor.GetComicById;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.Random;

/**
 * Created by Manuel García.
 */
public class ComicDetailPresenterImp extends ComicDetailPresenter {

  private GetComicById getComicById;

  public ComicDetailPresenterImp(GetComicById getComicById) {
    this.getComicById = getComicById;
  }

  @Override
  public void onViewReady(String comicId) {
    getComicById.get(comicId, new GetComicById.Callback() {
      @Override
      public void onSuccess(Comic comic) {
        view.showComic(comic, getRandomImage(comic));
      }

      @Override
      public void onError(Throwable throwable) {
        view.showError(throwable.getMessage());
      }
    });
  }

  //Generate a position random in image array
  private int getRandomImage(Comic comic) {
    Random random = new Random();
    int totalImages = comic.getUrlImages().size();

    return random.nextInt(totalImages);
  }
}
