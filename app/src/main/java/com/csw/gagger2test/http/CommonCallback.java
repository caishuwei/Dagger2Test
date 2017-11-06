package com.csw.gagger2test.http;

import android.net.ParseException;
import android.widget.Toast;

import com.csw.gagger2test.app.MyApplication;
import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 通用回调
 * Created by caisw on 2017/10/31.
 */

public abstract class CommonCallback<T> implements Observer<T> {
    private Disposable disposable;

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(@NonNull T t) {
        onSucceed(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (e instanceof SocketTimeoutException) {
            showToast("连接超时");
        } else if (e instanceof ConnectException) {
            showToast("网络连接错误");
        } else if (e instanceof JsonSyntaxException) {
            showToast("数据无法解析");
        } else {
            showToast("请求失败");
        }
        onFailed(e);
    }


    private void showToast(String msg) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSucceed(T t);


    public void onFailed(Throwable e) {

    }

    public void execute(Observable<T> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

}
