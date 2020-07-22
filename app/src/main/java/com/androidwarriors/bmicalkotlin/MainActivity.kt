package com.androidwarriors.bmicalkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var weight: EditText
    lateinit var height: EditText
    lateinit var cal: Button
    lateinit var res: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val df = DecimalFormat("#.#")
        weight = findViewById<EditText>(R.id.edt_weight)
         height = findViewById<EditText>(R.id.edt_height)
         cal = findViewById<Button>(R.id.btn_cal)
         res = findViewById<TextView>(R.id.result_text)

        cal.setOnClickListener(View.OnClickListener { v ->

           calBmi(weight.text.toString().toDouble(),height.text.toString().toDouble()/3.281)

        })

    }

    fun calBmi(weight:Double, height: Double){

        val bmi  = weight/ (height*height)

        if(bmi<=18.5) {
            res.setText("$bmi\nYou are Underweight")
        } else if (bmi >=18.5 && bmi<=24.9)
            res.setText("$bmi\nYou are Normal")
        else if (bmi>=25)
            res.setText("$bmi\nYou are OverWeight")



    }

}