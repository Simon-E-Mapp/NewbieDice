package com.example.newbiedice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var greetingView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        greetingView = findViewById(R.id.greetingTextView)

        greetingView.text = "Push the button to roll"

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val number = getMathRandom()
            setGreetingText(number)
        }
    }


    fun setGreetingText(number : Int){
        greetingView.text = "$number"
    }
    fun getMathRandom() : Int{
        val number = (1..6).random()
        return number
    }
    }
