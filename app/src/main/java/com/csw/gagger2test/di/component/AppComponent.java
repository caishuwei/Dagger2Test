package com.csw.gagger2test.di.component;

import android.app.Application;

import com.csw.gagger2test.app.MyApplication;
import com.csw.gagger2test.di.module.AppModule;
import com.csw.gagger2test.di.module.GithubApiModule;

import dagger.BindsInstance;
import dagger.Component;

/**
 * App组件，包含App模块，githubApi访问模块
 * Created by caisw on 2017/10/31.
 */
@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {

    MyApplication getMyApplication();

    //提供别的Component.Builder，貌似Dagger也会把别的Component当成SubComponent,把SubComponent的实现作为内部类，然后自己的实例池SubComponent可以随意使用
    MainComponent.Builder getMainComponentBuilder();

    SplashComponent.Builder getSplashComponentBuilder();

    RepoListComponent.Builder getRepoListComponentBuilder();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder myApplication(MyApplication application);

        AppComponent build();
    }

}
