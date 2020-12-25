package com.bruce.path1

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/17
 *     desc  : BaseView
 * </pre>
 */
open class BaseView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val mPaint by lazy {
        // 创建画笔
        Paint().apply {
            color = android.graphics.Color.BLACK// 画笔颜色 - 黑色
            style = Paint.Style.STROKE // 填充模式 - 描边
            strokeWidth = 10f // 边框宽度 - 10
        }
    }

    var mWidth = 0
    var mHeight = 0

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
    }

}