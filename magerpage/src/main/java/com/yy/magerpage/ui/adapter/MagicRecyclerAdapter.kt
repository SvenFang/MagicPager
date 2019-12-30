package com.yy.magerpage.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.ui.widget.holder.MagicHolder
import com.yy.magerpage.ui.widget.viewmapping.WidgetMapping
import kotlin.random.Random

/**
 * Created by Sven on 15/05/2019
 */
class MagicRecyclerAdapter : RecyclerView.Adapter<MagicHolder>() {

    private var items: ArrayList<IMagicAdapterItem> = ArrayList()

    override fun onBindViewHolder(holder: MagicHolder, position: Int) {
        holder.analysis(items[position].model)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getMagicType()
    }

    override fun onCreateViewHolder(var1: ViewGroup, type: Int): MagicHolder {
        return WidgetMapping.createHolderForType(var1)
    }


    fun addItem(item: BaseWidgetModel) {

        val typeIndex = WidgetMapping.indexForType(item.type)
        if (item.adapterTypeId == 0) {
            if (item.reuseId == 0) {
                //不重用
                item.adapterTypeId = (items.size + Random.nextInt(10000)) * 100 + typeIndex
            } else {
                //重用
                item.adapterTypeId = item.reuseId * 100 + typeIndex
            }
        }


        items.add(IMagicAdapterItem(WidgetMapping.indexForType(item.type), item))
    }

    data class IMagicAdapterItem(val type: Int, val model: BaseWidgetModel) {
        fun getMagicType(): Int {
            return model.adapterTypeId
        }
    }

    fun removeAllItem() {
        if (items.size != 0) {
            items.clear()
            notifyDataSetChanged()
        }
    }

    fun removeAllItemNoRefresh() {
        if (items.size != 0) {
            items.clear()
        }
    }
}

