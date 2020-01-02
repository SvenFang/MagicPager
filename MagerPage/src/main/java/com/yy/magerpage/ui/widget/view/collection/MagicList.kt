package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.yy.magerpage.model.modelenum.ListWidgetType
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.ListWidgetModel
import com.yy.magerpage.ui.adapter.MagicRecyclerAdapter
import com.yy.magerpage.ui.widget.view.AbstractCollectionMagic
import com.yy.magerpage.ui.widget.view.AbstractMagic


/**
 * Created by Sven on 17/05/2019
 * 列表view 支持 2列瀑布流
 */
class MagicList(context: Context) :
    AbstractCollectionMagic<ListWidgetModel, RecyclerView>(context) {


    private var magicAdapter: MagicRecyclerAdapter? = null

    override fun getContentView(): RecyclerView {
        return RecyclerView(context)
    }

    override fun analysisCollectionData(model: ListWidgetModel) {
        when (model.listType) {
            ListWidgetType.SINGLE -> {
                mContentView!!.layoutManager = LinearLayoutManager(context)
            }

            ListWidgetType.DOUBLE -> {
                mContentView!!.layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }
        }

        if (null == magicAdapter) {
            magicAdapter = MagicRecyclerAdapter()
            mContentView!!.adapter = magicAdapter
        }
        magicAdapter?.removeAllItemNoRefresh()
    }

    override fun updateItem(
        model: ListWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    ) {
        magicAdapter?.addItem(itemModel)
    }

    override fun createItem(
        model: ListWidgetModel,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>? {
        magicAdapter?.addItem(itemModel)
        return null
    }

    override fun beforeUpdateItems() {
        super.beforeUpdateItems()
        magicAdapter?.removeAllItemNoRefresh()
    }

    override fun afterUpdateItems() {
        super.afterUpdateItems()
        mContentView?.adapter?.notifyDataSetChanged()
    }
}