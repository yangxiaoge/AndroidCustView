package com.bruce.canvas3

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  : todo
 * </pre>
 */
class DrawBitmapView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val mPaint = Paint()
    private var mWidth = 0
    private var mHeight = 0
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val bitmap = BitmapFactory.decodeResource(resources, R.raw.bitmap_test)
        // 第一种
//        canvas?.drawBitmap(bitmap, Matrix(),mPaint)

        // 第二种, 绘制时指定了图片左上角的坐标(距离坐标原点的距离)
//        canvas?.drawBitmap(bitmap,100f,100f,mPaint)

        // 第三种方法比较有意思,多了两个矩形区域(src,dst)
        // 此方法可以用来做动画，逐渐显示图片
        canvas?.translate(mWidth / 2f, mHeight / 2f)
        // 将画布坐标系移动到画布中央
        // 指定图片绘制区域(左上角的四分之一)
        val src = Rect(0, 0, bitmap.width / 2, bitmap.height / 2)
        // 指定图片在屏幕上显示的区域
        val dst = Rect(0, 0, 200, 300)
        canvas?.drawBitmap(bitmap,src,dst,mPaint)
    }
}