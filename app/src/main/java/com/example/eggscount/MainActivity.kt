package com.example.eggscount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
// Mehraneh - 30062786 - AT1 - Activity 5
class MainActivity : AppCompatActivity() {
    // Define a variable for input by default value of null
    private var tvEnter: EditText? = null
    // The maximum number of digits
    private val maxDigits = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Assign the input value to the variable
        tvEnter = findViewById<EditText>(R.id.editText)
        // Define a variable for the button
        var btnEnter = findViewById<Button>(R.id.btnEnter)
        // When the button is clicked, calculate gross, dozen and unit
        btnEnter.setOnClickListener {
            // Define a variable for input value without space
            val inputText = tvEnter?.text.toString().trim()
            // To check if the variable is empty show an appropriate message.
            if (inputText.isEmpty()) {
                findViewById<TextView>(R.id.tvAlarm).text = "Please enter a number!"
                return@setOnClickListener
            }// To calculate if the input value is not a number
            try {// Call the function to clear all the text views
                clearTVs()
                // Define a variable for input number the check it to positive and less than 11
                // digits. After calculating the variables display them in the screen.
                val inputValue = inputText.toLong()
                if (inputValue >= 0 && inputValue < Math.pow(10.0, maxDigits.toDouble())) {
                    val gross = (inputValue / 144).toInt()
                    val dozen = ((inputValue % 144) / 12).toInt()
                    val unit = (inputValue % 12).toInt()

                    findViewById<TextView>(R.id.tvGross)?.text = "Gross: $gross"
                    findViewById<TextView>(R.id.tvDozen)?.text = "Dozen: $dozen"
                    findViewById<TextView>(R.id.tvUnit)?.text = "Unit: $unit"
                }else if (inputValue >= Math.pow(10.0, maxDigits.toDouble())) {
                    findViewById<TextView>(R.id.tvAlarm).text = "$inputValue is too big to calculate."
                } else
                {// if the variable is not positive display an appropriate message.
                    findViewById<TextView>(R.id.tvAlarm).text = "Please enter a positive number!"
                }// If the input value is not a number display an appropriate message.
            } catch (e: NumberFormatException) {
                findViewById<TextView>(R.id.tvAlarm).text =
                    "Invalid input. Please enter a valid number."
            }
        }
    }// Define a function to clear the text views.
    private fun clearTVs() {
        findViewById<TextView>(R.id.tvAlarm).text = ""
        findViewById<TextView>(R.id.tvGross)?.text = ""
        findViewById<TextView>(R.id.tvDozen)?.text = ""
        findViewById<TextView>(R.id.tvUnit)?.text =""
    }
}