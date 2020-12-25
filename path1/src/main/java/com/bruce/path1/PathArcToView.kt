package com.bruce.path1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/17
 *     desc  :
 * </pre>
 */
class PathArcToView(context: Context?, attrs: AttributeSet?) : BaseView(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            // 移动坐标系到屏幕中心
            canvas.translate(mWidth / 2f, mHeight / 2f)
            // <-- 注意 翻转y坐标轴
            canvas.scale(1f,-1f)

            val path = Path()
            path.lineTo(100f,100f)

            val oval = RectF(0f,0f,300f,300f)

            path.arcTo(oval,0f,270f)
//            path.arcTo(oval,0f,270f,false)

            canvas.drawPath(path,mPaint)
        }
    }
}