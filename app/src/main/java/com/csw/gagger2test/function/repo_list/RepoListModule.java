package com.csw.gagger2test.function.repo_list;

import com.csw.gagger2test.http.GithubApiService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by caisw on 2017/11/6.
 */
@Module
public class RepoListModule {

    @Provides
    public RepoListContract.Presenter providePresenter(GithubApiService githubApiService, RepoListContract.View view) {
        return new RepoListPresenter(githubApiService, view);
    }

}
