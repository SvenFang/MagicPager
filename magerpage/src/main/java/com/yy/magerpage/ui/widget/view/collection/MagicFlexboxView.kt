package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.view.View
import com.google.android.flexbox.*
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.*
import com.yy.magerpage.ui.widget.view.ICollectionMagic
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.ui.widget.view.MagicViewHelper

/**
 * Created by Sven on 17/05/2019
 */
class MagicFlexboxView(context: Context) :
    ICollectionMagic<FlexboxWidgetModel, FlexboxLayout>(context) {
    override fun analysisCollectionData(model: FlexboxWidgetModel) {
        mContentView?.let {
            it.flexDirection = flexDirection(model.flexDirection)
            it.flexWrap = flexWrap(model.flexWrap)
            it.justifyContent = justifyContent(model.justifyContent)
            it.alignItems = alignItems(model.alignItems)
            it.alignContent = alignContent(model.alignContent)
        }
    }

    override fun updateItem(
        model: FlexboxWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: IMagic<BaseWidgetModel, View>
    ) {
        itemView.updateModel(itemModel)
    }

    override fun createItem(model: FlexboxWidgetModel, itemModel: BaseWidgetModel): IMagic<BaseWidgetModel, View>? {
        val magicItem = MagicViewHelper.createView(itemModel, context)
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

    private fun flexWrap(value: MFlexWrap): Int {
        return when (value) {
            MFlexWrap.NOWRAP -> FlexWrap.NOWRAP
            MFlexWrap.WRAP -> FlexWrap.WRAP
            MFlexWrap.WRAP_REVERSE -> FlexWrap.WRAP_REVERSE
        }
    }

    private fun justifyContent(value: MJustifyContent): Int {
        return when (value) {
            MJustifyContent.FLEX_START -> JustifyContent.FLEX_START
            MJustifyContent.FLEX_END -> JustifyContent.FLEX_END
            MJustifyContent.CENTER -> JustifyContent.CENTER
            MJustifyContent.SPACE_AROUND -> JustifyContent.SPACE_AROUND
            MJustifyContent.SPACE_BETWEEN -> JustifyContent.SPACE_BETWEEN
        }
    }

    private fun alignItems(value: MAlignItems): Int {
        return when (value) {
            MAlignItems.FLEX_START -> AlignItems.FLEX_START
            MAlignItems.FLEX_END -> AlignItems.FLEX_END
            MAlignItems.BASELINE -> AlignItems.BASELINE
            MAlignItems.CENTER -> AlignItems.CENTER
            MAlignItems.STRETCH -> AlignItems.STRETCH
        }
    }

    private fun alignContent(value: MAlignContent): Int {
        return when (value) {
            MAlignContent.FLEX_START -> AlignContent.FLEX_END
            MAlignContent.FLEX_END -> AlignContent.FLEX_END
            MAlignContent.CENTER -> AlignContent.CENTER
            MAlignContent.SPACE_AROUND -> AlignContent.SPACE_AROUND
            MAlignContent.SPACE_BETWEEN -> AlignContent.SPACE_BETWEEN
            MAlignContent.STRETCH -> AlignContent.STRETCH
        }
    }


}