package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.support.v4.widget.NestedScrollView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.yy.magerpage.model.modelenum.OrientationType
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.ScrollViewWidgetModel
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.ui.widget.view.AbstractCollectionMagic
import com.yy.magerpage.ui.widget.view.AbstractMagic


/**
 * @Date Created: 2019-10-15
 * @Author: hexiang
 * @Description:
 */
class MagicScrollView(context: Context) :
    AbstractCollectionMagic<ScrollViewWidgetModel, NestedScrollView>(context) {
    private lateinit var lineView: LinearLayout
    private lateinit var scrollView: NestedScrollView

    override fun analysisCollectionData(model: ScrollViewWidgetModel) {
        when (model.orientation) {
            OrientationType.HORIZONTAL -> lineView.orientation = LinearLayout.HORIZONTAL
            OrientationType.VERTICAL -> lineView.orientation = LinearLayout.VERTICAL
        }
        scrollView.isEnabled = true
        scrollView.isSmoothScrollingEnabled = true
        scrollView.isFocusable
        scrollView.isNestedScrollingEnabled = true
    }

    override fun updateItem(
        model: ScrollViewWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    ) {
        itemView.updateModel(itemModel)
    }

    override fun createItem(
        model: ScrollViewWidgetModel,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>? {
        val item = MagicViewCreator.createView(itemModel, context)
        this.lineView.addView(item)
        return item
    }

    override fun getContentView(): NestedScrollView {
        scrollView = NestedScrollView(context)
        lineView = LinearLayout(context)
        lineView.orientation = LinearLayout.VERTICAL
        scrollView.addView(
            lineView,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        return scrollView
    }
}