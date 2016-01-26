package com.garcilomanuel.masterdetailmarvel.app.base;

import com.garcilomanuel.masterdetailmarvel.app.executor.Interactor;
import com.garcilomanuel.masterdetailmarvel.app.executor.InteractorExecutor;
import com.garcilomanuel.masterdetailmarvel.app.executor.MainThreadExecutor;

/**
 * Created by Manuel García.
 */
public abstract class BaseInteractor implements Interactor {

  private InteractorExecutor interactorExecutor;
  private MainThreadExecutor mainThreadExecutor;

  public BaseInteractor(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor) {
    this.interactorExecutor = interactorExecutor;
    this.mainThreadExecutor = mainThreadExecutor;
  }

  public void executeCurrentInteractor() {
    interactorExecutor.execute(this);
  }

  public void executeInMainThread(Runnable runnable) {
    mainThreadExecutor.execute(runnable);
  }
}
