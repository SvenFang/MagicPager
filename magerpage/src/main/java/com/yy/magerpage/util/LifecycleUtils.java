package com.yy.magerpage.util;

import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;

import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

/**
 * @Date Created: 2019-08-31
 * @Author: hexiang
 * @Description: lifecycle 生命周期注册和注销监控辅助类
 */
public class LifecycleUtils {

    /**
     * 添加观察
     *
     * @param context
     * @param observer
     */
    public static void addObserver(Context context, LifecycleObserver observer) {
        if (context instanceof RxFragmentActivity) {
            RxFragmentActivity activity = (RxFragmentActivity) context;
            activity.getLifecycle().addObserver(observer);
        }
    }

    /**
     * 移除订阅
     *
     * @param context
     * @param observer
     */
    public static void removeObserver(Context context, LifecycleObserver observer) {
        if (context instanceof RxFragmentActivity) {
            RxFragmentActivity activity = (RxFragmentActivity) context;
            activity.getLifecycle().removeObserver(observer);
        }
    }
}
