package com.csw.gagger2test.di.component;

import com.csw.gagger2test.function.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by caisw on 2017/11/3.
 */

@Subcomponent
public interface MainComponent {

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder {

        MainComponent build();
    }

}
