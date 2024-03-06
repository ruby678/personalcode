package com.example.lottieapplication

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import kotlin.math.roundToInt


/** 线宽 */
private const val STROKE_WIDTH = 1f

/** 帧数 */
private const val FRAME = 20

/** 时间间隔 */
private const val DURATION = 1000L / FRAME

/** 执行一次动画需要的时间 */
private const val ONCE_ANIM = 2400L

