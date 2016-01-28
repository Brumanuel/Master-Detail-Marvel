package com.garcilomanuel.masterdetailmarvel.domain.interactor;

import com.garcilomanuel.masterdetailmarvel.app.base.BaseInteractor;
import com.garcilomanuel.masterdetailmarvel.app.executor.InteractorExecutor;
import com.garcilomanuel.masterdetailmarvel.app.executor.MainThreadExecutor;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import com.garcilomanuel.masterdetailmarvel.domain.repository.ComicRepository;

/**
 * Created by Manuel García.
 */
public class GetComicByIdImp extends BaseInteractor implements GetComicById {

  private ComicRepository comicRepository;
  private String id;
  private Callback callback;

  public GetComicByIdImp(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, ComicRepository comicRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.comicRepository = comicRepository;
  }

  @Override
  public void get(String id, Callback callback) {
    this.id = id;
    this.callback = callback;
    executeCurrentInteractor();
  }

  @Override
  public void run() {
    try {
      Comic comic = comicRepository.getComic(id);
      onSuccess(comic);
    } catch (Exception e) {
      onError(e.getCause());
    }
  }


  //Response callback success on MainThread
  private void onSuccess(final Comic comic) {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onSuccess(comic);
      }
    });
  }

  //Response callback error on MainThread
  private void onError(final Throwable throwable) {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onError(throwable);
      }
    });
  }
}
