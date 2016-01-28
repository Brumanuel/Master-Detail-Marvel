package com.garcilomanuel.masterdetailmarvel.domain.interactor;

import com.garcilomanuel.masterdetailmarvel.app.executor.Interactor;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;

/**
 * Created by Manuel García.
 */
public interface GetComicById extends Interactor {

  void get(String id, Callback callback);

  interface Callback {
    void onSuccess(Comic comic);

    void onError(Throwable throwable);
  }
}
