package com.garcilomanuel.masterdetailmarvel.app.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Manuel García.
 *
 */
public class MainThreadExecutorImp implements MainThreadExecutor {

  private Handler handler;

  public MainThreadExecutorImp() {
    this.handler = new Handler(Looper.getMainLooper());
  }

  @Override
  public void execute(Runnable runnable) {
    handler.post(runnable);
  }
}
