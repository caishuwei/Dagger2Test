package com.csw.gagger2test.function.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.csw.gagger2test.app.MyApplication;
import com.csw.gagger2test.di.component.AppComponent;

import butterknife.ButterKnife;

/**
 * Activity基类
 * Created by caisw on 2017/10/31.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private AppComponent appComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        appComponent = MyApplication.getInstance().getAppComponent();
        initView();
        initListener();
        getData();
    }

    protected abstract int getContentViewId();

    protected void initView() {

    }

    protected void initListener() {

    }

    protected void getData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
