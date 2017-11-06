package com.csw.gagger2test.function.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csw.gagger2test.ViewUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 碎片基类(视图回收，子类需要在onDestroyView之后将持有的视图引用置空，以便视图回收)
 * Created by caisw on 2017/11/6.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(getActivity()).inflate(getContentViewId(), container, false);
        unBinder = ButterKnife.bind(this, root);
        return root;
    }

    protected abstract int getContentViewId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
        getData();
    }

    protected void initView() {

    }

    protected void initListener() {

    }

    protected void getData() {

    }

    @Override
    public void onDestroyView() {
        unBinder.unbind();
        super.onDestroyView();
        ViewUtils.removeViewFromParent(getView());
    }
}
