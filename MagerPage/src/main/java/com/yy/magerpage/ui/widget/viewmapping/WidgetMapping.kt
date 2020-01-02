package com.yy.magerpage.ui.widget.viewmapping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.ui.widget.holder.MagicHolder
import kotlin.reflect.KClass
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.BlankWidgetModel
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.model.widget.base.ButtonWidgetModel
import com.yy.magerpage.model.widget.base.TextWidgetModel
import com.yy.magerpage.model.widget.base.SvgaWidgetModel
import com.yy.magerpage.model.widget.base.NavigationBarModel
import com.yy.magerpage.ui.widget.view.AbstractMagic
import com.yy.magerpage.ui.widget.view.base.MagicBlank
import com.yy.magerpage.ui.widget.view.base.MagicText
import com.yy.magerpage.ui.widget.view.base.MagicButton
import com.yy.magerpage.ui.widget.view.base.MagicImage
import com.yy.magerpage.ui.widget.view.base.MagicNavigationBar
import com.yy.magerpage.ui.widget.view.base.MagicSvga
import com.yy.magerpage.R
import com.yy.magerpage.model.widget.collection.ListWidgetModel
import com.yy.magerpage.model.widget.collection.CarouselWidgetModel
import com.yy.magerpage.model.widget.collection.SliderWidgetModel
import com.yy.magerpage.model.widget.collection.GridWidgetModel
import com.yy.magerpage.model.widget.collection.FlexBoxWidgetModel
import com.yy.magerpage.model.widget.collection.FrameWidgetModel
import com.yy.magerpage.model.widget.collection.LinearWidgetModel
import com.yy.magerpage.ui.widget.view.collection.MagicList
import com.yy.magerpage.ui.widget.view.collection.MagicSlider
import com.yy.magerpage.ui.widget.view.collection.MagicCarousel
import com.yy.magerpage.ui.widget.view.collection.MagicLinear
import com.yy.magerpage.ui.widget.view.collection.MagicFlexbox
import com.yy.magerpage.ui.widget.view.collection.MagicGrid
import com.yy.magerpage.ui.widget.view.collection.MagicFrame

/**
 * Created by Sven on 16/05/2019
 */
object WidgetMapping {

    private var widgetTypeList: ArrayList<String> = ArrayList()
    var widgetMapping: HashMap<String, WidgetMappingItem> = HashMap()

    fun addWidgetItem(
        type: String,
        modelClass: KClass<out BaseWidgetModel>,
        viewClass: KClass<out AbstractMagic<BaseWidgetModel, View>>
    ) {
        addWidgetItem(type, WidgetMappingItem(modelClass, viewClass))
    }

    private fun addWidgetItem(type: String, item: WidgetMappingItem) {
        widgetTypeList.add(type)
        widgetMapping[type] = item
    }

    init {
        //基础控件
        addWidgetItem(
            WidgetModelType.BLANK_TYPE.type,
            BlankWidgetModel::class,
            MagicBlank::class
        )

        addWidgetItem(
            WidgetModelType.TEXT_TYPE.type,
            TextWidgetModel::class,
            MagicText::class
        )

        addWidgetItem(
            WidgetModelType.IMAGE_TYPE.type,
            ImageWidgetModel::class,
            MagicImage::class
        )

        addWidgetItem(
            WidgetModelType.BUTTON_TYPE.type,
            ButtonWidgetModel::class,
            MagicButton::class
        )

        addWidgetItem(
            WidgetModelType.SVGA_TYPE.type,
            SvgaWidgetModel::class,
            MagicSvga::class
        )

        //容器
        addWidgetItem(
            WidgetModelType.LIST_TYPE.type,
            ListWidgetModel::class,
            MagicList::class
        )

        addWidgetItem(
            WidgetModelType.CAROUSEL_TYPE.type,
            CarouselWidgetModel::class,
            MagicCarousel::class
        )

        addWidgetItem(
            WidgetModelType.GRID_TYPE.type,
            GridWidgetModel::class,
            MagicGrid::class
        )

        addWidgetItem(
            WidgetModelType.FLEXBOX_TYPE.type,
            FlexBoxWidgetModel::class,
            MagicFlexbox::class
        )

        addWidgetItem(
            WidgetModelType.FRAME_TYPE.type,
            FrameWidgetModel::class,
            MagicFrame::class
        )

        addWidgetItem(
            WidgetModelType.SLIDER_TYPE.type,
            SliderWidgetModel::class,
            MagicSlider::class
        )

        addWidgetItem(
            WidgetModelType.LINEAR_TYPE.type,
            LinearWidgetModel::class,
            MagicLinear::class
        )

        //其他
        addWidgetItem(
            WidgetModelType.NAVIGATION_TYPE.type,
            NavigationBarModel::class,
            MagicNavigationBar::class
        )
    }

    fun createHolderForType(view: ViewGroup): MagicHolder {
        return MagicHolder(
            LayoutInflater.from(view.context).inflate(
                R.layout.magic_item,
                view,
                false
            )
        )
    }

    fun indexForType(type: String): Int {
        return widgetTypeList.indexOf(type)
    }
}


open class WidgetMappingItem(
    val modelClass: KClass<out BaseWidgetModel>,
    val viewClass: KClass<out AbstractMagic<BaseWidgetModel, View>>
)