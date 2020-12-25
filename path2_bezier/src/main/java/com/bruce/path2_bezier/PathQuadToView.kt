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
 *     desc  : 二阶贝塞尔曲线：由两个数据点，一个控制点构成
 * </pre>
 */
class PathQuadToView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
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

    //一个控制点
    private val control by lazy {
        PointF(0f, 0f)
    }

    //中心点x，y坐标
    private var centerX = 0f
    private var centerY = 0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2f
        centerY = h / 2f

        // 初始化数据点和控制点的位置
        start.x = centerX - 200
        start.y = centerY
        end.x = centerX + 200
        end.y = centerY
        control.x = centerX
        control.y = centerY - 100
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // 根据触摸位置更新控制点，并提示重绘
        control.x = event.x
        control.y = event.y
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
        canvas.drawPoint(control.x, control.y, mPaint)

        // 绘制辅助线
        mPaint.strokeWidth = 4f
        canvas.drawLine(start.x, start.y, control.x, control.y, mPaint)
        canvas.drawLine(end.x, end.y, control.x, control.y, mPaint)

        // 绘制二阶贝塞尔曲线
        val path = Path()
        path.moveTo(start.x, start.y)
        path.quadTo(control.x, control.y, end.x, end.y)
        canvas.drawPath(path, mPaint)
    }
}