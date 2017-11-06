package com.csw.gagger2test.function.main;

import dagger.Module;
import dagger.Provides;

/**
 * Created by caisw on 2017/11/6.
 */

@Module
public class MainModule {

    @Provides
    public MainContract.Presenter providePresenter(MainContract.View view){
        return new MainPresenter(view);
    }

}
