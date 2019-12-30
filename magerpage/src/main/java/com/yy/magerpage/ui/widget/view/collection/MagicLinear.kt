package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.yy.magerpage.model.modelenum.HorizontalAlignment
import com.yy.magerpage.model.modelenum.VerticalAlignment
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.LinearWidgetModel
import com.yy.magerpage.model.widget.collection.Orientation
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.ui.widget.view.AbstractCollectionMagic
import com.yy.magerpage.ui.widget.view.AbstractMagic

/**
 * Created by Sven on 2019-10-24
 */
class MagicLinear(context: Context) :
    AbstractCollectionMagic<LinearWidgetModel, LinearLayout>(context) {
    override fun analysisCollectionData(model: LinearWidgetModel) {
        mContentView?.let {
            it.orientation = when (model.orientation) {
                Orientation.HORIZONTAL -> LinearLayout.HORIZONTAL
                Orientation.VERTICAL -> LinearLayout.VERTICAL
            }

            it.gravity = getGravity(model.horizontalAlignment, model.verticalAlignment)
        }
    }

    private fun getGravity(
        horizontalAlignment: HorizontalAlignment,
        verticalAlignment: VerticalAlignment
    ): Int {
        val horizontal = when (horizontalAlignment) {
            HorizontalAlignment.LEFT -> Gravity.START
            HorizontalAlignment.CENTER -> Gravity.CENTER_HORIZONTAL
            HorizontalAlignment.RIGHT -> Gravity.END
        }

        val vertical = when (verticalAlignment) {
            VerticalAlignment.TOP -> Gravity.TOP
            VerticalAlignment.CENTER -> Gravity.CENTER_VERTICAL
            VerticalAlignment.BOTTOM -> Gravity.BOTTOM
        }

        return vertical or horizontal
    }

    override fun updateItem(
        model: LinearWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    ) {
        itemView.analysisDetailData(itemModel)
    }

    override fun createItem(
        model: LinearWidgetModel,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>? {
        val item = MagicViewCreator.createView(itemModel, context)
        this.mContentView!!.addView(
            item,
            LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        )
        return item
    }

    override fun getContentView(): LinearLayout {
        return LinearLayout(context)
    }
}