package com.yy.magerpage.ui.widget.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 2019-07-17
 */
abstract class AbstractCollectionMagic<out T : BaseCollectionWidgetModel, out V : ViewGroup>(context: Context) :
    AbstractMagic<T, V>(context) {

    val items: ArrayList<AbstractMagic<BaseWidgetModel, View>> = ArrayList()

    override fun analysisDetailData(model: @UnsafeVariance T) {
        analysisCollectionData(model)
        refreshItems()
    }

    override fun refreshItems() {
        mModel?.let { model ->
            beforeUpdateItems()
            if (items.size == model.items.size) {
                items.forEach {
                    val index = items.indexOf(it)
                    updateItem(model, model.items[index], items[index])
                }
            } else {
                items.forEach {
                    this.mContentView?.removeView(it)
                }
                items.clear()

                model.items.forEach {
                    createItem(model, it)?.let { v ->
                        items.add(v)
                    }
                }
            }
            afterUpdateItems()
        }
    }

    abstract fun analysisCollectionData(model: @UnsafeVariance T)

    /**
     * 用于重用itemView时 刷新数据
     */
    abstract fun updateItem(
        model: @UnsafeVariance T,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    )

    /**
     * 根据itemModel创建子试图，如容器内使用adapter实现，则返回null
     */
    abstract fun createItem(
        model: @UnsafeVariance T,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>?


    /**
     * 更新items前调用方法，用于刷新列表之类
     */
    open fun beforeUpdateItems() {
    }

    /**
     * 更新完items之后调用方法，用于处理刷新列表之类事宜
     */
    open fun afterUpdateItems() {
    }
}