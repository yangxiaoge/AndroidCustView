package com.bruce.canvas1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.bruce.base.Constants

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  : Canvas之绘制图形
 * </pre>
 */
@Route(path = Constants.CANVAS1_PATH)
class Canvas1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas1)

        val pieView: PieView = findViewById(R.id.pie_view)
        // 设置起始角度为0
        pieView.setStartAngle(0)
        //设置数据集
        setData(pieView, 6)

        val angleRandom = intArrayOf(0, 45, 90, 135, 180, 225, 270, 315, 360)
        findViewById<Button>(R.id.angle_btn).setOnClickListener {
            val roundToInt = angleRandom.random()
            pieView.setStartAngle(roundToInt)
            Toast.makeText(this, "$roundToInt°", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.data_size_btn).setOnClickListener {
            val dataSizeRandom = (1..10).random()
            setData(pieView, dataSizeRandom)
            Toast.makeText(this, "${dataSizeRandom}个", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setData(pieView: PieView, dataSize: Int) {
        val mData: ArrayList<PieData> = ArrayList()
        for (i in 1..dataSize) {
            mData.add(PieData("name$i", i * 1.5f))
        }
        //设置数据集
        pieView.setData(mData)
    }
}