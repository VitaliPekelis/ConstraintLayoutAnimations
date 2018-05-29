package com.lpirro.constraintlayoutanimations

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgActivity.setOnClickListener {
            startActivity(Intent(this, ImageActivity::class.java))
        }

        shopActivity.setOnClickListener {
            startActivity(Intent(this, ShoppingActivity::class.java))
        }

        carActivity.setOnClickListener {
            startActivity(Intent(this, CarouselActivity::class.java))
        }

        carousel_3.setOnClickListener{
            startActivity(Intent(this, CarouselOf3Activity::class.java))
        }

        speakerActivity.setOnClickListener {
            startActivity(Intent(this, SpeakerActivity::class.java))
        }

        nestActivity.setOnClickListener {
            startActivity(Intent(this, NestedActivity::class.java))
        }

        image_java_activity.setOnClickListener{
            startActivity(Intent(this, ImageJavaActivity::class.java))
        }

        circuit.setOnClickListener{
            startActivity(Intent(this, CircuitActivity::class.java))
        }
    }
}
