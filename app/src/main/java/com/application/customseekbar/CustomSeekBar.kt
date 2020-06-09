package com.application.customseekbar

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.SeekBar

@SuppressLint("AppCompatCustomView")
class CustomSeekBar : SeekBar {
    private val paint: Paint = Paint()

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    @Synchronized
    override fun onDraw(canvas: Canvas) {
        /**these are fractions:
         * getProgress()        getWidth()
         *     ---        *       ---       =   55.2 (in our case)
         *   getMax()              1
         */
        val thumb =
            this.progress.toDouble() / this.max * getWidth().toDouble()

        paint.setColor(Color.RED)
        paint.setTextSize(50f)
        canvas.drawText(
            progress.toString(),
            convertToFloat(thumb) - 70,
            60f,
            paint
        )
        super.onDraw(canvas)
    }

    private fun convertToFloat(doubleValue: Double): Float {
        return doubleValue.toFloat()
    }
}