package com.csw.gagger2test.di.component;

import com.csw.gagger2test.function.repo_list.RepoListContract;
import com.csw.gagger2test.function.repo_list.RepoListFragment;
import com.csw.gagger2test.function.repo_list.RepoListModule;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * Created by caisw on 2017/11/3.
 */

@Subcomponent(modules = {RepoListModule.class})
public interface RepoListComponent {

    void inject(RepoListFragment fragment);

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder setView(RepoListContract.View view);

        RepoListComponent build();

    }

}
