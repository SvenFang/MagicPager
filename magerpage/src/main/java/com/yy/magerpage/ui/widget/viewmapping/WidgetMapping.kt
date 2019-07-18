package com.yy.magerpage.ui.widget.viewmapping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.ui.widget.holder.MagicHolder
import kotlin.reflect.KClass
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.*
import com.yy.magerpage.ui.widget.view.*
import com.yy.magerpage.ui.widget.view.base.*
import com.yy.magerpage.R
import com.yy.magerpage.model.widget.collection.*
import com.yy.magerpage.ui.widget.view.collection.*

/**
 * Created by Sven on 16/05/2019
 */
object WidgetMapping {

    var widgetTypeList: ArrayList<WidgetModelType> = ArrayList()


    var widgetMapping: HashMap<WidgetModelType, WidgetMappingItem> = HashMap()

    var modelClassList: ArrayList<String> = ArrayList()

    var widgetMapping1: HashMap<String, WidgetMappingItem> = HashMap()

    private fun addWidgetItem(type: WidgetModelType, item: WidgetMappingItem) {
        widgetTypeList.add(type)
        widgetMapping[type] = item
    }

    private fun addWidgetItem(
        modelClass: KClass<out BaseWidgetModel>,
        viewClass: KClass<out IMagic<BaseWidgetModel, View>>
    ) {
        modelClassList.add(modelClass.simpleName.toString())
        widgetMapping1[modelClass.simpleName.toString()] = WidgetMappingItem(modelClass, viewClass)
    }

    private fun itemForType(type: Int): WidgetMappingItem {
        return widgetMapping[widgetTypeList[type]]!!
    }

    init {
        //基础控件
        addWidgetItem(
            WidgetModelType.BLANK_TYPE,
            WidgetMappingItem(BlankWidgetModel::class, MagicBlank::class)
        )

        addWidgetItem(
            WidgetModelType.TEXT_TYPE,
            WidgetMappingItem(TextWidgetModel::class, MagicText::class)
        )
        addWidgetItem(
            WidgetModelType.IMAGE_TYPE,
            WidgetMappingItem(ImageWidgetModel::class, MagicImage::class)
        )
        addWidgetItem(
            WidgetModelType.BUTTON_TYPE,
            WidgetMappingItem(ButtonWidgetModel::class, MagicButton::class)
        )

        //容器
        addWidgetItem(
            WidgetModelType.LIST_TYPE,
            WidgetMappingItem(ListWidgetModel::class, MagicList::class)
        )

        addWidgetItem(
            WidgetModelType.CAROUSEL_TYPE,
            WidgetMappingItem(CarouselWidgetModel::class, MagicCarousel::class)
        )

        addWidgetItem(
            WidgetModelType.GRID_TYPE,
            WidgetMappingItem(GridWidgetModel::class, MagicGrid::class)
        )

        addWidgetItem(
            WidgetModelType.FLEXBOX_TYPE,
            WidgetMappingItem(FlexboxWidgetModel::class, MagicFlexboxView::class)
        )

        addWidgetItem(
            WidgetModelType.FRAME_TYPE,
            WidgetMappingItem(FrameWidgetModel::class, MagicFrame::class)
        )

        //其他
        addWidgetItem(
            WidgetModelType.NAVIGATION_TYPE,
            WidgetMappingItem(NavigationBarModel::class, MagicNavigationBar::class)
        )
    }

    fun createHolderForType(type: Int, view: ViewGroup): MagicHolder {
        return MagicHolder(LayoutInflater.from(view.context).inflate(R.layout.magic_item, view, false))
    }

    fun indexForType(type: WidgetModelType): Int {
        return widgetTypeList.indexOf(type)
    }

}


open class WidgetMappingItem(
    val modelClass: KClass<out BaseWidgetModel>,
    val viewClass: KClass<out IMagic<BaseWidgetModel, View>>
)