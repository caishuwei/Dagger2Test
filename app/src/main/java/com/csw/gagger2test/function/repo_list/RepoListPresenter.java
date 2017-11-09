package com.csw.gagger2test.function.repo_list;

import com.csw.gagger2test.entities.Repo;
import com.csw.gagger2test.http.CommonCallback;
import com.csw.gagger2test.http.GithubApiService;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by caisw on 2017/11/6.
 */

public class RepoListPresenter implements RepoListContract.Presenter {

    private GithubApiService githubApiService;
    private RepoListContract.View view;
    private String userName;
    private ArrayList<Repo> repoList = new ArrayList<>();

    @Inject
    public RepoListPresenter(GithubApiService githubApiService, RepoListContract.View view) {
        this.githubApiService = githubApiService;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void end() {

    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void loadData() {
        if (repoList.isEmpty()) {
            refreshData();
        } else {
            view.updateList(repoList);
        }
    }

    @Override
    public void refreshData() {
        repoList.clear();
        view.showDataLoading();
        new CommonCallback<ArrayList<Repo>>() {
            @Override
            public void onSucceed(ArrayList<Repo> repos) {
                if (repos != null) {
                    repoList.addAll(repos);
                }
                view.hideDataLoading();
                view.updateList(repoList);
            }

            @Override
            public void onFailed(Throwable e) {
                super.onFailed(e);
                view.hideDataLoading();
                view.showDataRequestError(e);
            }
        }.execute(githubApiService.getRepoData(userName));
    }
}
