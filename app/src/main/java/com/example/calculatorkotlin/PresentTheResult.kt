package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PresentTheResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addition(a: Int, b : Int)=a+b
    fun substraction(a: Int, b : Int)=a-b
    fun multiplication(a: Int, b : Int)=a*b
    fun division(a: Int, b : Int)=a/b

}
