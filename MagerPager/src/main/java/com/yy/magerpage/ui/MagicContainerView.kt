package com.yy.magerpage.ui

import android.content.Context

import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.yy.magerpage.R
import com.yy.magerpage.model.container.MagicPagerModel
import com.yy.magerpage.model.json.MagicGson
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.util.ColorUtil
import com.yy.magerpage.util.MLog

/**
 * Created by Sven on 2019-10-15
 */
class MagicContainerView(context: Context?, attrs: AttributeSet?) :
    RelativeLayout(context, attrs) {

    private lateinit var containerView: FrameLayout

    private lateinit var flNav: ViewGroup

    var callBack: MagicContainerCallBack? = null

    constructor(context: Context?) : this(context, null)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_magic_container, this, true)
        initView()
    }

    private fun initView() {
        containerView = findViewById(R.id.containerView)

        flNav = findViewById(R.id.fl_nav)
    }

    private var currentModel: MagicPagerModel? = null


    private fun refresh() {
        if (null != callBack) {
            callBack?.onRefresh()
        }
    }

    private fun clean() {
        flNav.removeAllViews()
        containerView.removeAllViews()
    }

    fun analysis(model: MagicPagerModel) {

        toJsonString(model)
        //先清空
        clean()

        currentModel = model
        layoutPage(model)

        model.navigationBar?.let {
            addWidgetToLayout(it, flNav)
        }

        val magicView = MagicViewCreator.createView(model.widget, context)

        containerView.addView(
            magicView,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )
    }

    private fun addWidgetToLayout(model: BaseWidgetModel, viewGroup: ViewGroup?) {
        if (null != context) {
            val view = MagicViewCreator.createView(model, context!!)
            viewGroup?.addView(view)

            if (viewGroup?.visibility == View.GONE) {
                viewGroup.visibility = View.VISIBLE
            }
        }
    }

    private fun layoutPage(model: MagicPagerModel) {
        rootView.setBackgroundColor(ColorUtil.parseColor(model.bgColor))
    }

    private fun toJsonString(model: MagicPagerModel) {
        val json = MagicGson.gson.toJson(model)
        MLog.i(MagicFragment.TAG, "jsonStr->$json")
    }

    interface MagicContainerCallBack {
        fun onRefresh()
    }
}