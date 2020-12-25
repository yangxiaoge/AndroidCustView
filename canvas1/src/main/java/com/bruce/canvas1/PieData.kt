package com.bruce.canvas1

/**
 * <pre>
 *     author: Bruce_Yang
 *     email : yangjianan@seuic.com
 *     time  : 2020/11/16
 *     desc  : 饼图数据实体类
 * </pre>
 */
class PieData(
    var name: String, //名字
    var value: Float //数值
) {
    var percentage: Float = 0f //百分比
    var color: Int = 0 //颜色
    var angle = 0f //角度
}