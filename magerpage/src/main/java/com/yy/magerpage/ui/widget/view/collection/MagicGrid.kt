package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.GridWidgetModel
import com.yy.magerpage.model.widget.collection.ListWidgetModel
import com.yy.magerpage.ui.widget.view.ICollectionMagic
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.ui.widget.view.MagicViewHelper
import kotlin.math.roundToInt

/**
 * Created by Sven on 17/05/2019
 */
class MagicGrid(context: Context) :
    ICollectionMagic<GridWidgetModel, FrameLayout>(context) {

    override fun getContentView(): FrameLayout {
        return FrameLayout(context)
    }

    override fun analysisCollectionData(model: GridWidgetModel) {
        val perWidth = model.width * 1.00F / model.column
        val perHeight = model.height * 1.00F / model.row

        for (item in model.items) {

            if (item.width <= model.column) {
                item.width = item.width * perWidth
            }

            if (item.height <= model.row) {
                item.height = item.height * perWidth
            }

            item.x = (item.x * perWidth).roundToInt()
            item.y = (item.y * perHeight).roundToInt()
        }
    }

    override fun updateItem(
        model: GridWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: IMagic<BaseWidgetModel, View>
    ) {
        itemView.updateModel(itemModel)
    }

    override fun createItem(model: GridWidgetModel, itemModel: BaseWidgetModel): IMagic<BaseWidgetModel, View>? {
        val magicItem = MagicViewHelper.createView(itemModel, context)
        this.mContentView!!.addView(magicItem)
        return magicItem
    }
}