package com.csw.gagger2test.di.component;

import com.csw.gagger2test.function.main.MainActivity;
import com.csw.gagger2test.function.main.MainContract;
import com.csw.gagger2test.function.main.MainModule;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * Created by caisw on 2017/11/3.
 */

@Subcomponent(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    RepoListComponent.Builder getRepoListComponentBuilder();

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder setView(MainContract.View view);

        MainComponent build();
    }

}
