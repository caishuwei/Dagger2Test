package com.csw.gagger2test.function.splash;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * 启动切面
 * Created by caisw on 2017/11/6.
 */

public class SplashPresenter implements SplashContract.Presenter {
    private static final long DURATION = 3 * 1000;
    private final SplashContract.View view;
    private Handler handler;
    private Runnable timerRunnable;
    private long startTime;
    private boolean end = false;

    @Inject
    public SplashPresenter(SplashContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        //开始计时，三秒后进入主界面
        startTime = System.currentTimeMillis();
        handler = new Handler(Looper.getMainLooper());
        timerRunnable = new Runnable() {
            @Override
            public void run() {
                if (end) {
                    return;
                }
                long remainingTime = DURATION - (System.currentTimeMillis() - startTime);
                if (remainingTime >= 0) {
                    view.updateRemainingTime(remainingTime);
                    handler.post(timerRunnable);
                } else {
                    view.start2Main();
                }
            }
        };
        handler.post(timerRunnable);
    }

    @Override
    public void end() {
        end = true;
    }

}
