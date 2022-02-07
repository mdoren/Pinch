package com.example.pinch

import android.icu.number.Scale
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView

lateinit var iv: ImageView
var scale = 1f

class MainActivity : AppCompatActivity() {

    var ourSD: ScaleGestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv = findViewById(R.id.idImg)
        ourSD = ScaleGestureDetector(this, ScaleListener())

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        ourSD!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    class ScaleListener: ScaleGestureDetector.SimpleOnScaleGestureListener(){
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector.scaleFactor
            scale = Math.max(0.1f, Math.min(scale, 5.0f))
            iv.scaleX = scale
            iv.scaleY = scale

            return true
        }
    }
}
