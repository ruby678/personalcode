package com.example.lottieapplication.flowing

import android.graphics.*
import androidx.annotation.ColorInt
import com.baidu.searchbox.aisearch.comps.drawable.flowing.IFlowMaterial

/** 半径px */
private const val RADIUS = 979f

/**
 * @author liangjiaxing@baidu.com
 * @since 2023/3/25
 */
abstract class BaseMaterial : IFlowMaterial {

    /** 操作矩阵 */
    protected val matrix = Matrix()

    private var radius = RADIUS

    protected val arrays = floatArrayOf(1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f)

    private var rx = 0f
    private var ry = 0f

    private val radialShader = RadialGradient(
        0f,
        0f,
        RADIUS,
        getStartColor(),
        getEndColor(),
        Shader.TileMode.CLAMP
    )

    protected var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        shader = radialShader
    }

    override fun draw(canvas: Canvas) {

//        canvas.drawRect(rx - radius, ry - radius, rx + radius, ry + radius, paint)
        canvas.drawCircle(rx, ry, radius, paint)
    }

    /**
     * 计算位置
     */
    protected fun calculatePos() {
        // 改变绘制位置
        radialShader.setLocalMatrix(matrix)
        matrix.getValues(arrays)
        // 最小绘制区域
        rx = arrays[Matrix.MTRANS_X]
        ry = arrays[Matrix.MTRANS_Y]
        radius = RADIUS * arrays[Matrix.MSCALE_X]
    }

    @ColorInt
    abstract fun getStartColor(): Int

    @ColorInt
    abstract fun getEndColor(): Int
}