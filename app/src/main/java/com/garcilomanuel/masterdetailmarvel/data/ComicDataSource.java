package com.garcilomanuel.masterdetailmarvel.data;

import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.List;

/**
 * Created by Manuel García.
 */
public interface ComicDataSource {

  List<Comic> getComics(int characterId);
}
