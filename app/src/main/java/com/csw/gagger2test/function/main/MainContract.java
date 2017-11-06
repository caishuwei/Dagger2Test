package com.csw.gagger2test.function.main;

import com.csw.gagger2test.mvp.BasePresenter;
import com.csw.gagger2test.mvp.BaseView;

import java.util.List;

/**
 * 主界面协议
 * Created by caisw on 2017/11/6.
 */

public interface MainContract {

    public interface View extends BaseView<Presenter> {

        void updateUserList(List<String> strings);
    }

    public interface Presenter extends BasePresenter{

    }
}
