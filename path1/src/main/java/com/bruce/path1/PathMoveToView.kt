package com.bruce.path1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
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
class PathMoveToView(context: Context?, attrs: AttributeSet?) : BaseView(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.translate(mWidth / 2f, mHeight / 2f)

            val path = Path()
            path.lineTo(200f, 200f)
            path.moveTo(200f, 100f)
            path.lineTo(200f, 0f)

            it.drawPath(path, mPaint)
        }
    }
}