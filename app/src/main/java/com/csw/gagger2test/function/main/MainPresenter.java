package com.csw.gagger2test.function.main;

import java.util.Arrays;

import javax.inject.Inject;

/**
 * Created by caisw on 2017/11/6.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    @Inject
    public MainPresenter(MainContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        requestUserList();
    }

    private void requestUserList() {
        view.updateUserList(Arrays.asList("caishuwei", "bird1015"));
    }

    @Override
    public void end() {

    }
}
