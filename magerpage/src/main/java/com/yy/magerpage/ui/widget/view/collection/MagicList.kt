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
import com.yy.magerpage.ui.widget.view.ICollectionMagic
import com.yy.magerpage.ui.widget.view.IMagic


/**
 * Created by Sven on 17/05/2019
 */
class MagicList(context: Context) :
    ICollectionMagic<ListWidgetModel, RecyclerView>(context) {


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
                mContentView!!.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }
        }

        magicAdapter = MagicRecyclerAdapter()

        mContentView!!.adapter = magicAdapter
    }

    override fun updateItem(
        model: ListWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: IMagic<BaseWidgetModel, View>
    ) {

    }

    override fun createItem(model: ListWidgetModel, itemModel: BaseWidgetModel): IMagic<BaseWidgetModel, View>? {
        magicAdapter?.addItem(itemModel)
        return null
    }

    override fun afterUpdateItems() {
        mContentView?.adapter?.notifyDataSetChanged()
    }
}