package com.yy.magerpage.util;


import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;

import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Sven on 2019-11-21
 */
public class RoundDrawable extends Drawable {
    private Paint mPaint;
    private Bitmap mBitmap;
    private RectF mRectF;
    private int mRound;

    public RoundDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        BitmapShader shader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        MLog.INSTANCE.i("SvenImg", "w->" + bitmap.getWidth() + ", h->" + bitmap.getHeight());
    }


    /**
     * 初始化区域
     */
    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        mRectF = new RectF(left, top, right, bottom);
        super.setBounds(left, top, right, bottom);

    }

    /**
     * 核心代码： 绘制圆角
     */
    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawRoundRect(mRectF, mRound, mRound, mPaint);
    }

    /**
     * 暴露给外面设置圆角的大小
     *
     * @param round
     */
    public void setRound(int round) {
        this.mRound = round;
    }

    /**
     * 设置圆角为高的百分比
     * @param hPrecent
     */
    public void setHeightRoundPrecent(double hPrecent) {
        this.mRound = (int) (mBitmap.getHeight() * hPrecent);
    }

    /**
     * 设置圆角为宽的百分比
     * @param wPrecent
     */
    public void setWidthRountPrcent(double wPrecent) {
        this.mRound = (int) (mBitmap.getWidth() * wPrecent);
    }

    /**
     * getIntrinsicWidth、getIntrinsicHeight主要是为了在View使用wrap_content的时候，
     * 提供一下尺寸，默认为-1可不是我们希望的
     */
    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    /**
     * 根据画笔设定drawable的透明度
     */
    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    /**
     * 根据画笔设定drawable的颜色过滤器
     */
    @Override
    public void setColorFilter(@Nullable ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
