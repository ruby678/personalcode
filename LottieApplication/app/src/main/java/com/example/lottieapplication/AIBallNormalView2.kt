package com.example.lottieapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.os.SystemClock
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.annotation.MainThread
import com.baidu.assistant.uikit.interpolator.BezierInterpolator


/** 帧数 */
private const val FRAME = 30

/** 时间间隔 */
private const val DURATION = 1000L / FRAME

private const val ONCE_ANIM = 2400


