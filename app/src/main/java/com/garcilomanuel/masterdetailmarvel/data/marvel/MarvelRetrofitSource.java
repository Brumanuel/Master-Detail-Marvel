package com.garcilomanuel.masterdetailmarvel.data.marvel;

import android.util.Log;
import com.garcilomanuel.masterdetailmarvel.data.ComicDataSource;
import com.garcilomanuel.masterdetailmarvel.data.marvel.mapper.MarvelApiToDomainMapper;
import com.garcilomanuel.masterdetailmarvel.data.marvel.requestinterceptor.MarvelRequestInterceptor;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import java.util.List;
import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Manuel García.
 */
public class MarvelRetrofitSource implements ComicDataSource {

  private final String TAG = this.getClass().getSimpleName();

  private RetrofitService retrofitService;
  private MarvelApiToDomainMapper marvelApiToDomain;

  public MarvelRetrofitSource(MarvelApiToDomainMapper marvelApiToDomain) {
    this.marvelApiToDomain = marvelApiToDomain;
    initAdapter();
  }

  private void initAdapter() {
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ApiParams.ENDPOINT)
        .setErrorHandler(new ErrorHandler() {
              @Override
              public Throwable handleError(RetrofitError cause) {
                Log.e(TAG, cause.toString());
                return cause.fillInStackTrace();
              }
            })
        .setRequestInterceptor(
            new MarvelRequestInterceptor(ApiParams.API_PUBLIC_KEY, ApiParams.API_PRIVATE_KEY))
        .build();
    retrofitService = restAdapter.create(RetrofitService.class);
  }

  @Override
  public List<Comic> getComics(int characterId) {
    return marvelApiToDomain.mapMarvelResponseToComics(retrofitService.getComics(characterId));
  }
}
