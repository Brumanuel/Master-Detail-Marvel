package com.garcilomanuel.masterdetailmarvel.domain.interactor;

import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.List;

/**
 * Created by Manuel García.
 */
public interface GetComicsByCharacter {

  void get(int id, Callback callback);

  interface Callback {
    void onSuccess(List<Comic> comics);

    void onError(Throwable throwable);
  }
}
