package com.application.customseekbar

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.AttributeSet
import android.widget.SeekBar
import androidx.localbroadcastmanager.content.LocalBroadcastManager

@SuppressLint("AppCompatCustomView")
class CustomSeekBar : SeekBar {
    private val paint: Paint = Paint()

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) :
            super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @Synchronized
    override fun onDraw(canvas: Canvas) {
        val thumb =
            (this.progress.toDouble() / this.max.toDouble()) *
                    (getWidth().toDouble() - (paddingEnd.toDouble()+paddingStart.toDouble()))

        paint.setColor(Color.WHITE)
        paint.setTextSize(50f)
        canvas.drawText(
            progress.toString(),
            convertToFloat(thumb),
            60f,
            paint
        )
        super.onDraw(canvas)
    }

    private fun convertToFloat(doubleValue: Double): Float {
        return doubleValue.toFloat()
    }
}