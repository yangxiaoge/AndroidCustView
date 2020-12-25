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
class PathLineToView(context: Context?, attrs: AttributeSet?) : BaseView(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            //移动坐标原点到屏幕中心
            it.translate(mWidth / 2f, mHeight / 2f)

            // 创建Path
            val path = Path()
            // lineTo
            path.lineTo(100f, 100f)
            path.lineTo(100f, 0f)

            it.drawPath(path, mPaint)
        }

    }
}