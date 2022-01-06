package com.example.practice4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val click: Button = findViewById(R.id.inspect)
        val res: TextView = findViewById(R.id.rezult)
        val img: ImageView = findViewById(R.id.answer)
        var mm: Float

        click.setOnClickListener {
            mm = findViewById<EditText>(R.id.mm).getText().toString().toFloat()
            if (abs(findViewById<EditText>(R.id.km).getText().toString().toFloat() * 1000000 - mm) < 0.01 &&
                abs(findViewById<EditText>(R.id.m).getText().toString().toFloat() * 1000 - mm) < 0.01 &&
                abs(findViewById<EditText>(R.id.dm).getText().toString().toFloat() * 100 - mm) < 0.01 &&
                abs(findViewById<EditText>(R.id.sm).getText().toString().toFloat() * 10 - mm)< 0.01){
                res.text = getString(R.string.good)
                res.setTextColor(resources.getColor(R.color.purple_700))
                img.setImageResource(R.drawable.cool)}
            else{
            res.text = getString(R.string.bad)
            res.setTextColor(resources.getColor(R.color.red))
            img.setImageResource(R.drawable.bad)}
        }

        img.setOnTouchListener{ view, motionEvent ->
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                if(img.alpha < 0.2f)
                    img.alpha = 1f
                else img.alpha -= 0.1f
            true
        }
    }
}