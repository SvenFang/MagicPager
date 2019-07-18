package com.yy.magicpagedemo.test

import com.yy.magerpage.model.MagicPagerModel
import com.yy.magerpage.model.modelenum.HorizontalAlignemt
import com.yy.magerpage.model.modelenum.ScaleType
import com.yy.magerpage.model.modelenum.VerticalAlignemt
import com.yy.magerpage.model.modelenum.WidgetModelPosition
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.model.widget.base.NavigationBarModel
import com.yy.magerpage.model.widget.base.TextWidgetModel
import com.yy.magerpage.model.widget.collection.FrameWidgetModel

/**
 * Created by Sven on 2019-07-03
 */
class TestAd {
    companion object {
        @JvmStatic
        fun getTestModel(): MagicPagerModel {
            val page = MagicPagerModel()
            page.bgColor = "#ffffff"
            page.widgets = getWidgets()
            page.refreshable = true
            page.navigationBar = getNavigation()
            return page
        }

        private fun getWidgets(): ArrayList<BaseWidgetModel> {
            val widgets = ArrayList<BaseWidgetModel>()
            var frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 170.0
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_735aeba48ce743a09a8119533f25fe40.jpeg"
                )
            )
            widgets.add(frame)

            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 209.0
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_aad87a68b56d4587b478d66df96ba0db.jpeg"
                )
            )

            frame.items.add(
                getImageModel(
                    41,
                    -20,
                    292.5,
                    292.5,
                    "https://vipweb.bs2cdn.yy.com/vipinter_f2ed0f9153a54ac7adf221ef56aafed8.png"
                )
            )

            frame.items.add(
                getTextModel(
                    0, 10,
                    375.0,
                    160.0,
                    "四大皇葡任性王\n" +
                            "最低只需10金币!\n" +
                            "游艇.跑车咂意抽,全凭好手气! \n" +
                            "四重神奇惊喜.花样礼物啦心王!",
                    14,
                    4,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.CENTER,
                    true
                )
            )

            frame.items.add(
                getImageModel(
                    40,
                    145,
                    65.0,
                    65.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_dfb6466d1024449a86e984ff7a2ed1e3.png"
                )
            )

            frame.items.add(
                getImageModel(
                    155,
                    145,
                    65.0,
                    65.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_1cc50139543f495b9864bfbb6d171b0a.png"
                )
            )

            frame.items.add(
                getImageModel(
                    270,
                    145,
                    65.0,
                    65.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_ddde83e6f8184f17839a952fe6f55959.png"
                )
            )
            widgets.add(frame)

            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 75.0
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_6f00fbaca90a46dc8451725129f9be3d.jpeg"
                )
            )

            frame.items.add(
                getImageModel(
                    40,
                    20,
                    277.5,
                    37.5,
                    "https://vipweb.bs2cdn.yy.com/vipinter_cbb179ad8b84423782fdbe2924cf4dd2.png"
                )
            )

            var italic = getTextModel(
                55,
                20,
                277.5,
                37.5,
                "第一重   超低价送大惊喜！",
                18,
                1,
                "#ffffff",
                VerticalAlignemt.CENTER,
                HorizontalAlignemt.LEFT,
                true
            )

            italic.italic = true

            frame.items.add(
                italic
            )

            widgets.add(frame)

            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 249.0
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_939738b319664dbd94d3989529c9a036.jpeg"
                )
            )

            val bg1 = FrameWidgetModel()
            bg1.x = 10
            bg1.y = 0
            bg1.width = frame.width - 20
            bg1.height = frame.height - 10
            bg1.bgColor = "#40000000"
            bg1.corner = 10
            frame.items.add(bg1)

            bg1.items.add(
                getImageModel(
                    110,
                    25,
                    155.0,
                    155.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_dfb6466d1024449a86e984ff7a2ed1e3.png"
                )
            )

            bg1.items.add(
                getImageModel(
                    150,
                    185,
                    16.0,
                    16.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_44bfd299e30f48a3be36dd5cb55d68d9.png"
                )
            )

            bg1.items.add(
                getTextModel(
                    171,
                    182,
                    100.0,
                    18.0,
                    "X10",
                    16,
                    1,
                    "#e9f228",
                    VerticalAlignemt.TOP,
                    HorizontalAlignemt.LEFT,
                    false
                )
            )

            bg1.items.add(
                getTextModel(
                    0,
                    210,
                    bg1.width,
                    18.0,
                    "只需10金币开宝箱,最高可抽出钻戒礼物!",
                    15,
                    1,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.CENTER,
                    false
                )
            )

            widgets.add(frame)

            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 67.0
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_97b6f36c5860440f8122f1930ecdaed2.jpeg"
                )
            )

            frame.items.add(
                getImageModel(
                    40,
                    20,
                    277.5,
                    37.5,
                    "https://vipweb.bs2cdn.yy.com/vipinter_cbb179ad8b84423782fdbe2924cf4dd2.png"
                )
            )

            italic = getTextModel(
                55,
                20,
                277.5,
                37.5,
                "第二重   五大类型礼物随心送",
                18,
                1,
                "#ffffff",
                VerticalAlignemt.CENTER,
                HorizontalAlignemt.LEFT,
                true
            )
            italic.italic = true

            frame.items.add(
                italic
            )

            widgets.add(frame)


            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 384.0
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_84b1cfeee7284029aed7147337a24bda.jpeg"
                )
            )

            val bg2 = FrameWidgetModel()
            bg2.x = 10
            bg2.y = 0
            bg2.width = frame.width - 20
            bg2.height = frame.height - 10
            bg2.bgColor = "#40000000"
            bg2.corner = 10
            frame.items.add(bg2)

            bg2.items.add(
                getImageModel(
                    110,
                    25,
                    155.0,
                    155.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_1cc50139543f495b9864bfbb6d171b0a.png"
                )
            )
            //--
            bg2.items.add(
                getImageModel(
                    15,
                    180,
                    317.0,
                    30.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_7d291a224044438c9497f01fabe18ba4.png"
                )
            )

            bg2.items.add(
                getImageModel(
                    15,
                    210,
                    317.0,
                    30.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_46a20ec421ea42a993fe60530e856355.png"
                )
            )

            bg2.items.add(
                getImageModel(
                    15,
                    240,
                    317.0,
                    30.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_bae3b4d3d0be4b609485ce1572f92738.png"
                )
            )

            bg2.items.add(
                getImageModel(
                    15,
                    270,
                    317.0,
                    30.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_ec281daff20a4154a18ec70aa2b67f90.png"
                )
            )

            bg2.items.add(
                getImageModel(
                    15,
                    300,
                    317.0,
                    30.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_08dd4322d46c4f899578b02a3e26693b.png"
                )
            )

            bg2.items.add(
                getTextModel(
                    25,
                    180,
                    317.0,
                    30.0,
                    "初级礼物：荔枝、鸡腿",
                    15,
                    1,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.LEFT,
                    false
                )
            )

            bg2.items.add(
                getTextModel(
                    25,
                    210,
                    317.0,
                    30.0,
                    "中级礼物：么么哒、巧克力、甜甜圈",
                    15,
                    1,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.LEFT,
                    false
                )
            )

            bg2.items.add(
                getTextModel(
                    25,
                    240,
                    317.0,
                    30.0,
                    "高级礼物：游戏机、壁咚、风铃、钻戒",
                    15,
                    1,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.LEFT,
                    false
                )
            )

            bg2.items.add(
                getTextModel(
                    25,
                    270,
                    317.0,
                    30.0,
                    "超级礼物：糖果屋、游艇、情人岛",
                    15,
                    1,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.LEFT,
                    false
                )
            )

            bg2.items.add(
                getTextModel(
                    25,
                    300,
                    317.0,
                    30.0,
                    "终极礼物：荔枝星球、神之王冠",
                    15,
                    1,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.LEFT,
                    false
                )
            )

            bg2.items.add(
                getTextModel(
                    25,
                    340,
                    317.0,
                    30.0,
                    "也有可能开出空箱子喔，挑战你的心脏！",
                    15,
                    1,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.LEFT,
                    true
                )
            )

            widgets.add(frame)


            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 72.5
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_009a7d51654346fc91fd8c28d0898e10.jpeg"
                )
            )

            frame.items.add(
                getImageModel(
                    40,
                    20,
                    277.5,
                    37.5,
                    "https://vipweb.bs2cdn.yy.com/vipinter_cbb179ad8b84423782fdbe2924cf4dd2.png"
                )
            )

            italic = getTextModel(
                55,
                20,
                277.5,
                37.5,
                "第三重   超高概率赠送豪礼！",
                18,
                1,
                "#ffffff",
                VerticalAlignemt.CENTER,
                HorizontalAlignemt.LEFT,
                true
            )
            italic.italic = true

            frame.items.add(
                italic
            )

            widgets.add(frame)

            //---------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 519.5
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_ddba842f96044ef3b649b4427f788708.jpeg"
                )
            )

            val bg3 = FrameWidgetModel()
            bg3.x = 10
            bg3.y = 0
            bg3.width = frame.width - 20
            bg3.height = frame.height
            bg3.bgColor = "#40000000"
            bg3.corner = 10
            frame.items.add(bg3)

            bg3.items.add(
                getImageModel(
                    110,
                    25,
                    155.0,
                    155.0,
                    "https://vipweb.bs2cdn.yy.com/vipinter_ddde83e6f8184f17839a952fe6f55959.png"
                )
            )

            bg3.items.add(
                getTextModel(
                    0,
                    180,
                    bg3.width,
                    18.0,
                    "购买说明",
                    15,
                    1,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.CENTER,
                    false
                )
            )

            bg3.items.add(
                getTextModel(
                    16,
                    205,
                    bg3.width - 32,
                    bg3.height - 220,
                    "1、神奇宝箱礼物一次只可赠送一个\n" +
                            "2、用户送出神奇宝箱开出的礼物，可收到的收益与正常礼物一致\n" +
                            "3、每购买一个宝箱，获等值商城蓝钻现金券\n" +
                            "4、未成年用户参与宝箱赠送玩法，须得到家长或其他监护人的同意。手游语音APP对未成年用户使用服务过程中的行为，及因其使用本服务而产生的一切后果不承担任何责任。\n" +
                            "5、当用户进入宝箱玩法并使用蓝钻一经点击赠送宝箱给主播成功后，宝箱赠送虚拟礼物即确定完成；手游语音APP不提供任何更改、修改、撤销服务。用户不得要求APP、主播退还消费的蓝钻及虚拟礼物。\n" +
                            "6、如果不同意APP对本协议相关条款，用户有权并应当停止使用。如果用户继续使用，则视为用户接受APP对本协议相关条款所做的修改与规定。",

                    13,
                    100,
                    "#ffffff",
                    VerticalAlignemt.TOP,
                    HorizontalAlignemt.LEFT,
                    false
                )
            )
            widgets.add(frame)

            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 94.5
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_480114e6a35e4e098e7da48a675bd5b3.jpeg"
                )
            )

            frame.items.add(
                getImageModel(
                    40,
                    30,
                    277.5,
                    37.5,
                    "https://vipweb.bs2cdn.yy.com/vipinter_cbb179ad8b84423782fdbe2924cf4dd2.png"
                )
            )

            italic = getTextModel(
                55,
                30,
                277.5,
                37.5,
                "第四重   在世界中心表达爱！",
                20,
                1,
                "#ffffff",
                VerticalAlignemt.CENTER,
                HorizontalAlignemt.LEFT,
                true
            )

            italic.italic = true

            frame.items.add(
                italic
            )

            widgets.add(frame)


            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 186.0
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_e7758ec6c94f471dbeb815999223ba23.jpeg"
                )
            )

            val cellW = (frame.width - 20 - 6) / 3

            val imgs = arrayListOf(
                "https://vipweb.bs2cdn.yy.com/vipinter_dfb6466d1024449a86e984ff7a2ed1e3.png",
                "https://vipweb.bs2cdn.yy.com/vipinter_1cc50139543f495b9864bfbb6d171b0a.png",
                "https://vipweb.bs2cdn.yy.com/vipinter_ddde83e6f8184f17839a952fe6f55959.png"
            )

            val titles = arrayListOf(
                "神奇宝箱",
                "高级神奇宝箱",
                "史诗神奇宝箱"
            )

            val contexts = arrayListOf(
                "空（10.00%）\n初级礼物(60.00%)\n中级礼物(20.00%)\n高级礼物(10.00%)",
                "空（10.00%）\n" +
                        "初级礼物(60.00%)\n" +
                        "中级礼物(20.00%)\n" +
                        "高级礼物(10.00%)\n" +
                        "超级礼物(10.00%)",
                "空（10.00%）\n" +
                        "初级礼物(60.00%)\n" +
                        "中级礼物(20.00%)\n" +
                        "高级礼物(10.00%)\n" +
                        "超级礼物(10.00%)"
            )

            for (i in 0..2) {
                val bg = FrameWidgetModel()
                bg.x = (10 + (cellW + 3) * i).toInt()
                bg.y = 0
                bg.width = cellW
                bg.height = frame.height
                bg.bgColor = "#40000000"
                bg.corner = 5
                frame.items.add(bg)

                bg.items.add(
                    getImageModel(
                        ((cellW - 60) / 2).toInt(),
                        10,
                        60.0,
                        60.0,
                        imgs[i]
                    )
                )


                bg.items.add(
                    getTextModel(
                        0,
                        75,
                        cellW,
                        18.0,
                        titles[i],
                        13,
                        1,
                        "#ffffff",
                        VerticalAlignemt.CENTER,
                        HorizontalAlignemt.CENTER,
                        true
                    )
                )

                bg.items.add(
                    getTextModel(
                        8,
                        97,
                        cellW - 16,
                        frame.height - 93,
                        contexts[i],
                        11,
                        5,
                        "#ffffff",
                        VerticalAlignemt.TOP,
                        HorizontalAlignemt.LEFT,
                        false
                    )
                )
                bg.action =
                    "native.jsCallNative('magic','showPager',null,'{\"key\":\"test_ad\",\"type\":\"test\", \"headers\":{\"head1\":\"1\",\"head2\":\"1\"},\"params\":{\"params1\":\"1\",\"params2\":\"1\"}}',null)"
            }
            widgets.add(frame)

            //----------------------------------------
            frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 164.5
            frame.items.add(
                getImageModel(
                    frame.width,
                    frame.height,
                    "https://vipweb.bs2cdn.yy.com/vipinter_7c43caeb3cec4485ac16300bbdbbce9a.jpeg"
                )
            )

            frame.items.add(
                getTextModel(
                    0,
                    15,
                    frame.width,
                    69.0,
                    "宝箱一开，惊喜自来！\n快给你爱的主播送上这个神奇的小谁能吧！",
                    15,
                    2,
                    "#ffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.CENTER,
                    true
                )
            )

            frame.items.add(
                getTextModel(
                    0,
                    100,
                    frame.width,
                    50.0,
                    "神奇宝箱为概率游戏，风险自负，请勿沉迷\n本活动最终解析权归XX APP所有",
                    11,
                    2,
                    "#aaffffff",
                    VerticalAlignemt.CENTER,
                    HorizontalAlignemt.CENTER,
                    true
                )
            )

            widgets.add(frame)

            return widgets
        }

        private fun getNavigation(): NavigationBarModel {
            val navigation = NavigationBarModel()
            navigation.position = WidgetModelPosition.TOP_FIX
            navigation.height = 40.0
            navigation.width = 375.0

            val text = TextWidgetModel()
            text.text = "神奇礼物玩法介绍"
            text.textColor = "#000000"
            text.width = -1.0
            text.height = -1.0
            text.textVerticalAlignemt = VerticalAlignemt.CENTER
            text.textHorizontalAlignemt = HorizontalAlignemt.CENTER

            navigation.title = text
            return navigation
        }

        private fun getImageModel(w: Double, h: Double, url: String): ImageWidgetModel {
            return getImageModel(0, 0, w, h, url)
        }

        private fun getImageModel(x: Int, y: Int, w: Double, h: Double, url: String): ImageWidgetModel {
            val image = ImageWidgetModel()
            image.x = x
            image.y = y
            image.width = w
            image.height = h
            image.imgSrc = url
            image.scaleType = ScaleType.FIX

            return image
        }

        private fun getTextModel(
            x: Int,
            y: Int,
            w: Double,
            h: Double,
            value: String,
            size: Int,
            maxlines: Int,
            color: String,
            vertical: VerticalAlignemt,
            horizontal: HorizontalAlignemt,
            bold: Boolean
        ): TextWidgetModel {
            val text = TextWidgetModel()
            text.x = x
            text.y = y
            text.width = w
            text.height = h
            text.maxLines = maxlines
            text.textVerticalAlignemt = vertical
            text.textHorizontalAlignemt = horizontal
            text.text = value
            text.textSize = size
            text.textColor = color
            text.lineSpacing = 5
            text.bold = bold
            return text
        }

    }
}