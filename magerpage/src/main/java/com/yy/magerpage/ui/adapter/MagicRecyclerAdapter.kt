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

    var items: ArrayList<IMagicAdapterItem> = ArrayList()

    override fun onBindViewHolder(holder: MagicHolder, position: Int) {
        items[position].getModel()?.let { holder.analysis(it) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getMagicType()
    }

    override fun onCreateViewHolder(var1: ViewGroup, type: Int): MagicHolder {
        return WidgetMapping.createHolderForType(type % 100, var1)
    }


    fun addItem(item: BaseWidgetModel) {
        if (item.reuseId == 0) {
            //不重用
            item.reuseId = (items.size + Random.nextInt(10000)) * 100
        } else {
            //重用
            item.reuseId *= 100
        }

        items.add(IMagicAdapterItem(WidgetMapping.indexForType(item.type), item))
    }

    open class IMagicAdapterItem() {
        private var model: BaseWidgetModel? = null
        private var type: Int = 0

        constructor(type: Int, model: BaseWidgetModel?) : this() {
            this.type = type
            this.model = model
        }

        fun getModel(): BaseWidgetModel? {
            return model
        }

        fun getMagicType(): Int {
            if (null != model) {
                return type + model!!.reuseId
            }
            return type
        }
    }

    fun removeAllItem() {
        if (items.size != 0) {
            items.clear()
            notifyDataSetChanged()
        }
    }
}

