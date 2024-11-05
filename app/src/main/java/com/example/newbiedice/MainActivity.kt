package com.example.newbiedice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var countSide : EditText
    lateinit var randomNumber : TextView
    lateinit var diceOne : ImageView
    lateinit var diceTwo : ImageView
    lateinit var diceThree : ImageView
    lateinit var diceFour : ImageView
    lateinit var diceFive : ImageView
    lateinit var diceSix : ImageView
    lateinit var diceImages : List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        countSide = findViewById(R.id.sideCounterText)
        randomNumber = findViewById(R.id.randomNumberInt)
        diceOne = findViewById(R.id.imageView1)
        diceTwo = findViewById(R.id.imageView2)
        diceThree = findViewById(R.id.imageView3)
        diceFour = findViewById(R.id.imageView4)
        diceFive = findViewById(R.id.imageView5)
        diceSix = findViewById(R.id.imageView6)
        // Easier to work with lists but, lateinit var, findViewById is still needed
        diceImages = listOf(diceOne,diceTwo,diceThree,diceFour,diceFive,diceSix)

        randomNumber.text = "Push the button to roll"

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
        val number = getMathRandom()
        setRandomNumber(number)
        }
    }
            // Prints the number
    fun setRandomNumber(number : Int){
        randomNumber.text = "$number"
        diceImages.forEachIndexed {
            index, imageView -> imageView.visibility = if (index == number - 1)
                View.VISIBLE else View.INVISIBLE
        }
    }
            // sets the number value at random to be shown in setRandomNumber
    fun getMathRandom(): Int {
        val userInput = countSide.text.toString()

            // Checks if the number doesn't have a decimal in it
        val maxNumber = userInput.toIntOrNull()
        if (maxNumber != null && maxNumber > 0) {
            return (1..maxNumber).random()
        } else {
            // If the input is invalid or not written, do a log.e and use default (1..6)
            // Log.e = error as in java with (Exception e)
            Log.e("Number", "Invalid input, using default range (1..6).")
            return (1..6).random()
        }
    }
    }
