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
 *     desc  : 缩放
 * </pre>
 */
class DrawScaleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
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
        mPaint.color = Color.BLACK
        // 描边
        mPaint.style = Paint.Style.STROKE

        // 将坐标系原点移动到画布正中心
        canvas?.translate(mWidth / 2f, mHeight / 2f)
        // 画坐标轴
        canvas?.drawLine(-mWidth / 2f, 0f, mWidth / 2f, 0f, mPaint)
        canvas?.drawLine(0f, -mHeight / 2f, 0f, mHeight / 2f, mPaint)

        // 矩形
        val rect = RectF(0f, -200f, 200f, 0f)

        canvas?.drawRect(rect, mPaint)

        // 画布缩放0.5
        canvas?.scale(0.5f, 0.5f)
        // 绘制蓝色矩形
        mPaint.color = Color.RED;
        canvas?.drawRect(rect, mPaint)

        // 画布缩放  <-- 缩放中心向右偏移了100个单位
        canvas?.scale(0.5f,0.5f,100f,0f)
        // 绘制蓝色矩形
        mPaint.color = Color.BLUE
        canvas?.drawRect(rect,mPaint)

        // 当缩放比例为负数的时候会根据缩放中心轴进行翻转
        canvas?.scale(-1f,-1f)    // 画布缩放
        mPaint.color = Color.YELLOW            // 绘制蓝色矩形
        canvas?.drawRect(rect,mPaint)
    }
}