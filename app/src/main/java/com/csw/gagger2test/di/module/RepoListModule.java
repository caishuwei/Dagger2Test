package com.csw.gagger2test.di.module;

import com.csw.gagger2test.function.repo_list.RepoListContract;
import com.csw.gagger2test.function.repo_list.RepoListPresenter;
import com.csw.gagger2test.http.GithubApiService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by caisw on 2017/11/6.
 */
@Module
public class RepoListModule {

    @Provides
    public RepoListContract.Presenter providePresenter(RepoListPresenter presenter) {
        return presenter;
    }

}
