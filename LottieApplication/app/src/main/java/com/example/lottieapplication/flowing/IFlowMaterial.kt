package com.baidu.searchbox.aisearch.comps.drawable.flowing

import android.graphics.Canvas
import androidx.annotation.FloatRange

/**
 * @author liangjiaxing@baidu.com
 * @since 2023/3/23
 */
interface IFlowMaterial {

    fun change(@FloatRange(from = 0.0, to = 1.0) fraction: Float)

    fun draw(canvas: Canvas)

}