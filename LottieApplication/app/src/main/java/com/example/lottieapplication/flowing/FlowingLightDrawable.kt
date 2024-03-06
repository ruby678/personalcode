package com.example.lottieapplication.flowing

import android.app.Activity
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.annotation.FloatRange
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.baidu.searchbox.aisearch.comps.drawable.flowing.*
import com.baidu.searchbox.aisearch.comps.drawable.flowing.Material1
import java.lang.ref.WeakReference
import java.util.*


private const val FRAMES = 60


private const val TOTAL_TIME = 15000

/**
 * 流光溢彩drawable
 * @author liangjiaxing@baidu.com
 * @since 2023/3/21
 */
class FlowingLightDrawable(val activity: Activity) : Drawable() {

    /** 每帧动画需要的时间 */
    private val animDuration = 1000L / FRAMES

    /** 是否可以渲染，用在pause和resume中 */
    @Volatile
    private var canRender = true

    /** 绘制素材列表 */
    private val renderList = mutableListOf<IFlowMaterial>(
        Material6(),
        Material5(),
        Material4(),
        Material3(),
        Material2(),
        Material1()
    )

    private var timer: Timer? = null


    override fun onBoundsChange(bounds: Rect?) {
        super.onBoundsChange(bounds)
        startAnimator()
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    /**
     * 开始动画
     */
    @MainThread
    private fun startAnimator() {
        if (timer == null) {
            timer = Timer("测试线程1111")
            timer?.schedule(InnerTimerTask(this), 0, animDuration)
        }
    }

    /**
     * @param fraction 动画进度
     */
    @WorkerThread
    fun change(@FloatRange(from = 0.0, to = 1.0) fraction: Float) {

        renderList.forEach {
            it.change(fraction)
        }
        // 绘制
        activity.window.decorView.post {
            invalidateSelf()
        }
    }

    override fun draw(canvas: Canvas) {
        Log.e("TAG", "draw: ")
        canvas.save()
        renderList.forEach {
            it.draw(canvas)
        }
        canvas.restore()
    }

    @MainThread
    fun onResume() {
        canRender = true
    }

    @MainThread
    fun onPause() {
        canRender = false
    }


    override fun setAlpha(alpha: Int) {
        // do nothing
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        // do nothing
    }

    fun onDestroy() {
        if (timer != null) {
            timer?.cancel()
            timer?.purge()
            timer = null
        }
    }

    internal class InnerTimerTask(drawable: FlowingLightDrawable) : TimerTask() {
        /** 弱引用 */
        private val ref = WeakReference(drawable)

        private var timeCounter = 0f

        private val animDuration = 1000 / FRAMES

        override fun run() {
            if (ref.get()?.canRender == true) {
                if (timeCounter > TOTAL_TIME) {
                    timeCounter = 0f
                }
                ref.get()?.change(timeCounter / TOTAL_TIME)
                timeCounter += animDuration
            }
        }
    }

}