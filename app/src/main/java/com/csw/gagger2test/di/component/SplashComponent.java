package com.csw.gagger2test.di.component;

import com.csw.gagger2test.function.splash.SplashActivity;
import com.csw.gagger2test.function.splash.SplashContract;
import com.csw.gagger2test.function.splash.SplashModule;
import com.csw.gagger2test.function.splash.SplashPresenter;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * Created by caisw on 2017/11/6.
 */

@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {

    void inject(SplashActivity splashActivity);

    @Subcomponent.Builder
    interface Builder{

        /**
         * 注入视图到框架，用于实例化切面
         */
        @BindsInstance
        Builder setView(SplashContract.View view);

        SplashComponent build();
    }


}
