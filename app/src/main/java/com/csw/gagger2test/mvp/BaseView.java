package com.csw.gagger2test.mvp;

/**
 * 视图接口
 * Created by caisw on 2017/11/6.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

}
