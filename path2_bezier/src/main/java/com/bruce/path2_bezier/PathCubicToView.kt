package com.bruce.path2_bezier

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/17
 *     desc  :
 * </pre>
 */
class PathCubicToView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val mPaint by lazy {
        Paint()
            .apply {
                isAntiAlias = true
                color = Color.BLACK
                strokeWidth = 8f
                style = Paint.Style.STROKE
                textSize = 60f
            }
    }

    //两个数据点
    private val start by lazy {
        PointF(0f, 0f)
    }
    private val end by lazy {
        PointF(0f, 0f)
    }

    //两个控制点
    private val control1 by lazy {
        PointF(0f, 0f)
    }

    private val control2 by lazy {
        PointF(0f, 0f)
    }

    //中心点x，y坐标
    private var centerX = 0f
    private var centerY = 0f

    private var mode = true

    fun setMode(mode: Boolean) {
        this.mode = mode
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2f
        centerY = h / 2f

        // 初始化数据点和控制点的位置
        start.x = centerX - 200
        start.y = centerY
        end.x = centerX + 200
        end.y = centerY
        control1.x = centerX
        control1.y = centerY - 100
        control2.x = centerX + 100
        control2.y = centerY - 100
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // 根据触摸位置更新控制点，并提示重绘
        if (mode) {
            control1.x = event.x
            control1.y = event.y
        } else {
            control2.x = event.x
            control2.y = event.y
        }
        //重新绘制
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 绘制数据点和控制点
        mPaint.color = Color.GRAY
        mPaint.strokeWidth = 20f
        canvas.drawPoint(start.x, start.y, mPaint)
        canvas.drawPoint(end.x, end.y, mPaint)
        canvas.drawPoint(control1.x, control1.y, mPaint)
        canvas.drawPoint(control2.x, control2.y, mPaint)

        // 绘制辅助线
        mPaint.strokeWidth = 4f
        canvas.drawLine(start.x, start.y, control1.x, control1.y, mPaint)
        canvas.drawLine(control1.x, control1.y, control2.x, control2.y, mPaint)
        canvas.drawLine(control2.x, control2.y, end.x, end.y, mPaint)

        // 绘制三阶贝塞尔曲线
        mPaint.color = Color.RED
        mPaint.strokeWidth = 8f

        val path = Path()
        path.moveTo(start.x, start.y)
        path.cubicTo(control1.x, control1.y, control2.x, control2.y, end.x, end.y)

        canvas.drawPath(path, mPaint)
    }
}