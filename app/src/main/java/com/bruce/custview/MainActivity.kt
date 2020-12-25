package com.bruce.custview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.bruce.base.Constants
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 系列教程网址：https://www.gcssloop.com/category/customview
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        canvas1_btn.setOnClickListener {
            ARouter.getInstance().build(Constants.CANVAS1_PATH).navigation()
        }

        canvas2_btn.setOnClickListener {
            ARouter.getInstance().build(Constants.CANVAS2_PATH).navigation()
        }
        canvas3_btn.setOnClickListener {
            ARouter.getInstance().build(Constants.CANVAS3_PATH).navigation()
        }
        path1_btn.setOnClickListener {
            ARouter.getInstance().build(Constants.PATH1_PATH).navigation()
        }
        path2_btn.setOnClickListener {
            ARouter.getInstance().build(Constants.PATH2_PATH).navigation()
        }
    }
}