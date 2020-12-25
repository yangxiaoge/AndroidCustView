package com.bruce.canvas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.bruce.base.Constants

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  : Canvas之画布操作
 * </pre>
 */
@Route(path = Constants.CANVAS2_PATH)
class Canvas2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas2)
    }
}