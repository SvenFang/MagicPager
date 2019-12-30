package com.yy.magerpage.ui

import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.PopupWindow
import com.trello.rxlifecycle2.components.support.RxFragmentActivity
import com.yy.magerpage.R
import com.yy.magerpage.model.container.MagicPopupViewModel
import com.yy.magerpage.model.modelenum.GravityType
import com.yy.magerpage.util.AlphaMaskBgManager
import com.yy.magerpage.util.AnimUtils
import com.yy.magerpage.util.LengthUtil
import kotlinx.android.synthetic.main.fragment_magic.view.*

/**
 * @Date Created: 2019-10-15
 * @Author: hexiang
 * @Description:
 */
class MagicPopWindow : PopupWindow(), PopupWindow.OnDismissListener {

    lateinit var mContext: RxFragmentActivity
    private lateinit var root: View
    lateinit var model: MagicPopupViewModel
    var x: Int? = null
    var y: Int? = null
    private var gravityType: GravityType? = null
    /**
     * 对话框背景遮罩层 半透明的
     */
    private lateinit var mAlphaMaskBgManager: AlphaMaskBgManager

    companion object {

        fun newInstance(
            context: RxFragmentActivity,
            model: MagicPopupViewModel
        ): MagicPopWindow {
            val popupWindow = MagicPopWindow()
            popupWindow.mContext = context
            popupWindow.model = model
            popupWindow.initView()
            return popupWindow
        }
    }

    fun show() {
        var type = Gravity.CENTER
        this.gravityType?.let {
            when (this.gravityType) {
                GravityType.TOP -> type = Gravity.TOP
                GravityType.BOTTOM -> type = Gravity.BOTTOM
                GravityType.LEFT -> type = Gravity.START
                GravityType.RIGHT -> type = Gravity.END
                GravityType.CENTER -> type = Gravity.CENTER
            }
        }

        showAtLocation(
            mContext.window.decorView,
            type,
            this.x ?: 0,
            this.y ?: 0
        )
    }

    fun show(x: Int, y: Int) {
        showAtLocation(mContext.window.decorView, Gravity.TOP, x, y)
    }

    fun initView() {
        mAlphaMaskBgManager = AlphaMaskBgManager(mContext)
        root = View.inflate(mContext, R.layout.popwindow_dialog, null)
        this.contentView = root
        this.isTouchable = true
        this.isFocusable = true
        this.isOutsideTouchable = true
        this.setTouchInterceptor { _, event ->
            if (event.action == MotionEvent.ACTION_OUTSIDE) {
                dismiss()
                true
            } else {
                false
            }
        }
        setOnDismissListener(this)
        //背景半透明遮罩层
        mAlphaMaskBgManager.addMaskBgView(R.color.dialog_window_alpha_bg)
        root.magic_container_view?.callBack = object : MagicContainerView.MagicContainerCallBack {
            override fun onRefresh() {
                loadData()
            }
        }
        loadData()
    }

    private fun loadData() {
        initData(model)
    }

    private fun initData(model: MagicPopupViewModel) {
        root.magic_container_view?.analysis(model)
        this.width = LengthUtil.formatWithAndHeight(model.width, mContext)
        this.height = LengthUtil.formatWithAndHeight(model.height, mContext)
        this.x = LengthUtil.length2px(model.x, mContext)
        this.y = LengthUtil.length2px(model.y, mContext)

        this.gravityType = model.gravityType

        model.animStyle?.let {
            this.animationStyle = AnimUtils.formatAnimStyle(it)
        }
    }

    override fun onDismiss() {
        super.dismiss()
        mAlphaMaskBgManager.removeMaskBgView()
    }
}