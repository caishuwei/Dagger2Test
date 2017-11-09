package com.csw.gagger2test.di.module;

import com.csw.gagger2test.function.main.MainContract;
import com.csw.gagger2test.function.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by caisw on 2017/11/6.
 */

@Module
public class MainModule {

    @Provides
    public MainContract.Presenter providePresenter(MainPresenter presenter){
        return presenter;
    }

}
