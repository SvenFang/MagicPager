package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.view.View
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.JustifyContent
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.FlexBoxWidgetModel
import com.yy.magerpage.model.widget.collection.MFlexDirection
import com.yy.magerpage.model.widget.collection.MJustifyContent
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.ui.widget.view.AbstractCollectionMagic
import com.yy.magerpage.ui.widget.view.AbstractMagic

/**
 * Created by Sven on 17/05/2019
 * 流式布局
 */
class MagicFlexbox(context: Context) :
    AbstractCollectionMagic<FlexBoxWidgetModel, FlexboxLayout>(context) {
    override fun analysisCollectionData(model: FlexBoxWidgetModel) {
        mContentView?.let {
            it.flexDirection = flexDirection(model.flexDirection)
            it.flexWrap = FlexWrap.WRAP
            it.justifyContent = justifyContent(model.justifyContent)
        }
    }

    override fun updateItem(
        model: FlexBoxWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    ) {
        itemView.updateModel(itemModel)
    }

    override fun createItem(
        model: FlexBoxWidgetModel,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>? {
        val magicItem = MagicViewCreator.createView(itemModel, context)
        this.mContentView!!.addView(magicItem)
        return magicItem
    }

    override fun getContentView(): FlexboxLayout {
        return FlexboxLayout(context)
    }

    private fun flexDirection(value: MFlexDirection): Int {
        return when (value) {
            MFlexDirection.ROW -> FlexDirection.ROW
            MFlexDirection.COLUMN -> FlexDirection.COLUMN
            MFlexDirection.ROW_REVERSE -> FlexDirection.ROW_REVERSE
            MFlexDirection.COLUMN_REVERSE -> FlexDirection.COLUMN_REVERSE
        }
    }

    private fun justifyContent(value: MJustifyContent): Int {
        return when (value) {
            MJustifyContent.FLEX_START -> JustifyContent.FLEX_START
            MJustifyContent.FLEX_END -> JustifyContent.FLEX_END
            MJustifyContent.CENTER -> JustifyContent.CENTER
        }
    }
}