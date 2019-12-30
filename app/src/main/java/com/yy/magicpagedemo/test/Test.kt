package com.yy.magicpagedemo.test

import com.yy.magerpage.model.container.MagicPagerModel
import com.yy.magerpage.model.modelenum.*
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.Margin
import com.yy.magerpage.model.widget.Padding
import com.yy.magerpage.model.widget.base.*
import com.yy.magerpage.model.widget.collection.*
import com.yy.magerpage.script.MagicScript
import com.yy.magicpagedemo.R

/**
 * Created by Sven on 13/05/2019
 */
class Test {
    companion object {
        @JvmStatic
        fun getTestFrame(): MagicPagerModel {
            val page = MagicPagerModel()

            val frame = FrameWidgetModel()
            frame.width = 375.0
            frame.height = 115.0
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
                btn.height = 115.0

                val img = ImageWidgetModel()
                img.width = BaseWidgetModel.MATCH_PARENT
                img.height = BaseWidgetModel.MATCH_PARENT
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

        @JvmStatic
        fun getTestModel(): MagicPagerModel {
            val page = MagicPagerModel()
            //导航栏
            page.navigationBar = getNavigation()
            page.widget = getWidgets()
            page.bgImage =
                "https://vipweb.bs2cdn.yy.com/vipinter_735aeba48ce743a09a8119533f25fe40.jpeg"
            page.refreshable = true
            return page
        }

        private fun getTestNewWidget(): ArrayList<BaseWidgetModel> {
            val widgets = ArrayList<BaseWidgetModel>()
            val linear = LinearWidgetModel()
            linear.width = 375.0
            linear.height = 300.0
            linear.orientation = Orientation.VERTICAL
            linear.verticalAlignment = VerticalAlignment.BOTTOM
            linear.horizontalAlignment = HorizontalAlignment.RIGHT
            linear.margin = Margin(0, 0, 5, 0)

            val frame = FrameWidgetModel()
            frame.width = 80.0
            frame.height = 114.0
            frame.bgColor = "#00000000"
            frame.action = MagicScript.call("gvJump", "http://www.baidu.com", null)
            linear.items.add(frame)


            val kuang = FrameWidgetModel()
            kuang.margin = Margin(8, 28, 8, 1)
            kuang.width = BaseWidgetModel.MATCH_PARENT
            kuang.height = BaseWidgetModel.MATCH_PARENT
            kuang.bgColor = "#042427"
            kuang.border = 0.5
            kuang.corner = 2.0
            kuang.borderColor = "#D8B15A"
            frame.items.add(kuang)

            val titles = arrayOf("小时榜排行", "赏金任务", "达标等级")
            val values = arrayOf("39", "1000/5000", "青铜")
            for (i in 0..2) {
                val title = TextWidgetModel()
                title.text = titles[i]
                title.textColor = "#ECCC86"
                title.textHorizontalAlignment = HorizontalAlignment.CENTER
                title.textVerticalAlignment = VerticalAlignment.CENTER
                title.y = (3 + i * 26).toDouble()
                title.margin = Margin(5, 0, 5, 0)
                title.width = BaseWidgetModel.MATCH_PARENT
                title.height = 12.0
                title.textSize = 7

                val value = TextWidgetModel()
                value.text = values[i]
                value.textColor = "#ECCC86"
                value.textHorizontalAlignment = HorizontalAlignment.CENTER
                value.textVerticalAlignment = VerticalAlignment.CENTER
                value.margin = Margin(5, 0, 5, 0)
                value.width = BaseWidgetModel.MATCH_PARENT
                value.bgColor = "#024D43"
                value.border = 0.5
                value.bold = true
                value.borderColor = "#E8C065"
                value.corner = 1.0
                value.height = 12.0
                value.y = (2 + i * 26 + 13).toDouble()
                value.textSize = 7

                kuang.items.add(title)
                kuang.items.add(value)
            }

            val line = BlankWidgetModel()
            line.width = BaseWidgetModel.MATCH_PARENT
            line.height = BaseWidgetModel.MATCH_PARENT
            line.borderColor = "#88D8B15A"
            line.border = 0.5
            line.margin = Margin(3, 3, 3, 3)
            kuang.items.add(line)


            val img = ImageWidgetModel()
            img.imgSrc = "https://mgamevoice2.bs2dl.yy.com/88b54f9167294fe4ae72f4de3be8e5f8.png"
            img.width = 80.0
            img.height = 53.0
            frame.items.add(img)

            widgets.add(linear)
            return widgets
        }

        private fun getReuses(): ArrayList<BaseWidgetModel> {
            val widgets = ArrayList<BaseWidgetModel>()

            val colors = arrayListOf("#ff0000", "#ffff00", "#00ff00", "#0000ff", "#00ffff")
            for (i in 0..100) {
                val frame = FrameWidgetModel()
                frame.reuseId = 100
                frame.bgColor = colors[i % 4]
                frame.width = 375.0
                frame.height = 100 + Math.random() * 10

                for (j in 0..3) {
                    val text = TextWidgetModel()
                    text.x = (Math.random() * 10 + 30)
                    text.y = (Math.random() * 10 + 30 * j)
                    text.textSize = 20
                    text.textColor = "#000000"
                    text.text = "随机数" + Math.random()
                    text.width = 150.0
                    text.height = 40.0
                    frame.items.add(text)
                }
                widgets.add(frame)
            }


            return widgets
        }

        private fun getWidgets(): BaseWidgetModel {
            val widgets = ArrayList<BaseWidgetModel>()

            //文本
            var textModel = TextWidgetModel()
            textModel.width = -1.0
            textModel.text = "以下是基础控件"
            textModel.margin = Margin(left = 5, top = 5, right = 5, bottom = 5)
            textModel.padding = Padding(left = 5, top = 5, right = 5, bottom = 5)
            textModel.bgColor = "#ffff00"
            widgets.add(textModel)

            textModel = TextWidgetModel()
            textModel.text = "我是一个文本"
            textModel.margin = Margin(left = 10, top = 5, right = 10, bottom = 5)
            widgets.add(textModel)
            //按钮
            val buttonModel = ButtonWidgetModel()
            buttonModel.text = "我是一个按钮"
            buttonModel.bgColor = "#ff00ff"
            buttonModel.corner = 10.0
            buttonModel.border = 2.0
            buttonModel.borderColor = "#0000ff"
            buttonModel.padding = Padding(left = 10, top = 10, right = 10, bottom = 10)
            buttonModel.margin = Margin(left = 15, top = 15, right = 15, bottom = 15)
            widgets.add(buttonModel)

            //图片
            val imageModel = ImageWidgetModel()
            imageModel.imgSrc =
                "https://review.chinabrands.cn/chinab"
            imageModel.imgRes = R.mipmap.default_portrait_140_140
            imageModel.height = 200.0
            imageModel.width = 200.0
            imageModel.scaleType = ScaleType.CROP
            imageModel.corner = 100.0
            widgets.add(imageModel)

            //文本
            textModel = TextWidgetModel()
            textModel.width = -1.0
            textModel.text = "以下是grid容器控件"
            textModel.margin = Margin(left = 5, top = 5, right = 5, bottom = 5)
            textModel.padding = Padding(left = 5, top = 5, right = 5, bottom = 5)
            textModel.bgColor = "#ffff00"
            widgets.add(textModel)

            widgets.add(testMogoTypes())


            //文本
            textModel = TextWidgetModel()
            textModel.width = -1.0
            textModel.text = "以下是横向slide容器控件"
            textModel.margin = Margin(left = 5, top = 5, right = 5, bottom = 5)
            textModel.padding = Padding(left = 5, top = 5, right = 5, bottom = 5)
            textModel.bgColor = "#ffff00"
            widgets.add(textModel)
            widgets.add(testSlideModel())

            //文本
            textModel = TextWidgetModel()
            textModel.width = -1.0
            textModel.text = "以下是垂直list容器控件"
            textModel.margin = Margin(left = 5, top = 5, right = 5, bottom = 5)
            textModel.padding = Padding(left = 5, top = 5, right = 5, bottom = 5)
            textModel.bgColor = "#ffff00"
            widgets.add(textModel)
            widgets.add(testListModel())

            //文本
            textModel = TextWidgetModel()
            textModel.width = -1.0
            textModel.text = "以下是carouse容器控件"
            textModel.margin = Margin(left = 5, top = 5, right = 5, bottom = 5)
            textModel.padding = Padding(left = 5, top = 5, right = 5, bottom = 5)
            textModel.bgColor = "#ffff00"
            widgets.add(textModel)
            widgets.add(testCarouselModel())
            val list = ListWidgetModel()
            list.width = BaseWidgetModel.MATCH_PARENT
            list.height = BaseWidgetModel.MATCH_PARENT
            list.items = widgets
            return list
        }

        private fun getNavigation(): NavigationBarModel {
            val navigation = NavigationBarModel()
            navigation.height = 40.0
            navigation.width = 375.0

            val text = TextWidgetModel()
            text.text = "标题"
            text.textColor = "#000000"
            text.width = -1.0
            text.height = -1.0
            text.textVerticalAlignment = VerticalAlignment.CENTER
            text.textHorizontalAlignment = HorizontalAlignment.CENTER

            navigation.title = text
            navigation.reuseId = 20
            return navigation
        }

        private fun testMogoTypes(): BaseWidgetModel {
            val gridModel = GridWidgetModel()
            gridModel.width = 375.0
            gridModel.height = 285.0
            gridModel.column = 5
            gridModel.row = 3

            val titles =
                arrayListOf(
                    "女装",
                    "上衣",
                    "裤子",
                    "裙子",
                    "套装",
                    "女鞋",
                    "美妆个护",
                    "包包",
                    "配饰",
                    "内衣",
                    "男友",
                    "家具",
                    "母婴",
                    "食品",
                    "运动"
                )

            val imgs =
                arrayListOf(
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_5gc489a8e9ihjc75id9855ih7e7aa_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4dk1d1hjakh9idcg1ik2ghbhc001e_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_6afff7fl63960blf04kh1gl083ld9_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_0edi982h99ca9dk254h8bckdil0gf_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_2hb498c4ah157i76k5b0h225j147j_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4flb21c3kdc0h972ded69dd6016b6_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_80a3d4e73kijb41b257i519ij8a51_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_29fdaheg68bk9e35dj57177ac76g9_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_5d5j2h247g2id53h3hdge4j3be8gh_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_326ihcfk2g36d309ihlljebk30e68_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_5ah1fh01fijh2a6g25ie44el244af_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_13jk83l6d2c6bk156gikc97h9d826_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_02a8d20l8ff3d2ddej4ahlgc47h12_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_60dgefe9k795l95j1b1kka49ljkl3_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4abf1a2380cjl5f8h74e3ld36e843_150x150.jpg_640x640.v1cAC.40.webp"
                )

            for (i in 0..14) {
                val frame = FrameWidgetModel()
                frame.width = 1.0
                frame.height = 1.0
                frame.x = (i % 5).toDouble()
                frame.y = (i / 5).toDouble()

                val image = ImageWidgetModel()
                image.imgSrc = imgs[i]
                image.y = 5.0
                image.width = 375.0 / 5
                image.height = image.width - 10
                image.scaleType = ScaleType.INSIDE

                val text = TextWidgetModel()
                text.text = titles[i]
                text.width = 375.0 / 5
                text.height = 20.0
                text.textColor = "#333333"
                text.textSize = 13
                text.y = 75.0
                text.textHorizontalAlignment = HorizontalAlignment.CENTER

                frame.items.add(image)
                frame.items.add(text)

                gridModel.items.add(frame)
            }
            return gridModel
        }

        private fun testCarouselModel(): CarouselWidgetModel {
            val model = CarouselWidgetModel()
            model.width = 375.0
            model.height = 150.0
            model.autoPlay = true
            model.duration = 1000

            val imgs = arrayListOf(
                "https://aecpm.alicdn.com/simba/img/TB1CWf9KpXXXXbuXpXXSutbFXXX.jpg_q50.jpg",
                "https://aecpm.alicdn.com/simba/img/TB14ab1KpXXXXclXFXXSutbFXXX.jpg_q50.jpg",
                "https://s11.mogucdn.com/mlcdn/c45406/190411_7i3ic1k8k7hl4hgak2982i3bl18kl_750x300.jpg_999x999.v1c0.81.webp",
                "https://s2.mogucdn.com/mlcdn/c45406/190725_7j11i8k5cgi6b7f37hkj407ka6bgb_1125x450.jpg_1100x9999.v1c7E.81.webp",
                "https://s2.mogucdn.com/mlcdn/c45406/190729_196852451i453i8c0lb0629e508kh_1125x450.jpg_1100x9999.v1c7E.81.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190411_7i3ic1k8k7hl4hgak2982i3bl18kl_750x300.jpg_999x999.v1c0.81.webp"
            )
            for (i in 0..1) {
                val image = ImageWidgetModel()
                image.width = -1.0
                image.height = -1.0
                image.imgSrc = imgs[i]
                image.scaleType = ScaleType.CROP
//                image.margin = arrayOf("10", "10", "10", "10")
                model.items.add(image)
            }

            return model
        }

        private fun testListModel(): ListWidgetModel {
            val model = ListWidgetModel()
            model.width = 375.0
            model.listType = ListWidgetType.DOUBLE
            model.bgColor = "#efefef"

            val imgs = arrayListOf(
                "https://s11.mogucdn.com/mlcdn/c45406/190528_7geh92gbb3k950917ic5i3ch77cl8_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190727_0d0iia23bi0ag5c21di8e5b0ej3h9_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190704_1g271843ajei9hel2b36432a5kf11_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190712_55ca53bla7c6i4fcj6ajlh1hl15g4_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190526_639564i5gf8a2kb0dk759b065hcce_640x853.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/55cf19/190604_62bgblblg37856l41bae0fe847bej_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190626_72e7bgeajh9kc3h86hakddjihfage_640x850.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190711_375efebe90b86faiidl0d7g8aj02h_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190703_149h64e7982f2g1g5h0af72kgjj43_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/55cf19/190712_81klf7kjgihgg1hk5ac66lhklb1jf_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190715_27f66e225hbkij50chfdg697ldh8g_640x960.jpg_640x854.v1cAC.40.webp"
            )
            val names = arrayListOf(
                "短袖T恤女上衣2019夏装新款V领韩版显瘦百搭休闲交叉体恤潮",
                "2019夏装新款女装欧货时尚清新牛油果绿气质流行雪纺连衣裙子",
                "夏季新款超火的露脐短袖T恤+高腰泫雅阔腿牛仔裤两件套装女潮",
                "夏季新款韩版小清新荷叶边v领蕾丝上衣宽松短袖奶油杏色雪纺衫",
                "定制2019夏新款宽松针织衫短长袖网洞上衣抽绳镂空V领罩衫",
                "韩版甜美小清新宽松显瘦蝴蝶结短袖棉麻连衣裙A字裙子夏季",
                "2019夏季新款韩版露腰T恤束脚哈伦裤两件套休闲百搭时尚套装",
                "夏季韩版高腰垂感冰丝阔腿裤女宽松薄款裤子直筒休闲裤拖地九分裤",
                "牛油果绿t恤女新款半袖宽松网红港味ins心机上衣设计感中长款",
                "宽松短袖T恤女装夏装新款潮韩版ins洋气中长款设计感网红上衣",
                "夏季新款韩版宽松学生ins减龄吊带裤高腰牛仔背带短裤"
            )
            val prices =
                arrayListOf(
                    "¥39.9",
                    "¥90",
                    "¥40",
                    "¥89.3",
                    "¥9.9",
                    "¥45",
                    "¥34.5",
                    "¥99.9",
                    "¥44.5",
                    "¥97",
                    "¥44.7"
                )
            val sales = arrayListOf(
                "已售530件",
                "已售0件",
                "已售44件",
                "已售999件",
                "已售38件",
                "已售50件",
                "已售0件",
                "已售880件",
                "已售53件",
                "已售32件",
                "已售20件"
            )

            for (i in 0..10) {
                val item = FrameWidgetModel()
                item.bgColor = "#ffffff"

                item.width = 375.0 / 2
                item.height = 340.0
                item.margin = Margin(left = 5, top = 5, right = 5, bottom = 5)
                item.corner = 3.0
                model.items.add(item)

                val image = ImageWidgetModel()
                image.scaleType = ScaleType.CROP
                image.imgSrc = imgs[i]
                image.width = item.width
                image.height = item.height - 88
                item.items.add(image)

                val title = TextWidgetModel()
                title.text = names[i]
                title.textColor = "#333333"
                title.textSize = 12
                title.padding = Padding(5, 0, 5, 0)
                title.width = -1.0
                title.height = 21.0
                title.textVerticalAlignment = VerticalAlignment.CENTER
                title.y = image.height
                item.items.add(title)

                val price = TextWidgetModel()
                price.text = prices[i]
                price.textColor = "#000000"
                price.textSize = 13
                price.width = -1.0
                price.height = 21.0
                price.bold = true
                price.padding = Padding(5, 0, 5, 0)
                price.y = (title.y + title.height)
                price.textVerticalAlignment = VerticalAlignment.CENTER
                item.items.add(price)

                val button = ButtonWidgetModel()
                button.corner = 3.0
                button.bgColor = "#ff5777"
                button.textColor = "#ffffff"
                button.margin = Margin(5, 0, 5, 0)
                button.text = "立即购买"
                button.width = -1.0

                button.y = (price.y + price.height)
                button.height = 30.0
                item.items.add(button)

                val buyCount = TextWidgetModel()
                buyCount.textHorizontalAlignment = HorizontalAlignment.CENTER
                buyCount.textVerticalAlignment = VerticalAlignment.CENTER
                buyCount.text = sales[i]
                buyCount.width = 100.0
                buyCount.height = 23.0
                buyCount.bgColor = "#55000000"
                buyCount.textColor = "#ffffff"
                buyCount.textSize = 10
                buyCount.y = (image.height - 33)
                item.items.add(buyCount)
            }


            return model
        }

        private fun testFlexbox(): FlexBoxWidgetModel {
            val model = FlexBoxWidgetModel()
            model.flexWrap = MFlexWrap.WRAP

            val item1 = ButtonWidgetModel()
            item1.text = "0,0,1,1"
            item1.bgColor = "#ff00ff"
            item1.width = 100.0
            item1.height = 100.0

            val item2 = ImageWidgetModel()
            item2.imgSrc = "https://upload.jianshu.io/users/upload_avatars" +
                    "/17775851/74897be1-1d4f-4968-909e-cb3cb67e7643?imageMogr2/auto-orient" +
                    "/strip|imageView2/1/w/240/h/240"
            item2.bgColor = "#ffffff"
            item2.width = 375.0
            item2.height = 100.0
            item2.margin = Margin(5, 5, 5, 5)
            item2.border = 8.0
            item2.borderColor = "#00ff00"

            val item3 = ButtonWidgetModel()
            item3.text = "1,0,3,1"
            item3.bgColor = "#0ff0ff"
            item3.width = 375.0
            item3.height = 100.0

            val item4 = ButtonWidgetModel()
            item4.text = "0,1,1,3"
            item4.bgColor = "#ffff00"
            item4.width = 375.0
            item4.height = 100.0

            model.items.add(item1)
            model.items.add(item2)
            model.items.add(item3)
            model.items.add(item4)
            return model
        }


        var testObject = HashMap<String, String>()


        private fun testSlideModel(): SliderWidgetModel {
            val model = SliderWidgetModel()
            model.width = 375.0
            model.bgColor = "#efefef"

            val imgs = arrayListOf(
                "https://s11.mogucdn.com/mlcdn/c45406/190528_7geh92gbb3k950917ic5i3ch77cl8_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190727_0d0iia23bi0ag5c21di8e5b0ej3h9_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190704_1g271843ajei9hel2b36432a5kf11_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190712_55ca53bla7c6i4fcj6ajlh1hl15g4_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190526_639564i5gf8a2kb0dk759b065hcce_640x853.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/55cf19/190604_62bgblblg37856l41bae0fe847bej_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190626_72e7bgeajh9kc3h86hakddjihfage_640x850.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190711_375efebe90b86faiidl0d7g8aj02h_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190703_149h64e7982f2g1g5h0af72kgjj43_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/55cf19/190712_81klf7kjgihgg1hk5ac66lhklb1jf_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190715_27f66e225hbkij50chfdg697ldh8g_640x960.jpg_640x854.v1cAC.40.webp"
            )

            for (i in 0..10) {
                val image = ImageWidgetModel()
                image.scaleType = ScaleType.CROP
                image.imgSrc = imgs[i]
                image.width = 88.0
                image.height = 88.0
                image.margin = Margin(5, 5, 5, 5)
                model.items.add(image)
            }

            return model
        }

        private fun getScrollViewData(): ArrayList<BaseWidgetModel> {
            val widgets = ArrayList<BaseWidgetModel>()
            val imgs =
                arrayListOf(
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_5gc489a8e9ihjc75id9855ih7e7aa_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4dk1d1hjakh9idcg1ik2ghbhc001e_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_6afff7fl63960blf04kh1gl083ld9_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_0edi982h99ca9dk254h8bckdil0gf_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_2hb498c4ah157i76k5b0h225j147j_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4flb21c3kdc0h972ded69dd6016b6_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_80a3d4e73kijb41b257i519ij8a51_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_29fdaheg68bk9e35dj57177ac76g9_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_5d5j2h247g2id53h3hdge4j3be8gh_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_326ihcfk2g36d309ihlljebk30e68_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_5ah1fh01fijh2a6g25ie44el244af_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_13jk83l6d2c6bk156gikc97h9d826_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_02a8d20l8ff3d2ddej4ahlgc47h12_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_60dgefe9k795l95j1b1kka49ljkl3_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4abf1a2380cjl5f8h74e3ld36e843_150x150.jpg_640x640.v1cAC.40.webp"
                )

            for (i in 0 until imgs.size) {

                val image = ImageWidgetModel()
                image.imgSrc = imgs[i]
                image.y = 5.0
                image.width = 375.0 / 5
                image.height = image.width - 10
                image.scaleType = ScaleType.INSIDE
                widgets.add(image)
            }
            return widgets
        }

    }


}