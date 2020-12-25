package com.bruce.path2_bezier

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.bruce.base.Constants

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/17
 *     desc  : Path之贝塞尔曲线
 * </pre>
 */
@Route(path = Constants.PATH2_PATH)
class Path2Activity : AppCompatActivity() {
    private lateinit var cubicToView: PathCubicToView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path2)

        cubicToView = findViewById(R.id.cubic_view)

    }

    fun control1(view: View) {
        cubicToView.setMode(true)
    }

    fun control2(view: View) {
        cubicToView.setMode(false)
    }
}