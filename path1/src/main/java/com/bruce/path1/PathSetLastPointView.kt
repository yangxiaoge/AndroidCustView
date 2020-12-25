package com.bruce.path1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/17
 *     desc  :
 * </pre>
 */
class PathSetLastPointView(context: Context?, attrs: AttributeSet?) : BaseView(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.translate((mWidth / 2).toFloat(), (mHeight / 2).toFloat()) // 移动坐标系到屏幕中心

            val path = Path() // 创建Path
            path.lineTo(200f, 200f) // lineTo
            path.setLastPoint(200f, 100f) // setLastPoint
            path.lineTo(200f, 0f) // lineTo

            it.drawPath(path, mPaint) // 绘制Path
        }

    }
}