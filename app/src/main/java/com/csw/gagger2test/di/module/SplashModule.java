package com.csw.gagger2test.di.module;

import com.csw.gagger2test.function.splash.SplashContract;
import com.csw.gagger2test.function.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by caisw on 2017/11/6.
 */
@Module
public class SplashModule {

    @Provides
    public SplashContract.Presenter providePresenter(SplashPresenter presenter) {
        return presenter;
    }

}
