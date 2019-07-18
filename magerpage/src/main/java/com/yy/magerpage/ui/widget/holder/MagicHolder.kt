package com.yy.magerpage.ui.widget.holder

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.R
import com.yy.magerpage.ui.widget.view.MagicViewHelper

/**
 * Created by Sven on 16/05/2019
 */
class MagicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentView: ViewGroup = itemView.findViewById(R.id.view_magic_content)
    private var magic: IMagic<BaseWidgetModel, View>? = null

    fun analysis(model: BaseWidgetModel) {
        try {
            if (null == magic) {
                val magicView = MagicViewHelper.createView(model, contentView.context)
                if (magicView is View) {
                    contentView.addView(magicView)
                    this.magic = magicView
                }
                Log.i("Sven", "new view")
            } else {
                this.magic?.updateModel(model)
                Log.i("Sven", "old view")
            }

        } catch (e: Exception) {
            Log.e("Sven", "e->", e)
        }
    }

}