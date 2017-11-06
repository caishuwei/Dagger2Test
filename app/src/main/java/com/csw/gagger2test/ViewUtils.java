package com.csw.gagger2test;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by caisw on 2017/11/6.
 */

public class ViewUtils {

    public static void removeViewFromParent(View view) {
        if (view == null) {
            return;
        }
        ViewGroup vg = (ViewGroup) view.getParent();
        if (vg != null) {
            vg.removeView(view);
        }
    }

}
