package com.garcilomanuel.masterdetailmarvel.app.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Manuel García.
 *
 * ThreadPoolExecutor to launch the threads (Interactors).
 */
public class InteractorExecutorImp implements InteractorExecutor {

  private static final int CORE_POOL_SIZE = 3;
  private static final int MAX_POOL_SIZE = 5;
  private static final int KEEP_ALIVE_TIME = 120;
  private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
  private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();
  private ThreadPoolExecutor threadPoolExecutor;

  public InteractorExecutorImp() {
    threadPoolExecutor =
        new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT,
            WORK_QUEUE);
  }

  @Override
  public void execute(Interactor interactor) {
    if (interactor != null) {
      threadPoolExecutor.submit(interactor);
    }
  }
}
