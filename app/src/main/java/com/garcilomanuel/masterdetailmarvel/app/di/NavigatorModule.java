package com.garcilomanuel.masterdetailmarvel.app.di;

import com.garcilomanuel.masterdetailmarvel.app.navigator.Navigator;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Manuel García.
 */

@Module(
    complete = false,
    library = true)
public class NavigatorModule {

  @Provides
  @Singleton
  Navigator providesNavigator(){
    return  new Navigator();
  }
}
