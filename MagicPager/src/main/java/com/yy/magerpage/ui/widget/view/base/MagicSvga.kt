package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.text.TextPaint
import android.text.TextUtils
import com.opensource.svgaplayer.SVGAImageView
import com.opensource.svgaplayer.SVGAParser
import com.opensource.svgaplayer.SVGACallback
import com.opensource.svgaplayer.SVGADynamicEntity
import com.opensource.svgaplayer.SVGAVideoEntity
import com.opensource.svgaplayer.SVGADrawable
import com.yy.magerpage.model.widget.base.SvgaWidgetModel
import com.yy.magerpage.ui.widget.view.AbstractMagic
import com.yy.magerpage.util.MLog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.net.URL
import java.util.concurrent.TimeUnit
import android.text.StaticLayout
import android.os.Build
import android.text.Layout
import com.yy.magerpage.model.widget.base.SvgaTextAlignment
import com.yy.magerpage.util.StringUtil


/**
 * Created by Sven on 2019-09-29
 * Svga view
 */
class MagicSvga(context: Context) : AbstractMagic<SvgaWidgetModel, SVGAImageView>(context) {

    var callback: SvgaViewCallback? = null

    private var mTimerDisposable: Disposable? = null

    override fun getContentView(): SVGAImageView {
        return SVGAImageView(context)
    }

    override fun analysisDetailData(model: SvgaWidgetModel) {

        mContentView?.loops = model.loops
        mContentView?.clearsAfterStop = model.cleanAfterStop

        mContentView?.callback = object : SVGACallback {
            override fun onFinished() {
                stopTimer()
                callback?.onFinished()
                MLog.i("Sven", "svga onFinished")
            }

            override fun onPause() {
                callback?.onPause()
                MLog.i("Sven", "svga onPause")
            }

            override fun onRepeat() {
                callback?.onRepeat()
                MLog.i("Sven", "svga onRepeat")
            }

            override fun onStep(frame: Int, percentage: Double) {
            }
        }

        val parser = SVGAParser(context)

        //注入参数
        val dynamicEntity = SVGADynamicEntity()
        model.textMap.entries.forEach {

            if (StringUtil.isEmpty(it.key) || StringUtil.isEmpty(it.value.text)) return

            val paint = TextPaint()
            paint.isAntiAlias = true
            it.value.textSize?.let { size -> paint.textSize = size }
            it.value.color?.let { color -> paint.color = color }

            val alignment = when (it.value.alignment) {
                SvgaTextAlignment.LEFT -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Layout.Alignment.ALIGN_LEFT
                } else {
                    Layout.Alignment.ALIGN_NORMAL
                }

                SvgaTextAlignment.RIGHT -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Layout.Alignment.ALIGN_RIGHT
                } else {
                    Layout.Alignment.ALIGN_OPPOSITE
                }

                SvgaTextAlignment.CENTER -> Layout.Alignment.ALIGN_CENTER
            }

            val layout =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StaticLayout.Builder.obtain(it.value.text, 0, it.value.text.length, paint, 0)
                        .setLineSpacing(5f, 1f)
                        .setAlignment(alignment)
                        .build()
                } else {
                    StaticLayout(
                        it.value.text,
                        paint,
                        0,
                        alignment,
                        1f,
                        5f,
                        true
                    )
                }

            dynamicEntity.setDynamicText(layout, it.key)
        }

        model.imageMap.entries.forEach {
            if (!StringUtil.isEmpty(it.key) && !StringUtil.isEmpty(it.value)) {
                dynamicEntity.setDynamicImage(it.value, it.key)
            }
        }


        val parseCompletion = object : SVGAParser.ParseCompletion {
            override fun onComplete(videoItem: SVGAVideoEntity) {
                val drawable = SVGADrawable(videoItem, dynamicEntity)
                val width = videoItem.videoSize.width
                val height = videoItem.videoSize.height

                val params = mContentView?.layoutParams

                if (model.width == -2.0) {
                    params?.width = this@MagicSvga.width
                    if (model.height == -2.0) {
                        params?.height = (this@MagicSvga.width * height / width).toInt()
                    }
                } else if (model.height == -2.0) {
                    params?.height = (mContentView!!.width * height / width).toInt()
                }
                mContentView?.layoutParams = params

                mContentView?.setImageDrawable(drawable)
                startAnimation()
            }

            override fun onError() {
                callback?.onError()
            }
        }

        if (!TextUtils.isEmpty(model.assetUrl)) {
            parser.decodeFromAssets(model.assetUrl!!, parseCompletion)
        } else if (!TextUtils.isEmpty(model.sourceUrl)) {
            parser.decodeFromURL(URL(model.sourceUrl!!), parseCompletion)
        }
    }

    fun startAnimation() {
        startTimer()
        mContentView?.startAnimation()
        callback?.onStart()
        MLog.i("Sven", "svga onStart")
    }

    fun stopAnimation() {
        mContentView?.stopAnimation()
    }


    private fun startTimer() {
        mTimerDisposable?.let {
            if (!it.isDisposed) it.dispose()
        }

        //无限循环 & 播放时长>0 设置定时停止
        if (mModel!!.loops == 0 && mModel!!.duration > 0) {
            mTimerDisposable =
                Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        if (mModel!!.duration == it.toInt()) {
                            stopAnimation()
                            stopTimer()
                        }
                    }
        }
    }

    fun stopTimer() {
        mTimerDisposable?.let {
            if (!it.isDisposed) it.dispose()
        }
    }

    interface SvgaViewCallback {
        fun onFinished()

        fun onPause()

        fun onRepeat()

        fun onStart()

        fun onError()
    }
}