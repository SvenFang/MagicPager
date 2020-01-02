package com.yy.magerpage.model.widget.base

import android.app.Activity
import android.content.Context
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.R
import com.yy.magerpage.model.modelenum.ScaleType
import com.yy.magerpage.model.widget.MagicAction
import java.io.Serializable

/**
 * Created by Sven on 09/05/2019
 */
class NavigationBarModel : BaseWidgetModel() {

    init {
        type = WidgetModelType.NAVIGATION_TYPE.type
    }

    var left: BaseWidgetModel? = createDefaultBack()
    var right: BaseWidgetModel? = null
    var bgImage: String? = null

    var title: TextWidgetModel? = null
    var subTitle: TextWidgetModel? = null


    private fun createDefaultBack(): ImageWidgetModel {
        val btnModel = ImageWidgetModel()
        btnModel.imgRes = R.drawable.magic_navigation_back
        btnModel.width = 40.0
        btnModel.height = 40.0
        btnModel.scaleType = ScaleType.INSIDE
        btnModel.actionBlock = object : MagicAction, Serializable {
            override fun invoke(context: Context, activity: Activity?, model: BaseWidgetModel) {
                activity?.finish()
            }
        }

        btnModel.action = "native.call('magic','dismiss',null,null,null)"
        return btnModel
    }

    override fun toString(): String {
        return "NavigationBarModel(left=$left, right=$right, bgImage=$bgImage, title=$title, subTitle=$subTitle)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NavigationBarModel) return false
        if (!super.equals(other)) return false

        if (left != other.left) return false
        if (right != other.right) return false
        if (bgImage != other.bgImage) return false
        if (title != other.title) return false
        if (subTitle != other.subTitle) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        result = 31 * result + (bgImage?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (subTitle?.hashCode() ?: 0)
        return result
    }
}
