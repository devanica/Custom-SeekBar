package com.application.customseekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customSeekBar.setPadding(0, 0, 0, 0)
        customSeekBar.setProgress(1)

        customSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (customSeekBar.getProgress() == 0) {
                    customSeekBar.setProgress(1)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                if (customSeekBar.getProgress() == 0) {
                    customSeekBar.setProgress(1)
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })
    }
}
