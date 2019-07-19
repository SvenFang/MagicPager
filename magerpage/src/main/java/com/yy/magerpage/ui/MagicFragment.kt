package com.yy.magerpage.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.gson.reflect.TypeToken
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.BallPulseFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.trello.rxlifecycle2.components.support.RxFragment
import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.R
import com.yy.magerpage.model.MagicPagerModel
import com.yy.magerpage.ui.adapter.MagicRecyclerAdapter
import com.yy.magerpage.model.json.MagicGson
import com.yy.magerpage.model.modelenum.WidgetModelPosition
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.provider.MagicProviderCallBack
import com.yy.magerpage.script.MagicScript
import com.yy.magerpage.ui.widget.view.MagicViewHelper
import com.yy.magerpage.util.MLog

/**
 * Created by Sven on 10/05/2019
 */
class MagicFragment : RxFragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var refreshView: SmartRefreshLayout

    private lateinit var flNav: ViewGroup

    private lateinit var bgImage: ImageView

    /**
     * 上下左右 固定层
     */
    private lateinit var topFix: ViewGroup
    private lateinit var bottomFix: ViewGroup
    private lateinit var leftFix: ViewGroup
    private lateinit var rightFix: ViewGroup

    /**
     * 上下左右 浮动层
     */
    private lateinit var topFloat: ViewGroup
    private lateinit var bottomFloat: ViewGroup
    private lateinit var leftFloat: ViewGroup
    private lateinit var rightFloat: ViewGroup

    private lateinit var rootView: View

    private var magicAdapter: MagicRecyclerAdapter = MagicRecyclerAdapter()

    private lateinit var magicScript: MagicScript

    companion object {
        @JvmStatic
        val K_MAGIC_TYPE: String = "k_magic_type"
        @JvmStatic
        val K_MAGIC_KEY: String = "k_magic_key"
        @JvmStatic
        val K_MAGIC_HEADERS: String = "k_magic_headers"
        @JvmStatic
        val K_MAGIC_PARAMS: String = "k_magic_params"

        fun startMagic(
            type: String,
            key: String,
            headers: String?,
            params: String?
        ): MagicFragment {
            val bundle = Bundle()
            bundle.putString(K_MAGIC_TYPE, type)
            bundle.putString(K_MAGIC_KEY, key)
            bundle.putString(K_MAGIC_HEADERS, headers)
            bundle.putString(K_MAGIC_PARAMS, params)

            val fragment = MagicFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_magic, container)
        magicScript = MagicScript(context)
        initView(view)

        context?.let {
            MagicPagerManager.get().addPagerScript(it, magicScript)
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        magicScript.clean()
        context?.let {
            MagicPagerManager.get().removePagerScript(it)
        }
    }

    private fun initView(view: View) {
        rootView = view
        refreshView = view.findViewById(R.id.refreshView)
        recyclerView = view.findViewById(R.id.recycleView)
        bgImage = view.findViewById(R.id.bg_magic_page)

        flNav = view.findViewById(R.id.fl_nav)
        topFix = view.findViewById(R.id.topFix)
        bottomFix = view.findViewById(R.id.bottomFix)
        leftFix = view.findViewById(R.id.leftFix)
        rightFix = view.findViewById(R.id.rightFix)

        topFloat = view.findViewById(R.id.topFloat)
        bottomFloat = view.findViewById(R.id.bottomFloat)
        leftFloat = view.findViewById(R.id.leftFloat)
        rightFloat = view.findViewById(R.id.rightFloat)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = magicAdapter

        refreshView.setRefreshHeader(ClassicsHeader(context))
        refreshView.setRefreshFooter(BallPulseFooter(context!!))

        refreshView.setOnRefreshListener {
            refresh()
        }

        refreshView.setOnLoadMoreListener {
        }
    }

    override fun onStart() {
        super.onStart()
        refresh()
    }

    var currentModel: MagicPagerModel? = null


    public fun refresh() {
        clean()
        val type = arguments?.getString(K_MAGIC_TYPE)
        val key = arguments?.getString(K_MAGIC_KEY)
        val headersStr = arguments?.getString(K_MAGIC_HEADERS)
        val paramsStr = arguments?.getString(K_MAGIC_PARAMS)

        val jsonClass = object : TypeToken<HashMap<String, Any>>() {
        }.type



        if (null != type && null != key) {
            MagicPagerManager.get().getMagic(
                type,
                key,
                MagicGson.gson.fromJson(headersStr, jsonClass),
                MagicGson.gson.fromJson(paramsStr, jsonClass),
                object : MagicProviderCallBack {
                    override fun onSuccess(resp: MagicPagerModel) {
                        analysis(resp)
                        magicAdapter.notifyDataSetChanged()
                        refreshView.finishRefresh()
                    }

                    override fun onError(error: String) {
                        //TODO 展示默认出错页面
                        refreshView.finishRefresh()
                    }

                })
        }
    }

    private fun clean() {

        flNav.removeAllViews()
        topFix.removeAllViews()
        bottomFix.removeAllViews()
        leftFix.removeAllViews()
        rightFix.removeAllViews()

        topFloat.removeAllViews()
        bottomFloat.removeAllViews()
        leftFloat.removeAllViews()
        rightFloat.removeAllViews()

        magicAdapter.removeAllItem()

        bgImage.setImageResource(0)
    }

    private fun analysis(model: MagicPagerModel) {

        refreshView.isEnableRefresh = model.refreshable
        refreshView.isEnableLoadMore = false

        currentModel = model
        layoutPage(model)

        model.navigationBar?.let {
            addWidgetToLayout(it, flNav)
        }

        for (widget in model.widgets) {
            when (widget.position) {
                WidgetModelPosition.TOP_FIX -> addWidgetToLayout(widget, topFix)
                WidgetModelPosition.BOTTOM_FIX -> addWidgetToLayout(widget, bottomFix)
                WidgetModelPosition.LEFT_FIX -> addWidgetToLayout(widget, leftFix)
                WidgetModelPosition.RIGHT_FIX -> addWidgetToLayout(widget, rightFix)

                WidgetModelPosition.TOP_FLOAT -> addWidgetToLayout(widget, topFloat)
                WidgetModelPosition.BOTTOM_FLOAT -> addWidgetToLayout(widget, bottomFloat)
                WidgetModelPosition.LEFT_FLOAT -> addWidgetToLayout(widget, leftFloat)
                WidgetModelPosition.RIGHT_FLOAT -> addWidgetToLayout(widget, rightFloat)
                else -> magicAdapter.addItem(widget)
            }
        }

        toJsonString()

    }

    private fun addWidgetToLayout(model: BaseWidgetModel, viewGroup: ViewGroup?) {
        if (null != context) {
            val view = MagicViewHelper.createView(model, context!!)
            viewGroup?.addView(view)
        }
    }

    private fun layoutPage(model: MagicPagerModel) {
        rootView.setBackgroundColor(Color.parseColor(model.bgColor))
        model.bgImage?.let {
            MagicPagerManager.get().imageProvider?.loadImage(bgImage, it)
        }
    }

    private fun toJsonString() {
        currentModel.let {
            val json = MagicGson.gson.toJson(it)
            MLog.i("Sven", "jsonStr->$json")
        }
    }

}