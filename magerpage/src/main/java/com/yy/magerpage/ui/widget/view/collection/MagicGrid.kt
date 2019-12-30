package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.GridWidgetModel
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.ui.widget.view.AbstractCollectionMagic
import com.yy.magerpage.ui.widget.view.AbstractMagic


/**
 * Created by Sven on 17/05/2019
 * 网格view
 */
class MagicGrid(context: Context) :
    AbstractCollectionMagic<GridWidgetModel, FrameLayout>(context) {

    override fun getContentView(): FrameLayout {
        return FrameLayout(context)
    }

    override fun analysisCollectionData(model: GridWidgetModel) {
    }

    override fun updateItem(
        model: GridWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    ) {
        itemView.updateModel(itemModel)
    }

    override fun createItem(
        model: GridWidgetModel,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>? {
        val perWidth = model.width * 1.00F / model.column
        val perHeight = model.height * 1.00F / model.row

        if (itemModel.width <= model.column) {
            itemModel.width = itemModel.width * perWidth
        }

        if (itemModel.height <= model.row) {
            itemModel.height = itemModel.height * perHeight
        }

        if (itemModel.x <= model.column) {
            itemModel.x = (itemModel.x * perWidth)
        }

        if (itemModel.y <= model.row) {
            itemModel.y = (itemModel.y * perHeight)
        }


        val magicItem = MagicViewCreator.createView(itemModel, context)
        this.mContentView!!.addView(magicItem)
        return magicItem
    }
}