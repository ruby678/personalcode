package com.baidu.searchbox.aisearch.comps.drawable.flowing

import android.graphics.*
import com.example.lottieapplication.flowing.BaseMaterial
import kotlin.math.min

/**
 * @author liangjiaxing@baidu.com
 * @since 2023/3/23
 */
internal class Material5 : BaseMaterial() {

    override fun getStartColor(): Int {
        return Color.parseColor("#5CFDC8E5")
    }

    override fun getEndColor(): Int {
        return Color.parseColor("#00FDC8E5")
    }

    override fun change(fraction: Float) {
        when (fraction) {
            in 0f..0.28f -> {
                val frac = fraction / 0.28f
                matrix.setTranslate(-363 + 1223 * frac, -441 + 1542 * frac)
                matrix.postScale(
                    1.4f - 0.4f * frac,
                    1.4f - 0.4f * frac,
                    -363 + 1223 * frac,
                    -441 + 1542 * frac
                )
            }
            in 0.28f..0.72f -> {
                val frac = (fraction - 0.28f) / (0.72f - 0.28f)
                matrix.setTranslate(860 + 984 * frac, 1101 - 824 * frac)
                matrix.postScale(
                    1f + 0.2f * frac,
                    1f + 0.2f * frac,
                    860 + 984 * frac,
                    1101 - 824 * frac
                )
            }
        }

        when (fraction) {
            in 0f..0.067f -> {
                val frac = fraction / 0.067f
                paint.alpha = min(255, (255 * frac).toInt())
            }
            in 0.552f..0.72f -> {
                val frac = fraction / 0.067f
                paint.alpha = 255 - min(255, (255 * frac).toInt())
            }
        }

        calculatePos()
    }

}