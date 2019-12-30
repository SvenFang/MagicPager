package com.yy.magerpage.util;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

/**
 * @Date Created: 2019-09-24
 * @Author: hexiang
 * @Description: 在dectorview 上加遮罩，对话框结束去掉
 */
public class AlphaMaskBgManager implements LifecycleObserver {
    private final static String TAG = "AlphaMaskBgManager";
    private Context mContext;
    /**
     * 对话框背景遮罩层 半透明的
     */
    private FrameLayout mMaskBgView;

    public AlphaMaskBgManager(Context context) {
        mContext = context;
        LifecycleUtils.addObserver(context, this);
    }

    /**
     * 添加背景遮住
     *
     * @param res
     */
    public void addMaskBgView(@ColorRes int res) {
        if (getContext() == null) {
            return;
        }
        // if (mMaskBgView != null) {
        //     return;
        // }
        if (getContext() instanceof RxFragmentActivity) {
            RxFragmentActivity baseActivity = (RxFragmentActivity) getContext();
            if (baseActivity != null) {
                mMaskBgView = new FrameLayout(baseActivity);
                mMaskBgView.setBackground(
                        ContextCompat.getDrawable(baseActivity, res));
                ViewGroup viewGroup = (ViewGroup) baseActivity.getWindow().getDecorView();
                viewGroup.removeView(mMaskBgView);
                viewGroup.addView(mMaskBgView);
                Log.i(TAG, "addMaskBgView");
            }
        }
    }

    /**
     * 移除背景遮罩
     */
    public void removeMaskBgView() {
        if (getContext() == null) {
            return;
        }
        if (mMaskBgView != null) {
            if (getContext() instanceof RxFragmentActivity) {
                RxFragmentActivity baseActivity = (RxFragmentActivity) getContext();
                if (baseActivity != null) {
                    ViewGroup viewGroup = (ViewGroup) baseActivity.getWindow().getDecorView();
                    viewGroup.removeView(mMaskBgView);
                    Log.i(TAG, "removeMaskBgView");
                }
            }
        }
        mMaskBgView = null;
    }

    public Context getContext() {
        return mContext;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        if (getContext() != null) {
            LifecycleUtils.removeObserver(getContext(), this);
            removeMaskBgView();
            mContext = null;
            mMaskBgView = null;
        }
        Log.i(TAG, "AlphaMaskBgManager onDestroy");
    }
}
