package com.bruce.canvas3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Picture
import android.graphics.drawable.PictureDrawable
import android.util.AttributeSet
import android.view.View


/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  :
 * </pre>
 */
class DrawPictureView : View {
    // 1.创建Picture
    private val mPicture = Picture()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        // 调用录制
        recoding()
    }

    // 2.录制内容方法
    private fun recoding() {
        // 开始录制 (接收返回值Canvas)
        val canvas = mPicture.beginRecording(450, 450)
        // 创建画笔
        val mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.color = Color.BLUE
        mPaint.style = Paint.Style.FILL

        canvas.translate(200f, 200f)
        canvas.drawCircle(0f, 0f, 100f, mPaint)

        mPicture.endRecording()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //1.使用Picture提供的draw方法绘制:
        //这种方法在比较低版本的系统上绘制后可能会影响Canvas状态，所以这种方法一般不会使用。
        //mPicture.draw(canvas)

        //2.使用Canvas提供的drawPicture方法绘制
        //和使用Picture的draw方法不同，Canvas的drawPicture不会影响Canvas状态。
        //canvas.drawPicture(mPicture)
        //绘制的内容根据选区进行了缩放
        //canvas.drawPicture(mPicture, RectF(0f, 0f, mPicture.width.toFloat(), 200f))

        //3.将Picture包装成为PictureDrawable，使用PictureDrawable的draw方法绘制。
        //包装成为Drawable
        //此处setBounds是设置在画布上的绘制区域，并非根据该区域进行缩放，也不是剪裁Picture，每次都从Picture的左上角开始绘制。
        val drawable = PictureDrawable(mPicture)
        // 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
        drawable.setBounds(0, 0, 250, mPicture.height)
        // 绘制
        drawable.draw(canvas)
    }
}