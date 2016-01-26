package com.garcilomanuel.masterdetailmarvel.app.executor;

/**
 * Created by Manuel García.
 */
public interface MainThreadExecutor {

  void execute(Runnable runnable);
}
