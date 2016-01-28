package com.garcilomanuel.masterdetailmarvel.ui.comiclist.view;

import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import com.garcilomanuel.masterdetailmarvel.ui.View;
import java.util.List;

/**
 * Created by Manuel García.
 */
public interface ComicsListView extends View {

  void showComics(List<Comic> comicList);

  void showError(String message);

}
