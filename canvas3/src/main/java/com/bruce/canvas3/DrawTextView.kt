package com.bruce.canvas3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  :
 * </pre>
 */
class DrawTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val mPaint = Paint() // 创建画笔
        mPaint.isAntiAlias = true
        mPaint.color = Color.BLACK // 设置颜色
        mPaint.style = Paint.Style.FILL // 设置样式
        mPaint.textSize = 50f // 设置字体大小

        // 文本(要绘制的内容)
        val str = "ABCDEFG"
        // 参数分别为 (文本 基线x 基线y 画笔)
        canvas?.drawText(str, 200f, 300f, mPaint)
        // 参数分别为 (字符串 开始截取位置 结束截取位置 基线x 基线y 画笔)
        canvas?.drawText(str, 1, 3, 200f, 500f, mPaint)

        // 字符数组(要绘制的内容)
        val chars = "ABCDEFG".toCharArray()
        // 参数为 (字符数组 起始坐标 截取长度 基线x 基线y 画笔)
        canvas?.drawText(chars, 1, 3, 200f, 600f, mPaint)
    }
}