package com.example.myfirstlab
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdding()
        initSubtraction()
    }

    private fun convertResult(number: Double) : String{    //function of converting decimal result
        val decFormat = DecimalFormat("0.######")
        return decFormat.format(number).toString()
    }

    data class Numbers(val number1: Double, val number2: Double)    //data class for returning two values from function

    private fun getNumbers(): Numbers{         //function of getting numbers from View
        val number1 = number1.text.toString().toDouble()
        val number2 = number2.text.toString().toDouble()
        return Numbers(number1,number2)

    }

    private fun initAdding() = buttonAdding.setOnClickListener{     //function of adding two numbers
        if (number1.text.isEmpty() || number2.text.isEmpty()){
            result.text = "Заполните два поля!"
        }else{
            val(number1, number2) = getNumbers()
            val resultOfAdding = number1 + number2
            result.text = convertResult(java.lang.Double.valueOf(resultOfAdding))
        }
    }

    private fun initSubtraction() = buttonSubtraction.setOnClickListener{   //function of subtraction two numbers
        if (number1.text.isEmpty() || number2.text.isEmpty()){
            result.text = "Заполните два поля!"
        }else {
            val (number1, number2) = getNumbers()
            val resultOfSubtraction = number1 - number2
            result.text = convertResult(java.lang.Double.valueOf(resultOfSubtraction))
        }
    }

    fun initMultiplication(view: View) {  //function of multiplication two numbers
        if (number1.text.isEmpty() || number2.text.isEmpty()){
            result.text = "Заполните два поля!"
        }else {
            val (number1, number2) = getNumbers()
            val resultOfMultiplication = number1 * number2
            result.text = convertResult(java.lang.Double.valueOf(resultOfMultiplication))
        }
    }

    fun initDivision(view: View) {   //function of division two numbers
        if (number1.text.isEmpty() || number2.text.isEmpty()){
            result.text = "Заполните два поля!"
        } else {
            val (number1, number2) = getNumbers()
            if (number2 == 0.toDouble()) {
                result.text = "Делить на 0 нельзя"
            } else {
                val resultOfDivision = number1 / number2
                result.text = convertResult(java.lang.Double.valueOf(resultOfDivision))
            }
        }
    }

}
