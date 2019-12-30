package com.yy.magerpage.model.container

import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.BlankWidgetModel
import com.yy.magerpage.model.widget.base.NavigationBarModel
import java.io.Serializable

/**
 * Created by Sven on 09/05/2019
 */

open class MagicPagerModel : Serializable {
    //页面导航栏
    var navigationBar: NavigationBarModel? = null
    //页面背景颜色
    var bgColor: String = "#ffffff"
    //页面内容控件
    var widget: BaseWidgetModel = BlankWidgetModel()
    //页面是否支持下拉刷新 默认false
    var refreshable: Boolean = false
    //页面描述 （仅用于json查看）
    var desc: String? = null
    //页面背景图片
    var bgImage: String? = null
}
