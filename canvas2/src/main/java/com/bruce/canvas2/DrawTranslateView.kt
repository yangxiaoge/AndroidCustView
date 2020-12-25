package com.bruce.canvas2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  : 位移
 * </pre>
 */
class DrawTranslateView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val mPaint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.isAntiAlias = true


        //请注意，位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动

        // 在坐标原点绘制一个黑色圆形
        mPaint.color = Color.RED
        canvas?.translate(100f, 100f)
        canvas?.drawCircle(0f, 0f, 50f, mPaint)

        // 在坐标原点绘制一个蓝色圆形
        mPaint.color = Color.GREEN
        canvas?.translate(100f, 100f)
        canvas?.translate(100f, 100f)
        canvas?.drawCircle(0f, 0f, 50f, mPaint)

    }
}