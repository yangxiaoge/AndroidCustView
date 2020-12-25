package com.bruce.canvas1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.min

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  : 自定义饼图
 * </pre>
 */
class PieView : View {
    // 画笔
    private val mPaint by lazy {
        Paint()
    }

    //颜色数组
    private val mColors = intArrayOf(
        -0x330100, -0x9b6a13, -0x1cd9ca, -0x800000, -0x7f8000, -0x7397, -0x7f7f80,
        -0x194800, -0x830a70, -0x8c5c33
    )

    // 饼状图初始绘制角度
    private var mStartAngle = 0f

    // 宽高
    private var mWidth = 0
    private var mHeight = 0

    // 数据
    private var mData: ArrayList<PieData>? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        mPaint.apply {
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
        Log.i("PieView", "width=$mWidth, height=$mHeight")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (mData == null)
            return
        //画布坐标原点移动到中心位置(宽高中最短的一半作为中心点)
        canvas.translate(min(mWidth, mHeight) / 2f, min(mWidth, mHeight) / 2f)
        //当前起点角度
        var currentAngle = mStartAngle
        // 饼状图半径
        val r = min(mWidth, mHeight) / 2 * 0.8f
        // 饼状图绘制区域
        val rectF = RectF(-r, -r, r, r)

        // 循环画饼图
        mData?.forEach {
            mPaint.color = it.color
            canvas.drawArc(rectF, currentAngle, it.angle, true, mPaint)
            currentAngle += it.angle
        }
    }

    // 设置数据
    fun setData(mData: ArrayList<PieData>) {
        this.mData = mData
        initData()
        invalidate() // 刷新
    }

    // 设置起始角度
    fun setStartAngle(mStartAngle: Int) {
        this.mStartAngle = mStartAngle.toFloat()
        invalidate() // 刷新
    }


    // 初始化数据
    private fun initData() {
        var sumValue = 0f
        mData?.forEachIndexed { index, pieData ->
            //计算数值和
            sumValue += pieData.value

            //设置饼图颜色
            pieData.color = mColors[index % mColors.size]
        }

        var sumAngle = 0f
        mData?.forEach {
            val percentage: Float = it.value / sumValue // 百分比
            val angle = percentage * 360 // 对应角度
            it.percentage = percentage
            it.angle = angle

            sumAngle += angle
        }
    }
}