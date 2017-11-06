package com.csw.gagger2test.function.main;

import android.content.Intent;
import android.widget.Toast;

import com.csw.gagger2test.R;
import com.csw.gagger2test.app.MyApplication;
import com.csw.gagger2test.di.annotation.qualifier.LongToast;
import com.csw.gagger2test.di.component.AppComponent;
import com.csw.gagger2test.function.base.BaseActivity;
import com.csw.gagger2test.function.repo_list.RepoListActivity;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * 主界面
 * Created by caisw on 2017/10/31.
 */

public class MainActivity extends BaseActivity {
    @Inject
    @LongToast
    Toast toast;

    @Inject
    MyApplication myApplication;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        appComponent.getMainComponentBuilder()
                .build()
                .inject(this);
        toast.setText(myApplication.getAppComponent().getMyApplication().getAppComponent().getMyApplication().toString());
        toast.show();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.showButton)
    public void openRepoListActivity() {
        startActivity(new Intent(this, RepoListActivity.class));
    }
}
