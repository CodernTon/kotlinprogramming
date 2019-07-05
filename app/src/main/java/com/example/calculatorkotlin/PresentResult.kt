package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_presentresult.*

class PresentResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentresult)

        one.setOnClickListener {appendOnExpression("1", true)}

    }

    fun appendOnExpression(string : String, canClear : Boolean){
        if (canClear){
            result.text=""
            expression.append(string)
        }else{
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }
}
