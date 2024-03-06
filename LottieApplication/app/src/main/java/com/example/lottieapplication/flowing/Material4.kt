package com.baidu.searchbox.aisearch.comps.drawable.flowing

import android.graphics.*
import com.example.lottieapplication.flowing.BaseMaterial
import kotlin.math.min

/**
 * @author liangjiaxing@baidu.com
 * @since 2023/3/23
 */
internal class Material4 : BaseMaterial() {

    override fun getStartColor(): Int {
        return Color.parseColor("#5CFCC8FF")
    }

    override fun getEndColor(): Int {
        return Color.parseColor("#00FCC8FF")
    }

    override fun change(fraction: Float) {
        when (fraction) {
            in 0.576f..0.84f -> {
                val frac = (fraction - 0.576f) / (0.84f - 0.576f)
                matrix.setTranslate(1612 - 552 * frac, 886 - 668 * frac)
                matrix.postScale(
                    1f + 0.2f * frac,
                    1f + 0.2f * frac,
                    1612 - 552 * frac,
                    886 - 668 * frac
                )
                paint.alpha = min(255, (255 * frac).toInt())
            }
            else -> {
                val frac = (fraction - 0.84f) / (1f - 0.84f)
                matrix.setTranslate(1060 - 800 * frac, 198 - 693 * frac)
                matrix.postScale(
                    1.2f - 0.2f * frac,
                    1.2f - 0.2f * frac,
                    1060 - 800 * frac,
                    198 - 693 * frac
                )
                paint.alpha = 255 - min(255, (255 * frac).toInt())
            }
        }

        calculatePos()
    }

}