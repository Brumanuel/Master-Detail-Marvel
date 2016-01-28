package com.garcilomanuel.masterdetailmarvel.domain.interactor;

import com.garcilomanuel.masterdetailmarvel.app.base.BaseInteractor;
import com.garcilomanuel.masterdetailmarvel.app.executor.InteractorExecutor;
import com.garcilomanuel.masterdetailmarvel.app.executor.MainThreadExecutor;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import com.garcilomanuel.masterdetailmarvel.domain.repository.ComicRepository;
import java.util.List;

/**
 * Created by Manuel García.
 */
public class GetComicsByCharacterId extends BaseInteractor implements GetComicsByCharacter {

  private ComicRepository comicRepository;
  private int id;
  private Callback callback;

  public GetComicsByCharacterId(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, ComicRepository comicRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.comicRepository = comicRepository;
  }

  @Override
  public void run() {
    try {
      List<Comic> comics = comicRepository.getComics(id);
      onSuccess(comics);
    } catch (Exception e) {
      onError(e.getCause());
    }
  }

  @Override
  public void get(int characterId, Callback callback) {
    this.id = characterId;
    this.callback = callback;
    executeCurrentInteractor();
  }

  private void onSuccess(final List<Comic> comics) {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onSuccess(comics);
      }
    });
  }

  private void onError(final Throwable throwable) {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onError(throwable);
      }
    });
  }
}
