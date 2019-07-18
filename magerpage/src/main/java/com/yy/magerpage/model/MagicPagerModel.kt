package com.yy.magerpage.model

import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.NavigationBarModel
import com.yy.magerpage.provider.LoadMoreAction
import com.yy.magerpage.provider.MagicAction
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Sven on 09/05/2019
 */

class MagicPagerModel {
    var bgColor: String = "#ffffff" //页面背景颜色
    var bgImage: String? = null //页面背景图片
    var desc: String? = null //页面描述

    var widgets: ArrayList<BaseWidgetModel> = ArrayList() //页面控件列表

    var refreshable: Boolean = false

    var navigationBar: NavigationBarModel? = null

    override fun toString(): String {
        return "MagicPagerModel(bgColor='$bgColor', bgImage=$bgImage, desc=$desc, widgets=$widgets, refreshable=$refreshable, navigationBar=$navigationBar)"
    }
}
