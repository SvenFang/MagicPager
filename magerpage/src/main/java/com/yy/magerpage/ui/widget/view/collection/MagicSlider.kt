package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.SliderWidgetModel
import com.yy.magerpage.ui.adapter.MagicRecyclerAdapter
import com.yy.magerpage.ui.widget.view.AbstractCollectionMagic
import com.yy.magerpage.ui.widget.view.AbstractMagic

/**
 * Created by Sven on 2019-10-14
 * 左右滑动条
 */
class MagicSlider(context: Context) : AbstractCollectionMagic<SliderWidgetModel, RecyclerView>(context) {

    private var magicAdapter: MagicRecyclerAdapter? = null

    override fun getContentView(): RecyclerView {
        return RecyclerView(context)
    }

    override fun analysisCollectionData(model: SliderWidgetModel) {
        mContentView!!.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        magicAdapter = MagicRecyclerAdapter()
        mContentView!!.adapter = magicAdapter
    }

    override fun updateItem(
        model: SliderWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    ) {
        magicAdapter?.addItem(itemModel)
    }

    override fun createItem(
        model: SliderWidgetModel,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>? {
        magicAdapter?.addItem(itemModel)
        return null
    }

    override fun afterUpdateItems() {
        mContentView?.adapter?.notifyDataSetChanged()
    }
}