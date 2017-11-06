package com.csw.gagger2test.function.splash;

import com.csw.gagger2test.mvp.BasePresenter;
import com.csw.gagger2test.mvp.BaseView;

/**
 * 启动界面协议
 * Created by caisw on 2017/11/6.
 */

public class SplashContract {

    public interface View extends BaseView<Presenter> {
        void updateRemainingTime(long remainingTime);

        void start2Main();
    }

    public interface Presenter extends BasePresenter {
    }

}
