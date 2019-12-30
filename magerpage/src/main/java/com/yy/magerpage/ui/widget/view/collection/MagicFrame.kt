package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.FrameWidgetModel
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.ui.widget.view.AbstractCollectionMagic
import com.yy.magerpage.ui.widget.view.AbstractMagic

/**
 * Created by Sven on 17/05/2019
 * 绝对布局
 */
class MagicFrame(context: Context) :
    AbstractCollectionMagic<FrameWidgetModel, FrameLayout>(context) {
    override fun analysisCollectionData(model: FrameWidgetModel) {
    }

    override fun updateItem(
        model: FrameWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    ) {
        itemView.updateModel(itemModel)
    }

    override fun createItem(
        model: FrameWidgetModel,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>? {
        val item = MagicViewCreator.createView(itemModel, context)
        this.mContentView!!.addView(item)
        return item
    }

    override fun getContentView(): FrameLayout {
        return FrameLayout(context)
    }
}