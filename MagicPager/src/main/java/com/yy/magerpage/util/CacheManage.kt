package com.yy.magerpage.util

import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity
import java.util.WeakHashMap


/**
 * @Date Created: 2019-10-15
 * @Author: hexiang
 * @Description: 缓存popwindow，和dialog
 */
class CacheManage {
    companion object {
        private var weakHashMapDialog: WeakHashMap<FragmentActivity, DialogFragment> =
            WeakHashMap()

        fun addCacheDialog(fragmentActivity: FragmentActivity, dialogFragment: DialogFragment) {
            weakHashMapDialog[fragmentActivity] = dialogFragment
        }

        fun removeCacheDialog(fragmentActivity: FragmentActivity) {
            weakHashMapDialog.remove(fragmentActivity)
        }

        fun getCacheDialog(fragmentActivity: FragmentActivity): DialogFragment? {
            return weakHashMapDialog[fragmentActivity]
        }
    }
}