package com.baidu.searchbox.aisearch.comps.drawable.flowing

import android.graphics.*
import com.example.lottieapplication.flowing.BaseMaterial
import kotlin.math.min

/**
 * @author liangjiaxing@baidu.com
 * @since 2023/3/23
 */
internal class Material6 : BaseMaterial() {

    override fun getStartColor(): Int {
        return Color.parseColor("#5CFFDBF5")
    }

    override fun getEndColor(): Int {
        return Color.parseColor("#00FFDBF5")
    }

    override fun change(fraction: Float) {
        when (fraction) {
            in 0f..0.25f -> {
                val frac = fraction / 0.25f
                matrix.setTranslate(-109 + 36 * frac, 630 + 310 * frac)
                matrix.postScale(
                    1f + 0.2f * frac,
                    1f + 0.2f * frac,
                    -109 + 36 * frac,
                    630 + 310 * frac
                )
            }
            in 0.25f..0.477f -> {
                val frac = (fraction - 0.25f) / (0.477f - 0.25f)
                matrix.setTranslate(-73 + 108 * frac, 940 + 930 * frac)
                matrix.postScale(
                    1.2f - 0.2f * frac,
                    1.2f - 0.2f * frac,
                    -73 + 108 * frac,
                    940 + 930 * frac
                )
            }
        }

        when (fraction) {
            in 0f..0.25f -> {
                val frac = fraction / 0.25f
                paint.alpha = min(255, (255 * frac).toInt())
            }
            in 0.368f..0.477f -> {
                val frac = (fraction - 0.368f) / (0.477f - 0.368f)
                paint.alpha = 255 - min(255, (255 * frac).toInt())
            }
        }

        calculatePos()
    }

}