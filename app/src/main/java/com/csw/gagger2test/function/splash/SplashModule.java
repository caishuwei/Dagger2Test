package com.csw.gagger2test.function.splash;

import dagger.Module;
import dagger.Provides;

/**
 * Created by caisw on 2017/11/6.
 */
@Module
public class SplashModule {

    @Provides
    public SplashContract.Presenter providePresenter(SplashContract.View view) {
        return new SplashPresenter(view);
    }

}
