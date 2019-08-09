package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_presentresult.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.System.err

class PresentResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentresult)
    }

    override fun onStart() {
        super.onStart()
        //Numbers
        setUpOnClickListenersNumbers()
        //operators
        setUpOnClickListenersOperators()
        //Empty the boxes
        deleteAllInTextViews()
        //delete a number
        deleteANumber()
        //Calculate expression when pressing "="
        calculateExpression()
    }
    override fun onStop() {
        super.onStop()
        emptyExpression()
        emptyResult()
    }
    fun emptyExpression(){
        expression.text = ""
    }
    fun emptyResult(){
        result.text = ""
    }
    fun calculateExpression(){
        equal.setOnClickListener{
            try {
                val expression = ExpressionBuilder(expression.text.toString()).build()
                val tempResult = expression.evaluate()
                val longResult = tempResult.toLong()
                if (tempResult == longResult.toDouble())
                    result.text= longResult.toString()
                else
                    result.text = tempResult.toString()

            } catch (e: Exception){
                err.print("Smth wrong")
            }
        }
    }
    fun deleteANumber(){
        deleteNumber.setOnClickListener {
            val string = expression.text.toString()
            if (string.isNotEmpty()) {
                expression.text = string.substring(0, string.length - 1)
            }
            emptyResult()
        }
    }
    fun deleteAllInTextViews(){
        CE.setOnClickListener {
            emptyExpression()
            emptyResult()
        }
    }
    fun setUpOnClickListenersNumbers(){
        one.setOnClickListener {appendOnExpression("1", true)}
        two.setOnClickListener {appendOnExpression("2", true)}
        three.setOnClickListener {appendOnExpression("3", true)}
        four.setOnClickListener {appendOnExpression("4", true)}
        five.setOnClickListener {appendOnExpression("5", true)}
        six.setOnClickListener {appendOnExpression("6", true)}
        seven.setOnClickListener {appendOnExpression("7", true)}
        eight.setOnClickListener {appendOnExpression("8", true)}
        nine.setOnClickListener {appendOnExpression("9", true)}
        zero.setOnClickListener {appendOnExpression("0", true)}
    }
    fun setUpOnClickListenersOperators(){
        addition.setOnClickListener {appendOnExpression("+", true)}
        minus.setOnClickListener {appendOnExpression("-", true)}
        multiplying.setOnClickListener {appendOnExpression("*", true)}
        divide.setOnClickListener {appendOnExpression("/", true)}
        leftParantesis.setOnClickListener {appendOnExpression("(", true)}
        rightParantesis.setOnClickListener {appendOnExpression(")", true)}
        dot.setOnClickListener{appendOnExpression(".",true)}
    }
    fun appendOnExpression(string : String, canClear : Boolean){
        if (canClear){
            emptyResult()
            expression.append(string)
        }else{
            expression.append(result.text)
            expression.append(string)
            emptyResult()
        }
    }
}
