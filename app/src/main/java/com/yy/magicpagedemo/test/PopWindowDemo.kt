package com.yy.magicpagedemo.test

import com.yy.magerpage.model.container.MagicPopupViewModel
import com.yy.magerpage.model.modelenum.GravityType
import com.yy.magerpage.model.modelenum.HorizontalAlignment
import com.yy.magerpage.model.widget.Padding
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.model.widget.base.TextWidgetModel
import com.yy.magerpage.model.widget.collection.FrameWidgetModel
import com.yy.magerpage.util.AnimUtils

/**
 * Created by Sven on 13/05/2019
 */
class PopWindowDemo {

    companion object {
        @JvmStatic
        fun getTestFrame(): MagicPopupViewModel {
            val page = MagicPopupViewModel()
            //弹出在底部位置
            page.x = 10.0
            page.y = 100.0
            page.animStyle = AnimUtils.getRandomAnimStyle()
            page.gravityType = GravityType.BOTTOM
            val frame = FrameWidgetModel()
            frame.width = -1.0
            frame.height = -1.0
            frame.padding = Padding(left = 0, top = 10)

            val titles = arrayListOf(
                "抢麦接唱",
                "YJ心动派单"
            )

            val descs = arrayListOf(
                "竞技抢唱，一展歌喉",
                "领取你的小姐姐"
            )

            val imgs = arrayListOf(
                "https://mgamevoice2.bs2dl.yy.com/ac25da7fcfa341189dba119f9acb14dd.png",
                "https://mgamevoice2.bs2dl.yy.com/6ceec7697458490da42d2b986a4425db.png"
            )

            val titleColors = arrayListOf(
                "#5583F4",
                "#F95C93"
            )

            val descColors = arrayListOf(
                "#899FCB",
                "#DAA2B7"
            )

            val actions = arrayListOf(
                "native.call('gvJump','yygamevoice://GVJump/Jump/channel/join_match',null,null)",
                "native.call('gvJump','yygamevoice://gamevoice/channel/0/22269866/22269866',null,null)"
            )

            for (i in 0..1) {
                val btn = FrameWidgetModel()
                btn.x = (12 + 170 * i + 10 * i).toDouble()
                btn.y = 0.0
                btn.width = 170.0
                btn.height = -1.0

                val img = ImageWidgetModel()
                img.width = -1.0
                img.height = -1.0
                img.imgSrc = imgs[i]

                val title = TextWidgetModel()
                title.x = 12.0
                title.y = 12.0
                title.height = 25.0
                title.width = 170.0 - 24
                title.text = titles[i]
                title.textColor = titleColors[i]
                title.textSize = 18
                title.bold = true
                title.textHorizontalAlignment = HorizontalAlignment.LEFT

                val desc = TextWidgetModel()
                desc.x = 12.0
                desc.y = 41.0
                desc.height = 16.0
                desc.width = 170.0 - 30
                desc.text = descs[i]
                desc.textColor = descColors[i]
                desc.textSize = 13

                btn.items.add(img)
                btn.items.add(title)
                btn.items.add(desc)
                btn.action = actions[i]

                frame.items.add(btn)
            }

            page.widget = frame

            return page
        }

    }


}