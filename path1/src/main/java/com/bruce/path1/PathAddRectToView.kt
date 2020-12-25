package com.bruce.path1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/17
 *     desc  :
 * </pre>
 */
class PathAddRectToView(context: Context?, attrs: AttributeSet?) : BaseView(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            //移动坐标原点到屏幕中心
            it.translate(mWidth / 2f, mHeight / 2f)

            // 创建Path
            val path = Path()
            //CW:clockwise,顺时针
            //CCW:counter-clockwise,逆时针
            //这里由于画的是矩形CW,CCW效果一样
            path.addRect(-100f,-100f,100f,100f,
                Path.Direction.CW)
            //重置最后一个点的位置
            path.setLastPoint(-100f,200f)

            it.drawPath(path, mPaint)
        }

    }
}