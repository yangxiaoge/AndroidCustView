package com.bruce.custview

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  :
 * </pre>
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) { // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }
}