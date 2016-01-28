package com.garcilomanuel.masterdetailmarvel.ui.comicdetail.view;

import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import com.garcilomanuel.masterdetailmarvel.ui.View;

/**
 * Created by Manuel García.
 */
public interface ComicDetailView extends View {

  void showComic(Comic comic, int idImageToShow);

  void showError(String message);
}
