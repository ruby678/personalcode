package com.baidu.searchbox.aisearch.comps.drawable.flowing

import android.graphics.*
import com.example.lottieapplication.flowing.BaseMaterial
import kotlin.math.min

/**
 * @author liangjiaxing@baidu.com
 * @since 2023/3/23
 */
internal class Material2 : BaseMaterial() {

    override fun getStartColor(): Int {
        return Color.parseColor("#66B2EBFF")
    }

    override fun getEndColor(): Int {
        return  Color.parseColor("#00B2EBFF")
    }


    override fun change(fraction: Float) {
        // translation: 计算各个时刻的具体位置
        when (fraction) {
            in 0f..0.154f -> {
                val frac = fraction / 0.154f
                matrix.setTranslate(35 + 1162 * frac, -10 + 222 * frac)
            }
            in 0.154f..0.309f -> {
                val frac = (fraction - 0.154f) / (0.309f - 0.154f)
                matrix.setTranslate(1197 - 376 * frac, 212 + 1109 * frac)
            }
            in 0.309f..0.966f -> {
                val frac = (fraction - 0.309f) / (0.966f - 0.309f)
                matrix.setTranslate(821 + 872 * frac, 1321 + 864 * frac)
            }
            else -> {
                matrix.setTranslate(1693f, 2185f)
            }
        }
        when (fraction) {
            in 0f..0.315f -> {
                val frac = fraction / 0.315f
                matrix.postScale(
                    1.1f + 0.2f * frac,
                    1.1f + 0.2f * frac,
                    arrays[Matrix.MTRANS_X],
                    arrays[Matrix.MTRANS_Y]
                )
            }
            in 0.315f..0.656f -> {
                val frac = (fraction - 0.315f) / (0.656f - 0.315f)
                matrix.postScale(
                    1.3f - 0.3f * frac,
                    1.3f - 0.3f * frac,
                    arrays[Matrix.MTRANS_X],
                    arrays[Matrix.MTRANS_Y]
                )
            }
        }
        // alpha：计算各个时刻的具体透明度
        when (fraction) {
            in 0f..0.106f -> {
                val frac = fraction / 0.106f
                paint.alpha = (204 * frac).toInt()
            }
            in 0.106f..0.314f -> {
                val frac = (fraction - 0.107f) / (0.314f - 0.107f)
                paint.alpha = 204 + min(51, (51 * frac).toInt())
            }
            else -> {
                val frac = (fraction - 0.314f) / (1f - 0.314f)
                paint.alpha = 255 - min(255, (255 * frac).toInt())
            }
        }
        // 计算绘制位置
        calculatePos()
    }
}