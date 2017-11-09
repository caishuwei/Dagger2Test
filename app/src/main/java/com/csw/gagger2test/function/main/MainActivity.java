package com.csw.gagger2test.function.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.csw.gagger2test.R;
import com.csw.gagger2test.adapter.RepoListFragmentAdapter;
import com.csw.gagger2test.di.component.RepoListComponent;
import com.csw.gagger2test.function.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 主界面
 * Created by caisw on 2017/10/31.
 */

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.tl_user_list)
    TabLayout tl_user_list;
    @BindView(R.id.vp_user_repo_list)
    ViewPager vp_user_repo_list;

    @Inject
    MainContract.Presenter presenter;
    private RepoListFragmentAdapter userListAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        getAppComponent().getMainComponentBuilder()
                .setView(this)
                .build()
                .inject(this);
        vp_user_repo_list.setAdapter(userListAdapter = new RepoListFragmentAdapter(getSupportFragmentManager(), null));
        tl_user_list.setupWithViewPager(vp_user_repo_list);
    }

    @Override
    protected void getData() {
        super.getData();
        presenter.start();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateUserList(List<String> strings) {
        userListAdapter.setNewData(strings);
    }
}
