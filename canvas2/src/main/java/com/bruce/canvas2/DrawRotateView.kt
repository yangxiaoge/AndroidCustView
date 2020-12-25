package com.bruce.canvas2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  : 旋转
 * </pre>
 */
class DrawRotateView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var mWidth = 0
    private var mHeight = 0
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE

        // 将坐标系原点移动到画布正中心
        canvas?.translate(mWidth / 2f, mHeight / 2f)
        // 画坐标轴
        canvas?.drawLine(-mWidth / 2f, 0f, mWidth / 2f, 0f, mPaint)
        canvas?.drawLine(0f, -mHeight / 2f, 0f, mHeight / 2f, mPaint)

        // 矩形
        val rect = RectF(0f, -200f, 200f, 0f)
        // 绘制黑色矩形
        mPaint.color = Color.BLACK
        canvas?.drawRect(rect, mPaint)

        //旋转180°， 默认旋转中心为原点
        canvas?.rotate(180f)
        // 绘制蓝色矩形
        mPaint.color = Color.BLUE
        canvas?.drawRect(rect, mPaint)
    }
}