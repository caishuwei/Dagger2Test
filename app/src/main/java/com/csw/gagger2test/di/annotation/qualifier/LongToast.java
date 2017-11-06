package com.csw.gagger2test.di.annotation.qualifier;

import javax.inject.Qualifier;

/**
 * show方法调用后显示3000毫秒的长Toast注解
 * Created by caisw on 2017/11/1.
 */

@Qualifier
public @interface LongToast {
}
