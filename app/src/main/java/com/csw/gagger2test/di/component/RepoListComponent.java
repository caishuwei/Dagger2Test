package com.csw.gagger2test.di.component;

import com.csw.gagger2test.function.repo_list.RepoListActivity;

import dagger.Subcomponent;

/**
 * Created by caisw on 2017/11/3.
 */

@Subcomponent()
public interface RepoListComponent {

    void inject(RepoListActivity activity);

    @Subcomponent.Builder
    interface Builder {

        RepoListComponent build();

    }

}
