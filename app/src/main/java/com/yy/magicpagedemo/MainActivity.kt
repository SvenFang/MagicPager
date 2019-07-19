package com.yy.magicpagedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.model.widget.collection.CarouselWidgetModel
import com.yy.magerpage.model.widget.collection.FrameWidgetModel
import com.yy.magerpage.provider.IImageLoadProvider
import com.yy.magerpage.provider.ILog
import com.yy.magerpage.provider.IMagicProvider
import com.yy.magerpage.provider.MagicProviderCallBack
import com.yy.magicpagedemo.test.Test
import com.yy.magerpage.ui.MagicActivity
import com.yy.magerpage.ui.widget.view.MagicViewHelper
import com.yy.magicpagedemo.util.AssetReader
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMagic()

        val test1: Button = findViewById(R.id.test1Btn)
        val test2: Button = findViewById(R.id.test2Btn)

        test1.setOnClickListener {
            MagicActivity.startMagic(this, "test", "test")
        }

        test2.setOnClickListener {
            MagicActivity.startMagic(this, "test", "test_ad")
        }

    }

    private fun initMagic() {
        MagicPagerManager.get().imageProvider = object : IImageLoadProvider {
            override fun loadImage(imageView: ImageView, url: String) {
                Glide.with(imageView).load(url).into(imageView)
            }

        }

        MagicPagerManager.get().addPagerProvider(object : IMagicProvider {
            override fun getProviderType(): String {
                return "test"
            }

            override fun getMagicData(
                key: String,
                header: Map<String, Any>?,
                params: Map<String, Any>?,
                callBack: MagicProviderCallBack
            ) {
                when (key) {
                    "test" -> callBack.onSuccess(AssetReader.getTextModel())
                    "test_ad" -> callBack.onSuccess(AssetReader.getAdModel())
                }

            }
        })


        MagicPagerManager.get().setLoger(object : ILog {
            override fun d(tag: String, format: String) {
                Log.d(tag, format)
            }

            override fun i(tag: String, format: String) {
                Log.i(tag, format)
            }

            override fun w(tag: String, format: String) {
                Log.w(tag, format)
            }

            override fun e(tag: String, format: String) {
                Log.e(tag, format)
            }

            override fun e(tag: String, format: String, e: Throwable) {
                Log.e(tag, format, e)
            }
        })

        val test: LinearLayout = findViewById(R.id.ll_test)
        test.addView(MagicViewHelper.createView(getCarou("#ff00ff"), this))
        test.addView(MagicViewHelper.createView(getCarou("#ff0000"), this))
        test.addView(MagicViewHelper.createView(getCarou("#0000ff"), this))
    }

    private fun getCarou(color: String): BaseWidgetModel {
        val carou = CarouselWidgetModel()
        carou.width = 375.0
        carou.height = 100.0
        carou.bgColor = color
        carou.autoPlay = true

        val colors = ArrayList<String>()
        colors.add("#ffff00")
        colors.add("#ffff55")
        colors.add("#ffffaa")
        for (i in 0..4) {
            val frame1 = FrameWidgetModel()
            frame1.width = 375.0
            frame1.height = 100.0
            for (j in 0..2) {
                val img = ImageWidgetModel()
                img.width = 60.0
                img.height = 60.0
                img.x = 100 + j * 50
                img.y = 20
                img.corner = 30
                img.borderColor = "#00ffff"
                img.bgColor = colors[j]
                img.border = 2
                frame1.items.add(img)
            }
            carou.items.add(frame1)
        }

        return carou
    }
}
