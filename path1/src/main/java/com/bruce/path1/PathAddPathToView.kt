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
class PathAddPathToView(context: Context?, attrs: AttributeSet?) : BaseView(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            //移动坐标原点到屏幕中心
            canvas.translate(mWidth / 2f, mHeight / 2f)
            //翻转y轴坐标(缩放比例为负数的时候会根据缩放中心轴进行翻转)
            canvas.scale(1f, -1f)

            val path = Path()
            val src = Path()
            path.addRect(
                -200f, -200f, 200f, 200f,
                Path.Direction.CW
            )
            src.addCircle(0f, 0f, 100f, Path.Direction.CW)

            //将两个Path合并成为一个
            path.addPath(src, 0f, 200f)

            canvas.drawPath(path, mPaint)
        }

    }
}