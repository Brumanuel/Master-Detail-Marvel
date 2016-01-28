package com.garcilomanuel.masterdetailmarvel.data.marvel;

import com.garcilomanuel.masterdetailmarvel.data.model.MarvelResponse;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Manuel García.
 */
public interface RetrofiteService {

  @GET("/v1/public/characters/{characterId}/comics")
  MarvelResponse getComics(@Path("characterId") int characterId);
}
