package com.yy.magerpage.model.widget.base

import android.app.Activity
import android.content.Context
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.R
import com.yy.magerpage.provider.MagicAction

/**
 * Created by Sven on 09/05/2019
 */
class NavigationBarModel : BaseWidgetModel() {

    init {
        type = WidgetModelType.NAVIGATION_TYPE
    }

    var left: BaseWidgetModel? = createDeafultBack()
    var right: ButtonWidgetModel? = null
    var bgImage: String? = null

    var title: TextWidgetModel? = null
    var subTitle: TextWidgetModel? = null


    private fun createDeafultBack(): ImageWidgetModel {
        val btnModel = ImageWidgetModel()
        btnModel.imgRes = R.drawable.magic_navigation_back
        btnModel.width = 40.0
        btnModel.height = 40.0
        btnModel.actionBlock = object : MagicAction {
            override fun invoke(context: Context, activity: Activity?, model: BaseWidgetModel) {
                activity?.finish()
            }

        }

        btnModel.action = "native.jsCallNative('magic','dismiss',null,null,null)"
        return btnModel
    }

    override fun toString(): String {
        return "NavigationBarModel(left=$left, right=$right, bgImage=$bgImage, title=$title, subTitle=$subTitle)"
    }


}
