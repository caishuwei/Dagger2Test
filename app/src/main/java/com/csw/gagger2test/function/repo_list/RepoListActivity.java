package com.csw.gagger2test.function.repo_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.csw.gagger2test.R;
import com.csw.gagger2test.adapter.RepoAdapter;
import com.csw.gagger2test.app.MyApplication;
import com.csw.gagger2test.di.annotation.qualifier.LongToast;
import com.csw.gagger2test.di.component.AppComponent;
import com.csw.gagger2test.entities.Repo;
import com.csw.gagger2test.function.base.BaseActivity;
import com.csw.gagger2test.http.CommonCallback;
import com.csw.gagger2test.http.GithubApiService;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 用户仓库列表界面
 * Created by caisw on 2017/10/31.
 */

public class RepoListActivity extends BaseActivity {

    @BindView(R.id.rv_repo_list)
    RecyclerView rv_repo_list;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srl_refresh;
    private RepoAdapter repoAdapter;

    @Inject
    GithubApiService githubApiService;
    @Inject
    @LongToast
    Toast toast;

    @Inject
    MyApplication myApplication;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        appComponent.getRepoListComponentBuilder()
                .build()
                .inject(this);//AppComponent注入GithubApiService
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_repos_list;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rv_repo_list.setLayoutManager(new LinearLayoutManager(this));
        rv_repo_list.setAdapter(repoAdapter = new RepoAdapter(null));

        srl_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        srl_refresh.setRefreshing(true);

        toast.setText("Application Toast");
        toast.show();
        refresh();
    }

    private void refresh() {
        new CommonCallback<ArrayList<Repo>>() {
            @Override
            public void onSucceed(ArrayList<Repo> repos) {
                repoAdapter.setNewData(repos);
                srl_refresh.setRefreshing(false);
                toast.setText("RepoList Request Success");
                toast.show();
            }

            @Override
            public void onFailed(Throwable e) {
                super.onFailed(e);
                srl_refresh.setRefreshing(false);
                toast.setText("RepoList Request Failure");
                toast.show();
            }
        }.execute(githubApiService.getRepoData("bird1015"));
    }
}
