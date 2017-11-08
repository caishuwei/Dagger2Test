package com.csw.gagger2test.di.module;

import android.app.Application;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.csw.gagger2test.di.annotation.qualifier.LongToast;
import com.csw.gagger2test.di.component.MainComponent;
import com.csw.gagger2test.di.component.RepoListComponent;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

/**
 * AppModule 用于提供Application实例
 * Created by caisw on 2017/10/31.
 */

@Module
public class AppModule {

    @Provides
    @Reusable
    public Toast provideToast(Application application) {
        return Toast.makeText(application, "", Toast.LENGTH_SHORT);
    }

    @Provides
    @LongToast
    @Reusable
    public Toast provideToast2(Application application) {
        return Toast.makeText(application, "", Toast.LENGTH_LONG);
    }

}
