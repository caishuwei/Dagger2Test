package com.csw.gagger2test.di.module;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.csw.gagger2test.app.MyApplication;
import com.csw.gagger2test.di.annotation.qualifier.App;
import com.csw.gagger2test.di.annotation.qualifier.LongToast;

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
    public Application provide(MyApplication myApplication) {
        return myApplication;
    }

    /**
     * 加App注解用于区分与Activity Service等Context
     */
    @Provides
    @App
    public Context provideAppContext(Application application) {
        return application;
    }


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
