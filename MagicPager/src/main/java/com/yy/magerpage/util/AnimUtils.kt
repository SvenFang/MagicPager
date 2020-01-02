package com.yy.magerpage.util

import com.yy.magerpage.R
import com.yy.magerpage.model.modelenum.AnimStyle

/**
 * @Date Created: 2019-10-16
 * @Author: hexiang
 * @Description: 进出动画
 */
class AnimUtils {

    companion object {
        /**
         * 转换成功动画style
         */
        fun formatAnimStyle(animStyle: AnimStyle): Int {
            return when (animStyle) {
                AnimStyle.SLIDE_TOP -> R.style.slideTopAnim
                AnimStyle.SLIDE_BOTTOM -> R.style.slideBottomAnim
                AnimStyle.SLIDE_LEFT -> R.style.slideLeftAnim
                AnimStyle.SLIDE_RIGHT -> R.style.slideRightAnim
                AnimStyle.FADE -> R.style.fadeInOutAnim
                AnimStyle.ZOOM -> R.style.zoomInOutAnim
            }
        }

        /**
         *  获取个随机的动画
         */
        fun getRandomAnimStyle(): AnimStyle {
            val num = (0..5).random()
            return AnimStyle.values()[num]
        }
    }
}