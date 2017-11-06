package com.csw.gagger2test.di.module;

import com.csw.gagger2test.http.GithubApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * GithubApiModule最终目的用于提供Service用于网络请求
 * Created by caisw on 2017/10/31.
 */
@Module
public class GithubApiModule {

    @Provides
    public GithubApiService provideGithubApiService(Retrofit retrofit) {
        return retrofit.create(GithubApiService.class);
    }

    //上面那个方法参数Retrofit也要我们自己创建
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加RxJava2回调支持
                .addConverterFactory(GsonConverterFactory.create())//添加json解析支持
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    //上面的方法还需要一个OkHttpClient
    @Provides
    public OkHttpClient provideOkHttpClient() {
        //设置网络连接，读取，发送超时都为20秒
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }

}
