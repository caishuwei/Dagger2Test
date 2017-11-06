package com.csw.gagger2test.function.splash;

import android.content.Intent;
import android.widget.TextView;

import com.csw.gagger2test.R;
import com.csw.gagger2test.function.base.BaseActivity;
import com.csw.gagger2test.function.main.MainActivity;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by caisw on 2017/11/6.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @BindView(R.id.tv_remaining_time)
    TextView tv_remaining_time;
    @Inject
    SplashContract.Presenter presenter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        super.initView();
        getSupportActionBar().setTitle("SplashActivity");
    }

    @Override
    protected void getData() {
        super.getData();
        getAppComponent().getSplashComponentBuilder().setView(this).build().inject(this);
        presenter.start();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateRemainingTime(long remainingTime) {
        String time = String.format(Locale.getDefault(), "%02d:%02d", remainingTime / 1000, remainingTime % 1000 / 10);
        tv_remaining_time.setText(time);
    }

    @Override
    public void start2Main() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.end();
        super.onDestroy();
    }
}
