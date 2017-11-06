package com.csw.gagger2test.di.component;

import android.app.Application;

import com.csw.gagger2test.app.MyApplication;
import com.csw.gagger2test.di.module.AppModule;
import com.csw.gagger2test.function.repo_list.RepoListActivity;
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

    RepoListComponent.Builder getRepoListComponentBuilder();

    MainComponent.Builder getMainComponentBuilder();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder myApplication(MyApplication application);

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
