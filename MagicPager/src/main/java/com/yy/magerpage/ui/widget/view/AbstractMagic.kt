package com.yy.magerpage.ui.widget.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.script.MagicScript
import com.yy.magerpage.script.MagicScriptManager


/**
 * Created by Sven on 17/05/2019
 */
abstract class AbstractMagic<out T : BaseWidgetModel, out V : View> : FrameLayout {
    var mModel: @UnsafeVariance T? = null
    var mContentView: @UnsafeVariance V? = null

    private lateinit var magicScript: MagicScript

    constructor(context: Context) : super(context) {
        initSelf()
    }

    private constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun initSelf() {
        mContentView = getContentView()
        addView(mContentView, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
    }

    fun updateModel(model: @UnsafeVariance T) {
        if (model == mModel) {
            refreshItems()
            return
        }
        mModel = model

        this.layoutParams?.let {
            val width = if (model.width == BaseWidgetModel.MATCH_PARENT) {
                BaseWidgetModel.MATCH_PARENT
            } else {
                BaseWidgetModel.WRAP_CONTENT
            }

            val height = if (model.height == BaseWidgetModel.MATCH_PARENT) {
                BaseWidgetModel.MATCH_PARENT
            } else {
                BaseWidgetModel.WRAP_CONTENT
            }

            it.width = width.toInt()
            it.height = height.toInt()
            this.layoutParams = it
        }

        mContentView?.let {
            MagicViewHelper.analysisBase(it, model)
            analysisDetailData(model)
        }
    }

    protected open fun refreshItems() {
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        MagicScriptManager.get().exit(context)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        MagicScriptManager.get().enter(context)
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