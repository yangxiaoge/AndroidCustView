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
class PathCloseView(context: Context?, attrs: AttributeSet?) : BaseView(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            canvas.translate((mWidth / 2).toFloat(), (mHeight / 2).toFloat()) // 移动坐标系到屏幕中心

            val path = Path() // 创建Path
            path.lineTo(200f, 200f) // lineTo
            path.lineTo(200f, 0f) // lineTo
            //path.lineTo(400f,200f) //lineTo
            //close方法用于连接当前最后一个点和最初的一个点(如果两个点不重合的话)，
            // 最终形成一个封闭的图形
            // 如果连接了最后一个点和第一个点仍然无法形成封闭图形，则close什么 也不做。(比如用moveTo移动上一次坐标点导致不连续)
            path.close() // close

            canvas.drawPath(path, mPaint) // 绘制Path
        }
    }
}