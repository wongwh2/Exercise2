package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{calculateBMI()}
        buttonReset.setOnClickListener{reset()}
    }

    private fun reset() {
        editTextHeight.text.clear()
        editTextWeight.text.clear()
        imageViewProfile.setImageResource(R.drawable.empty)
    }

    private fun calculateBMI() {
        val bmi:Double = editTextWeight.text.toString().toDouble() / ((editTextHeight.text.toString().toDouble()/100) * (editTextHeight.text.toString().toDouble()/100))

        when{
            bmi < 18.5 -> imageViewProfile.setImageResource(R.drawable.under)
            bmi > 18.5 && bmi < 24.9 -> imageViewProfile.setImageResource(R.drawable.normal)
            bmi > 25 -> imageViewProfile.setImageResource(R.drawable.over)
        }
        textViewBMI.text = String.format("BMI : %.2f",bmi)

    }
}
