package com.baidu.searchbox.aisearch.comps.drawable.flowing

import android.graphics.*
import com.example.lottieapplication.flowing.BaseMaterial
import kotlin.math.min

/**
 * @author liangjiaxing@baidu.com
 * @since 2023/3/23
 */
internal class Material1 : BaseMaterial() {

    override fun getStartColor(): Int {
        return Color.parseColor("#7FB0B9FF")
    }

    override fun getEndColor(): Int {
        return Color.parseColor("#00B0B9FF")
    }

    override fun change(fraction: Float) {
        when (fraction) {
            in 0f..0.112f -> {
                val frac = fraction / 0.112f
                matrix.setTranslate(620 + 844 * frac, 556 - 1172 * frac)
                matrix.postScale(
                    1.4f - 0.112f * frac,
                    1.4f - 0.112f * frac,
                    620 + 844 * frac,
                    556 - 1172 * frac
                )
            }
            in 0.112f..0.565f -> {
                val frac = (fraction - 0.112f) / (0.565f - 0.112f)
                matrix.setTranslate(1464 - 2408 * frac, -616 + 2296 * frac)
                matrix.postScale(
                    1.288f - 0.288f * frac,
                    1.288f - 0.288f * frac,
                    1464 - 2408 * frac,
                    -616 + 2296 * frac
                )
            }
            in 0.565f..1f -> {
                val frac = (fraction - 0.565f) / (1f - 0.565f)
                matrix.setTranslate(-944 + 1564 * frac, 1680 - 1124 * frac)
                matrix.postScale(
                    1f + 0.4f * frac,
                    1f + 0.4f * frac,
                    -944 + 1564 * frac,
                    1680 - 1124 * frac
                )
            }
        }

        when (fraction) {
            in 0f..0.122f -> {
                val frac = fraction / 0.122f
                paint.alpha = 255 - min(255, (255 * frac).toInt())

            }
            in 0.563f..0.63f -> {
                val frac = (fraction - 0.563) / (0.63f - 0.563f)
                paint.alpha = min(255, (255 * frac).toInt())
            }
        }

        calculatePos()
    }

}