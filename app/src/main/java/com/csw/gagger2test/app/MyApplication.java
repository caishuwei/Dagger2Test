package com.csw.gagger2test.app;

import android.app.Application;

import com.csw.gagger2test.di.component.AppComponent;
import com.csw.gagger2test.di.component.DaggerAppComponent;

/**
 * Created by caisw on 2017/10/31.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.instance = this;
        setupComponent();
    }

    private void setupComponent() {
        appComponent = DaggerAppComponent.builder()
                .myApplication(this)
                .build();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
