package com.baidu.searchbox.aisearch.comps.drawable.flowing

import android.graphics.*
import com.example.lottieapplication.flowing.BaseMaterial
import kotlin.math.min

/**
 * @author liangjiaxing@baidu.com
 * @since 2023/3/23
 */
internal class Material3 : BaseMaterial() {

    override fun getStartColor(): Int {
        return Color.parseColor("#66FFDCB9")
    }

    override fun getEndColor(): Int {
        return Color.parseColor("#00FFDCB9")
    }

    override fun change(fraction: Float) {
        when (fraction) {
            in 0.141f..0.242f -> {
                matrix.setTranslate(-369f, -417f)
            }
            in 0.242f..0.597f -> {
                val frac = (fraction - 0.242f) / (0.597f - 0.242f)
                matrix.setTranslate(-269 + 1495 * frac, -417 + 1487 * frac)
            }
            in 0.597f..0.89f -> {
                val frac = (fraction - 0.597f) / (0.89f - 0.597f)
                matrix.setTranslate(1226 - 1743 * frac, 1070 + 1399 * frac)
            }
            else -> {
                matrix.setTranslate(-517f, 2469f)
            }
        }
        // scale：计算各个时刻的具体缩放
        when (fraction) {
            in 0.243f..0.808f -> {
                val frac = (fraction - 0.243f) / (0.808f - 0.243f)
                matrix.getValues(arrays)
                matrix.postScale(
                    1.3f - 0.3f * frac,
                    1.3f - 0.3f * frac,
                    arrays[Matrix.MTRANS_X],
                    arrays[Matrix.MTRANS_Y]
                )
            }
            else -> {
                val frac = (fraction - 0.808f) / (1f - 0.808f)
                matrix.getValues(arrays)
                matrix.postScale(
                    1f + 0.3f * frac,
                    1f + 0.3f * frac,
                    arrays[Matrix.MTRANS_X],
                    arrays[Matrix.MTRANS_Y]
                )
            }
        }
        // alpha：计算各个时刻的具体透明度
        when (fraction) {
            in 0.141f..0.242f -> {
                val frac = (fraction - 0.141) / (0.242f - 0.141f)
                paint.alpha = min(255, (255 * frac).toInt())
            }
            in 0.597f..0.795f -> {
                val frac = (fraction - 0.597f) / (0.795f - 0.597f)
                paint.alpha = 255 - min(255, (255 * frac).toInt())
            }
        }

        calculatePos()
    }

}