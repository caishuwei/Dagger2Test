package com.csw.gagger2test.function.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.csw.gagger2test.R;

/**
 * 通用的单个碎片界面显示基类<br/>
 * 如果一个界面只需要显示一个Fragment，可以用这个实现，如果需要多个Fragment切换，那还是自己写Activity
 * <p>
 * Created by caisw on 2017/11/6.
 */
public class FragmentOpenActivity extends BaseActivity {

    public static void openActivity(Context context, Class<? extends Fragment> clazz, Bundle data) {
        if (context == null || clazz == null) {
            return;
        }
        Intent intent = new Intent(context, FragmentOpenActivity.class);
        intent.putExtra("fragmentClass", clazz);
        if (data != null) {
            intent.putExtra("data", data);
        }
        context.startActivity(intent);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_fragment_open;
    }

    @Override
    protected void getData() {
        super.getData();
        //取得数据并检查
        Class clazz = (Class) getIntent().getSerializableExtra("fragmentClass");
        Bundle data = getIntent().getBundleExtra("data");
        if (clazz == null) {
            finish();
            return;
        }
        if (setFragment(getSupportFragmentManager(), R.id.fl_fragment_container, clazz, clazz.getName(), data) == null) {
            finish();
        }
    }

    /**
     * 设置fragment到容器中
     *
     * @param fm            碎片管理器
     * @param containerId   容器id
     * @param fragmentClass 碎片类型
     * @param tag           碎片标识
     * @param data          初始化数据
     * @return fragment
     */
    public static Fragment setFragment(FragmentManager fm, int containerId, Class fragmentClass, String tag, Bundle data) {
        Fragment fragment = fm.findFragmentByTag(tag);
        try {
            if (fragment == null) {
                Object o = fragmentClass.newInstance();
                if (o instanceof Fragment) {
                    fragment = (Fragment) o;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            if (fragment.isAdded()) {
                if (fragment.isDetached()) {
                    fragmentTransaction.attach(fragment);
                }
            } else {
                if (data != null) {
                    fragment.setArguments(data);
                }
                fragmentTransaction.add(containerId, fragment, tag);
            }
            fragmentTransaction.commitAllowingStateLoss();
        }
        return fragment;
    }
}
