package com.example.newbiedice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var pressButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        pressButton = findViewById(R.id.pressButton)
        pressButton.text = "Press the button to roll dice!"

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val number = (1..6).random()
            Log.d("Button testing", "Does the button work?")
        }
        fun setNumber(number : Int){
            pressButton.id = number
        }

    }
}