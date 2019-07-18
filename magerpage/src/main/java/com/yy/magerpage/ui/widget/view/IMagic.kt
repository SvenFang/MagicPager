package com.yy.magerpage.ui.widget.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.yy.magerpage.model.widget.BaseWidgetModel


/**
 * Created by Sven on 17/05/2019
 */
abstract class IMagic<out T : BaseWidgetModel, out V : View> : FrameLayout {
    private var mModel: @UnsafeVariance T? = null
    var mContentView: @UnsafeVariance V? = null

    constructor(context: Context) : super(context) {
        initSelf()
    }

    private constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    private fun initSelf() {
        mContentView = getContentView()
        addView(mContentView, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
    }

    fun updateModel(model: @UnsafeVariance T) {
        if (null != mContentView) {
            mModel = model
            MagicViewHelper.analysisBase(mContentView!!, model)
            analysisDetailData(model)
        }
    }

    /**
     * 返回控件对象，如是容器类控件，返回容器的父控件
     */
    abstract fun getContentView(): V

    /**
     * 继承该方法解析控件特有属性，BaseWidgetModel的属性已统一解析处理
     */
    abstract fun analysisDetailData(model: @UnsafeVariance T)
}