package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.FrameWidgetModel
import com.yy.magerpage.model.widget.collection.GridWidgetModel
import com.yy.magerpage.model.widget.collection.ListWidgetModel
import com.yy.magerpage.ui.widget.view.ICollectionMagic
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.ui.widget.view.MagicViewHelper
import kotlin.math.roundToInt

/**
 * Created by Sven on 17/05/2019
 */
class MagicFrame(context: Context) :
    ICollectionMagic<FrameWidgetModel, FrameLayout>(context) {
    override fun analysisCollectionData(model: FrameWidgetModel) {
    }

    override fun updateItem(
        model: FrameWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: IMagic<BaseWidgetModel, View>
    ) {
        itemView.updateModel(itemModel)
    }

    override fun createItem(model: FrameWidgetModel, itemModel: BaseWidgetModel): IMagic<BaseWidgetModel, View>? {
        val item = MagicViewHelper.createView(itemModel, context)
        this.mContentView!!.addView(item)
        return item
    }

    override fun getContentView(): FrameLayout {
        return FrameLayout(context)
    }
}