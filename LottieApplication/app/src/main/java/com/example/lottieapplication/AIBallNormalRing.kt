package com.example.lottieapplication

import android.graphics.*
import android.os.Build
import android.util.Log
import androidx.annotation.IntRange
import androidx.annotation.MainThread
import com.baidu.assistant.uikit.interpolator.BezierInterpolator
import kotlin.math.sqrt


/** 线宽(dp) */
private const val STROKE_WIDTH = 0f

/** 播放一次完整动画的时间 */
private const val ONCE_RING_ANIM = 4800L

