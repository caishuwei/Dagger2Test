package com.csw.gagger2test.function.repo_list;

import com.csw.gagger2test.entities.Repo;
import com.csw.gagger2test.mvp.BasePresenter;
import com.csw.gagger2test.mvp.BaseView;

import java.util.ArrayList;

/**
 * 仓库列表协议
 * Created by caisw on 2017/11/6.
 */

public interface RepoListContract {

    public interface View extends BaseView<Presenter> {

        void showDataLoading();

        void hideDataLoading();

        void updateList(ArrayList<Repo> repos);

        void showDataRequestError(Throwable e);
    }

    public interface Presenter extends BasePresenter {
        void setUserName(String userName);
        void refreshData();
    }

}
