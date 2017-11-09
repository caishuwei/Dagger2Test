package com.csw.gagger2test.function.repo_list;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Toast;

import com.csw.gagger2test.R;
import com.csw.gagger2test.adapter.RepoAdapter;
import com.csw.gagger2test.app.MyApplication;
import com.csw.gagger2test.di.annotation.qualifier.LongToast;
import com.csw.gagger2test.entities.Repo;
import com.csw.gagger2test.function.base.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 仓库列表碎片
 * Created by caisw on 2017/11/6.
 */

public class RepoListFragment extends BaseFragment implements RepoListContract.View {

    @BindView(R.id.rv_repo_list)
    RecyclerView rv_repo_list;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srl_refresh;
    private RepoAdapter repoAdapter;

    @Inject
    RepoListContract.Presenter presenter;
    @Inject
    @LongToast
    Toast toast;
    private String userName;

    public RepoListFragment() {
        MyApplication.getInstance().getAppComponent().getRepoListComponentBuilder().setView(this).build().inject(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_repo_list;
    }

    @Override
    protected void initView() {
        super.initView();
        rv_repo_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_repo_list.setAdapter(repoAdapter = new RepoAdapter(null));

        srl_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                repoAdapter.setNewData(null);
                presenter.refreshData();
            }
        });
        srl_refresh.setRefreshing(true);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoadData();
    }


    @Override
    protected void getData() {
        super.getData();
        lazyLoadData();
    }

    private void lazyLoadData() {
        if (getUserVisibleHint() && isVisible()) {
            if (getArguments() != null) {
                userName = getArguments().getString("userName", null);
                if (userName == null) {
                    throw new IllegalArgumentException("Arguments-->userName is not null");
                }
                presenter.setUserName(userName);
            }
            presenter.loadData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        repoAdapter = null;//适配器持有列表引用，必须释放
    }

    @Override
    public void setPresenter(RepoListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showDataLoading() {
        if (getView() != null) {
            if (!srl_refresh.isRefreshing()) {
                srl_refresh.setRefreshing(true);
            }
        }
    }

    @Override
    public void hideDataLoading() {
        if (getView() != null) {
            if (srl_refresh.isRefreshing()) {
                srl_refresh.setRefreshing(false);
            }
        }
    }

    @Override
    public void updateList(ArrayList<Repo> repos) {
        if (userName != null) {
            toast.setText(userName + "数据返回-->repoList size = " + (repos == null ? 0 : repos.size()));
            toast.show();
        }
        if (getView() != null) {
            repoAdapter.setNewData(repos);
        }
    }

    @Override
    public void showDataRequestError(Throwable e) {
        if (e != null && !TextUtils.isEmpty(e.getMessage())) {
            toast.setText(e.getMessage());
        } else {
            toast.setText("请求失败");
        }
        toast.show();
    }

    public static RepoListFragment newInstance(String userName) {
        RepoListFragment fragment = new RepoListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("userName", userName);
        fragment.setArguments(bundle);
        return fragment;
    }
}


