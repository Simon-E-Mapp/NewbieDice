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


    lateinit var randomNumber : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        randomNumber = findViewById(R.id.randomNumberInt)

        randomNumber.text = "Push the button to roll"

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val number = getMathRandom()
            setRandomNumber(number)
        }
    }


    fun setRandomNumber(number : Int){
        randomNumber.text = "$number"
    }
    fun getMathRandom() : Int{
        val number = (1..6).random()
        return number
    }
    }
