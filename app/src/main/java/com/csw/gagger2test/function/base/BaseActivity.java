package com.csw.gagger2test.function.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.csw.gagger2test.di.component.AppComponent;
import com.csw.gagger2test.app.MyApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity基类
 * Created by caisw on 2017/10/31.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        unbinder = ButterKnife.bind(this);
        setupActivityComponent(MyApplication.getInstance().getAppComponent());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    protected abstract int getContentViewId();

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
