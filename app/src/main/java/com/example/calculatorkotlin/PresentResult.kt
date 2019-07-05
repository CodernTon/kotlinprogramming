package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class PresentResult : AppCompatActivity(),View.OnClickListener {

    lateinit var addNumbers: Button;
    lateinit var substracNumber: Button;
    lateinit var divideNumber: Button;
    lateinit var multiplyNumber: Button;
    lateinit var inputNumber: EditText;
    lateinit var outputNumber: TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentresult)

        addNumbers = findViewById(R.id.addNumbers)
        substracNumber = findViewById(R.id.substractNumbers)
        divideNumber = findViewById(R.id.divideNumbers)
        multiplyNumber = findViewById(R.id.multiplyNumbers)
        inputNumber = findViewById(R.id.inputNumbers)
        outputNumber = findViewById(R.id.OutputNumbers)
        addNumbers.setOnClickListener(this);
    }
    override fun onClick(view: View?){
        var number = 5
        presentNumbers(number)
    }

    fun presentNumbers(result: Int) {
        //outputNumbers.text = result
        outputNumber.text = "Result are: $result"
    }


    fun addition(a: Int, b : Int)=a+b
    fun substraction(a: Int, b : Int)=a-b
    fun multiplication(a: Int, b : Int)=a*b
    fun division(a: Int, b : Int)=a/b

}
