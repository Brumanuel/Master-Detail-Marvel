package com.garcilomanuel.masterdetailmarvel.ui.comiclist.presenter;

import com.garcilomanuel.masterdetailmarvel.app.navigator.Navigator;
import com.garcilomanuel.masterdetailmarvel.data.marvel.ApiParams;
import com.garcilomanuel.masterdetailmarvel.domain.interactor.GetComicsByCharacter;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.List;

/**
 * Created by Manuel García.
 */
public class ComicsListPresenterImp extends ComicsListPresenter {

  private GetComicsByCharacter getComicsByCharacter;
  private Navigator navigator;

  public ComicsListPresenterImp(GetComicsByCharacter getComicsByCharacter, Navigator navigator) {
    this.getComicsByCharacter = getComicsByCharacter;
    this.navigator = navigator;
  }

  @Override
  public void onViewCreated() {
    getComicsByCharacter.get(ApiParams.IRON_MAN_ID, new GetComicsByCharacter.Callback() {
      @Override
      public void onSuccess(List<Comic> comics) {
        view.showComics(comics);
      }

      @Override
      public void onError(Throwable throwable) {
        view.showError(throwable.getMessage());
      }
    });
  }

  @Override
  public void onComicSelected(String comicId) {
    navigator.goDetailsView(comicId);
  }
}
